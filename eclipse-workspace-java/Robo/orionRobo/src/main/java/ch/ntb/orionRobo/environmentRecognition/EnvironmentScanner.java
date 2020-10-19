/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.environmentRecognition.environmentScaner.java
 * 
 * @author Basile Schoeb <basile.schoeb@ntb.ch>
 * @author Tim Helbock <timdominik.helbock@ntb.ch>
 * 
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Copyright (c) 2018 NTB Systemtechnikprojekt Team 7
 */

package ch.ntb.orionRobo.environmentRecognition;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import ch.ntb.orionRobo.RoboPinOut;
import ch.ntb.orionRobo.Robo;
import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.drive.Drive;
import ch.ntb.orionRobo.drive.Vector;
import ch.ntb.orionRobo.environmentRecognition.Point.PointType;
import ch.ntb.orionRobo.component.BNO055;
import ch.ntb.orionRobo.component.BNO055.opmode_t;
import ch.ntb.orionRobo.component.BNO055.vector_type_t;
import ch.ntb.orionRobo.component.Servo;
import ch.ntb.orionRobo.component.VL53L1X;
import ch.ntb.orionRobo.component.VL53L1X.DistanceMode;
import ch.ntb.orionRobo.component.DCMotor.Motor;
import ch.ntb.orionRobo.component.pca.PCA9685Pin;
import ch.ntb.orionRobo.Robo;
import ch.ntb.orionRobo.PartnerRobo;

/**
 * 
 */
public class EnvironmentScanner implements Runnable {

	private static final Logger LOGGER = LogManager.getLogger(EnvironmentScanner.class.getName());

	private List<Point> points = new ArrayList<Point>();
	Servo servoTof;
	List<VL53L1X> tofs = new ArrayList<VL53L1X>();
	BNO055 gyro;
	Motor motorLeft;
	Motor motorRight;

	GpioPinDigitalOutput pinTOF1;
	GpioPinDigitalOutput pinTOF2;

	boolean scanDirection = false;
	int scanningDelay = 20;
	float stepResolution = 0.25f;
	double offsetAngleTOFtoRobo = -90;

	public int getScanningDelay() {
		return scanningDelay;
	}

	public void setScanningDelay(int scanningDelay) {
		this.scanningDelay = scanningDelay;
	}

	public EnvironmentScanner() throws UnsupportedBusNumberException, IOException, InterruptedException, Exception {
		// GpioController gpio = GpioFactory.getInstance();

		pinTOF1 = RoboPinOut.gpio.provisionDigitalOutputPin(RoboPinOut.TOF1_xshot, "TOF 1", PinState.LOW);
		pinTOF2 = RoboPinOut.gpio.provisionDigitalOutputPin(RoboPinOut.TOF2_xshot, "TOF 2", PinState.LOW);

		// this.gyro = BNO055.getInstance(opmode_t.OPERATION_MODE_AMG,
		// vector_type_t.VECTOR_MAGNETOMETER);

		// servoTof = new Servo(PCA9685Pin.PWM_01, 1500, 900, 2000, 120.0f);
		servoTof = new Servo(PCA9685Pin.PWM_01, 1600, 900, 2625, 180.0f);

		// this.motorLeft = motorLeft;
		// this.motorRight = motorRight;

	}

	public void init() throws Exception {

		try {
			servoTof.setServoDegree(0);
			Thread.sleep(5);

			pinTOF1.low();
			pinTOF2.low();
			// Thread.sleep(50);
			tofs.add(new VL53L1X(0x2b));
			pinTOF2.high();
			// Thread.sleep(50);
			tofs.add(new VL53L1X(0x2a));
			pinTOF1.high();
			Thread.sleep(50);
			// tofs.add(new VL53L1X());

			for (VL53L1X tof : tofs) {
				tof.SetOffset(35);
				tof.SetDistanceMode(DistanceMode.Long);

				tof.SetROI(4, 4);

			}

			/*
			 * Roboter Position/Ausrichtung in Feld setzen
			 */
			// servoTof.setServoDegree(120);

			// while(gyro.isInitialized())
			// {
			// Thread.sleep(100);
			// }
			// while(gyro.isCalibrated())
			// {
			// Thread.sleep(100);
			// }
			// LOGGER.debug(gyro.getVector()[2]);
			// LOGGER.debug(gyro.getHeading());

		} catch (Exception e) {
			LOGGER.error(e);
		}

		// scanOnce();
		// RoboControl.robo.setPosition(getStartpoint());
		// Drive drive = new Drive();
		// RoboControl.drive.turn((float) RoboControl.robo.getPosition().getDegree() +
		// 90);
		// RoboControl.robo.getPosition().setServoDegree(90);
		// RoboControl.robo.setStartvector(new Vector(-1,0));

		// scanOnce();

		// Field.setPointsAfterAlignment(scanOnce());
		// Field.setMultipleObjectsByPoints();
		// Field.setPartnerRoboByPartnerPoint(RoboControl.partnerRobo.getPosition());

	}

	private Point creatPoint(float degree, int distance) throws IOException {
		double roboX = RoboControl.robo.getPosition().getxCoordinate();
		double roboY = RoboControl.robo.getPosition().getyCoordinate();
		Point point = new Point(
				Math.round((Math.cos(Math.toRadians(degree + offsetAngleTOFtoRobo)) * distance) + roboX),
				Math.round((Math.sin(Math.toRadians(degree + offsetAngleTOFtoRobo)) * distance) + roboY), null, degree);
		return point;

	}

	public Point getStartpoint(List<Point> points) {
		// Diese Methode funktioniert so nur, wenn der Roboter rechts vom Spielfeld
		// steht.
		// Breite Spielfeld: 760mm
		double xDist = 1000000;
		double yDist = 1000000;
		for (int i = 0; i < points.size(); i++) {
			if (xDist > points.get(i).getxCoordinate()) {
				xDist = points.get(i).getxCoordinate();
			}
			if (yDist > points.get(i).getyCoordinate()) {
				yDist = points.get(i).getyCoordinate();
			}
		} // kürzester x-Wert muss von Spielfeldbreite abgezogen werden.
		return new Point(760 - xDist, yDist, Point.PointType.ROBO);
	}

	/**
	 * Startet scan methode in einem thread und aktualisiert die Felddaten
	 */
	public void rescan() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void getTofDistance() throws IOException {
		for (VL53L1X tof : tofs) {
			tof.StartRanging();
		}

		for (VL53L1X tof : tofs) {
			int distance = tof.GetDistance();

			LOGGER.debug("Degree: " + "   I2CAddress: " + tof.getAddress() + "   distance: " + distance + " offset: "
					+ (80 - distance));
		}

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Point> scanOnce() throws Exception {
		List<Point> points = new ArrayList<Point>();
		int minDistance = 110;
		scanDirection = false;
		
		servoTof.setServoDegree(0);
		for (VL53L1X tof : tofs) {
			tof.StartRanging();
		}
		// Evtl new Vector auf (1,0)
		float roboDegree = (float) RoboControl.robo.getPosition().getDegree();

		Thread.sleep(50);
		if (!scanDirection) {
			for (float a = 0.0f; a <= 180.0f; a += stepResolution) {
				float degree = a;
				servoTof.setServoDegree(a);
				for (VL53L1X tof : tofs) {
					int distance = tof.GetDistance() + 31;
					if (distance > minDistance) {

						int[] localDistanceArray = new int[10];
						for (int i = 0; i < localDistanceArray.length - 1; i++) {

							localDistanceArray[i] = tof.GetDistance() + 31;

						}

						Arrays.sort(localDistanceArray);
						distance = localDistanceArray[(localDistanceArray.length / 2) - 1];

						points.add(creatPoint(degree + roboDegree, distance));
//						LOGGER.debug("Degree: " + degree + "   I2CAddress: " + tof.getAddress() + "   distance: "
//								+ distance);
					}
					degree += 180.0f;
				}
				Thread.sleep(scanningDelay);
			}
			Thread.sleep(1000);
			servoTof.setServoDegree(0);
			//scanDirection = true;
		} else {
			for (float a = 180.0f; a >= 0.0f; a -= stepResolution) {
				float degree = a;
				servoTof.setServoDegree(a);
				for (VL53L1X tof : tofs) {
					int distance = tof.GetDistance() + 31;
					if (distance > minDistance) {
						points.add(creatPoint(degree + roboDegree, distance));
						LOGGER.debug("Degree: " + degree + "   I2CAddress: " + tof.getAddress() + "   distance: "
								+ distance);
					}
					degree += 180.0f;
				}
				Thread.sleep(scanningDelay);
			}
			scanDirection = false;
		}

//		for (Point item : points) {
//
//			LOGGER.debug("Point X Koordinate" + item.getxCoordinate());
//			LOGGER.debug("Point Y Koordinate" + item.getyCoordinate());
//		}

		return points;
	}

	public void scanOnceForAlignmentAngle(int TofNumberCloseToYAxisWall) throws Exception {
		List<Point> points = new ArrayList<Point>();
		VL53L1X TofCloseToYAxisWall = tofs.get(TofNumberCloseToYAxisWall);
		double alignmentAngle = 0;

		TofCloseToYAxisWall.StartRanging();

		// Evtl new Vector auf (1,0)
		RoboControl.robo.getPosition().setDegree(0);
		float roboDegree = (float) RoboControl.robo.getPosition().getDegree();

		Thread.sleep(50);
		if (!scanDirection) {
			for (float a = 0.0f; a <= 180.0f; a += stepResolution) {
				float degree = a;
				servoTof.setServoDegree(a);

				int distance = TofCloseToYAxisWall.GetDistance() + 31;
				points.add(new Point(distance, degree));
				LOGGER.debug("Degree: " + a + "   I2CAddress: " + TofCloseToYAxisWall.getAddress() + "   distance: "
						+ distance);

				Thread.sleep(scanningDelay);
			}
			scanDirection = true;
		} else {
			for (float a = 180.0f; a >= 0.0f; a -= stepResolution) {
				float degree = a;
				servoTof.setServoDegree(a);

				int distance = TofCloseToYAxisWall.GetDistance() + 31;
				points.add(new Point(distance, degree));
				LOGGER.debug("Degree: " + a + "   I2CAddress: " + TofCloseToYAxisWall.getAddress() + "   distance: "
						+ distance);

				Thread.sleep(scanningDelay);
			}
			scanDirection = false;
		}

		Point alignmentPoint = points.get(0);
		for (Point item : points) {

			if (item.getDistance() < alignmentPoint.getDistance()) {

				alignmentPoint = item.getParent();
			}

		}

		alignmentAngle = alignmentPoint.getDegree();
		RoboControl.robo.getPosition().setDegree(alignmentAngle);

	}

	/**
	 * Init scan um Position und winkel des Roboter und setzt die in die Robo Klasse
	 * 
	 * @throws Exception
	 */
	public void scanOnceForAlignment() throws Exception {
		List<Point> points = new ArrayList<Point>();
		int minDistance = 100;
		int angleTolerance = 20;

		for (VL53L1X tof : tofs) {
			tof.StartRanging();
		}
		// Evtl new Vector auf (1,0)
		float roboDegree = (float) RoboControl.robo.getPosition().getDegree();

		Thread.sleep(50);
		if (!scanDirection) {
			for (float a = 0.0f; a <= 180.0f; a += stepResolution) {
				float degree = a;
				servoTof.setServoDegree(a);
				for (VL53L1X tof : tofs) {
					int distance = tof.GetDistance() + 31;
					if (distance > minDistance) {
						points.add(new Point(distance, degree));
						LOGGER.debug("Degree: " + degree + "   I2CAddress: " + tof.getAddress() + "   distance: "
								+ distance);
					}
					degree += 180.0f;
				}
				Thread.sleep(scanningDelay);
			}
			scanDirection = true;
		} else {
			for (float a = 180.0f; a >= 0.0f; a -= stepResolution) {
				float degree = a;
				servoTof.setServoDegree(a);
				for (VL53L1X tof : tofs) {
					int distance = tof.GetDistance() + 31;
					if (distance > minDistance) {
						points.add(new Point(distance, degree));
						LOGGER.debug("Degree: " + degree + "   I2CAddress: " + tof.getAddress() + "   distance: "
								+ distance);
					}
					degree += 180.0f;
				}
				Thread.sleep(scanningDelay);
			}
			scanDirection = false;
		}

		Point localAlignmentPoint1 = new Point(99999, 0.0);
		Point localAlignmentPoint2 = new Point(99999, 0.0);

		LOGGER.debug("AlignmentPoint 1 before Distance : " + localAlignmentPoint1.getDistance());
		LOGGER.debug("AlignmentPoint 1 before Degree : " + localAlignmentPoint1.getDegree());
		LOGGER.debug("AlignmentPoint 2 before Distance : " + localAlignmentPoint2.getDistance());
		LOGGER.debug("AlignmentPoint 2 before Degree : " + localAlignmentPoint2.getDegree());

		for (Point item : points) {

			if (item.getDistance() < localAlignmentPoint1.getDistance() && item.getDegree() > 225
					&& item.getDegree() < 315) {

				localAlignmentPoint1 = item;

			}

			double localSearchAreaLower = localAlignmentPoint1.getDegree() - 270 - angleTolerance;
			double localSearchAreaUpper = localSearchAreaLower + angleTolerance;

			if (localSearchAreaLower > 360) {

				localSearchAreaLower = 360 - localSearchAreaLower;
			}

			else if (localSearchAreaLower < 0) {

				localSearchAreaLower = 360 + localSearchAreaLower;
			}

			if (localSearchAreaUpper > 360) {

				localSearchAreaUpper = 360 - localSearchAreaLower;
			}

			else if (localSearchAreaUpper < 0) {

				localSearchAreaUpper = 360 + localSearchAreaLower;
			}

			if (item.getDistance() < localAlignmentPoint2.getDistance() && item.getDegree() > localSearchAreaLower
					&& item.getDegree() < localSearchAreaUpper) {

				localAlignmentPoint2 = item;

			}

		}

//		
//		if (localAlignmentPoint2.getDegree() > 150 && localAlignmentPoint2.getDegree() < 210) {
//
//			RoboControl.robo.getPosition().setXCoordinate(localAlignmentPoint2.getDistance());
//		}
//
//		else {

		RoboControl.robo.getPosition().setXCoordinate((760 - localAlignmentPoint2.getDistance()));
		// }

		RoboControl.robo.getPosition().setYCoordinate(localAlignmentPoint1.getDistance());
		RoboControl.robo.getPosition()
				.setDegree(270 - localAlignmentPoint1.getDegree() + RoboControl.robo.getPosition().getDegree());

		LOGGER.debug("localAlignmentPoin1 : " + localAlignmentPoint1.getDegree());
		LOGGER.debug("currenRoboAngle : " + RoboControl.robo.getPosition().getDegree());
		LOGGER.debug("270° : " + 270);

		double localAlignmentValue = 270 - localAlignmentPoint1.getDegree()
				+ RoboControl.robo.getPosition().getDegree();

		LOGGER.debug("localAlignmentPoin1 : " + localAlignmentPoint1.getDegree());
		LOGGER.debug("currenRoboAngle : " + RoboControl.robo.getPosition().getDegree());
		LOGGER.debug("Angle for Alignment : " + localAlignmentValue);

		LOGGER.debug("AlignmentPoint 1 after Distance : " + localAlignmentPoint1.getDistance());
		LOGGER.debug("AlignmentPoint 1 after Degree : " + localAlignmentPoint1.getDegree());
		LOGGER.debug("AlignmentPoint 2 after Distance : " + localAlignmentPoint2.getDistance());
		LOGGER.debug("AlignmentPoint 2 after Degree : " + localAlignmentPoint2.getDegree());

		LOGGER.debug("RoboAngle after Alignment: " + RoboControl.robo.getPosition().getDegree());
		LOGGER.debug("RoboAngle X-Koordinate : " + RoboControl.robo.getPosition().getxCoordinate());
		LOGGER.debug("RoboAngle Y-Koordinate : " + RoboControl.robo.getPosition().getyCoordinate());

	}

	public static void testAlignment() {

		List<Point> points = new ArrayList<Point>();

		for (int i = 0; i < 90; i++) {

			if (i <= 50) {

				points.add(new Point(10 + i, i + 0.0));
				points.add(new Point(9 + i, i + 270.0));

			}

			if (i > 50) {

				points.add(new Point(111 - i, 270.0 + i));
				points.add(new Point(60 + i, 270.0 - i));

			}

		}

		for (Point item : points) {

			System.out.println("Distance: " + item.getDistance());
			System.out.println("Degree: " + item.getDegree());
		}

		Point localAlignmentPoint1 = points.get(0);
		Point localAlignmentPoint2 = points.get(0);

		System.out.println("Distance AlignmentPoint1 " + localAlignmentPoint1.getDistance());
		System.out.println("Distance AlignmentPoint2 " + localAlignmentPoint2.getDistance());

		for (Point item : points) {
			System.out.println("Distance " + item.getDistance());

			if (item.getDistance() < localAlignmentPoint1.getDistance()) {

				localAlignmentPoint1 = item;

				if (item.getDistance() < localAlignmentPoint2.getDistance()
						&& item.getDegree() > localAlignmentPoint1.getDegree() + 180
						&& item.getDegree() < localAlignmentPoint1.getDegree() + 300) {

					localAlignmentPoint2 = item;

				}

				else if (item.getDistance() < localAlignmentPoint2.getDistance()
						&& item.getDegree() > localAlignmentPoint1.getDegree() + 320
						&& item.getDegree() < localAlignmentPoint1.getDegree() + 180) {

					localAlignmentPoint2 = item;

				}

			}

		}
		Point testPoint = new Point(0, 0, PointType.UNKNOWN);

		if (localAlignmentPoint1.getDegree() > 320 && localAlignmentPoint1.getDegree() < 180) {

			testPoint.setXCoordinate(localAlignmentPoint1.getDistance() * Math.cos(localAlignmentPoint1.getDegree()));
			testPoint.setDegree(localAlignmentPoint1.getDegree());

		}

		else if (localAlignmentPoint1.getDegree() > 180 && localAlignmentPoint1.getDegree() < 300) {

			RoboControl.robo.getPosition()
					.setYCoordinate(localAlignmentPoint1.getDistance() * Math.sin(localAlignmentPoint1.getDegree()));

		}

		if (localAlignmentPoint2.getDegree() > 320 && localAlignmentPoint2.getDegree() < 180) {

			RoboControl.robo.getPosition()
					.setXCoordinate(localAlignmentPoint2.getDistance() * Math.cos(localAlignmentPoint2.getDegree()));
			RoboControl.robo.getPosition().setDegree(localAlignmentPoint1.getDegree());

		}

		else if (localAlignmentPoint2.getDegree() > 180 && localAlignmentPoint2.getDegree() < 300) {

			RoboControl.robo.getPosition()
					.setYCoordinate(localAlignmentPoint2.getDistance() * Math.sin(localAlignmentPoint2.getDegree()));

		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void scan() throws Exception {
		List<Point> points = scanOnce();
		RoboControl.field.setPointsAfterAlignment(points, RoboControl.field.fieldResolution);
		RoboControl.field.setMultipleObjectsByPoints();
		//RoboControl.field.printfieldinint(RoboControl.field.field);

	}

	public void run() {
		try {

			scan();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public static void main(String[] args) throws Exception {

		EnvironmentScanner envScan = new EnvironmentScanner();
		envScan.init();
		envScan.scanOnce();

		while (true) {
			Thread.sleep(2000);
		}

	}

	public List<Point> getList() {

		return points;

	}

}
