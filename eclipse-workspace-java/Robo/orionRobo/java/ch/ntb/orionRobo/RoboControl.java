/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.environmentRecognition.environmentScaner.java
 * 
 * @author Basile Schoeb <basile.schoeb@ntb.ch>
 * @author Pedro Stark <pedro.stark@ntb.ch>
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

package ch.ntb.orionRobo;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.pi4j.io.gpio.GpioFactory;

import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformManager;

import ch.ntb.orionRobo.Robo.Status;

import ch.ntb.orionRobo.component.VoiceCoil;
import ch.ntb.orionRobo.drive.AStar;
import ch.ntb.orionRobo.drive.Drive;
import ch.ntb.orionRobo.drive.DrivingPoint;
import ch.ntb.orionRobo.drive.RouteCalculator;
import ch.ntb.orionRobo.environmentRecognition.EnvironmentScanner;
import ch.ntb.orionRobo.environmentRecognition.Field;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.environmentRecognition.Point.PointType;
import ch.ntb.orionRobo.networking.NTB_RN131_Wifi;
import ch.ntb.orionRobo.networking.webService.WebService;

/**
 * 
 */
public class RoboControl implements Runnable {
	private static boolean autonomus = false;
	private static Thread autonomousThread = null;

	public static RoboControl roboControl = null;

	public static Robo robo = null;
	public static PartnerRobo partnerRobo = null;
	public static Field field = null;
	private final Point[][] possiblePosition;
	private static final Logger LOGGER = LogManager.getLogger(RoboControl.class.getName());

	public static Properties prop = new Properties();

	public static EnvironmentScanner envScan = null;
	public static VoiceCoil voiceCoil = null;
	public static NTB_RN131_Wifi partnerCom = null;
	public static Drive drive = null;
	public int ballshot = 0;
	public int ballcatched = 0;
	public int drivePosition = 0;

	private final int FinalPointRows = 2;
	private final int FinalPointCols = 2;
	private boolean routeFound;

	/**
	 * Start Method for Coilinator
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			roboControl = new RoboControl();
			roboControl.startAutonomouslyMode();

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	/**
	 * RoboControl Constructor
	 * 
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public RoboControl() throws InterruptedException, Exception {

		PlatformManager.setPlatform(Platform.RASPBERRYPI);
		initProperties();
		initCommunicationServie();

		// erst wen kommunikation gestartet ist
		field = new Field();
		robo = new Robo(PointType.ROBO);
		partnerRobo = new PartnerRobo(PointType.PARTNER_ROBO);
		int firstFinalPointX = (int) (Math.round(380) / field.fieldResolution);
		int firstFinalPointY = (int) (Math.round(366.5) / field.fieldResolution);
		int DistanceFinalPointX = (int) (Math.round(242.5) / field.fieldResolution);
		int DistanceFinalPointY = (int) (Math.round(522) / field.fieldResolution);
		possiblePosition = setpossiblePositions(firstFinalPointX, firstFinalPointY, DistanceFinalPointX,
				DistanceFinalPointY, FinalPointRows, FinalPointCols);
		robo.setStatus(Status.INITIALIZING);

		envScan = new EnvironmentScanner();
		envScan.init();

		voiceCoil = new VoiceCoil();
		voiceCoil.setCalibrationValue(stringToLongArray(prop.getProperty("voicecoilCalibrationTimes")),
				stringToLongArray(prop.getProperty("voicecoilCalibrationDistances")));

		drive = new Drive();

	}

	/**
	 * Convert string to LongArray
	 * 
	 * @param value
	 * @return
	 */
	private long[] stringToLongArray(String value) {
		value = value.replace("[", "");
		value = value.replace("]", "");
		String[] numbers = value.split(",");
		long[] numberList = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numberList[i] = new Long(numbers[i].trim());
		}

		return numberList;
	}

	/**
	 * Load Properties file
	 * 
	 * @throws IOException
	 */
	private void initProperties() throws IOException {
		String path = "./config.properties";
		InputStream input = null;
		// Check if Propertiefile exists and load
		if (Files.exists(Paths.get(path))) {
			input = new FileInputStream(path);
			prop.load(input);
			setLogingLevel(prop);

		} else {
			LOGGER.error("Config.properties file not found!");
		}
	}

	/**
	 * init CommunicationServices
	 * 
	 * @throws IOException
	 */
	private void initCommunicationServie() throws IOException {
		WebService.startServer();

		partnerCom = new NTB_RN131_Wifi("0.0.0.0", 2000);

	}

	@SuppressWarnings("deprecation")
	/**
	 * Stop AutonomouslyMode
	 */
	public void stopAutonomouslyMode() {
		autonomus = false;
		drive.stop();
		voiceCoil.charge(false);
		if (autonomousThread != null) {
			autonomousThread.stop();
		}
		robo = new Robo(PointType.ROBO);
		partnerRobo = new PartnerRobo(PointType.PARTNER_ROBO);
		LOGGER.info("Stop Autonomousmode");
	}

	/**
	 * Start AutonomouslyMode
	 */
	public void startAutonomouslyMode() {
		autonomousThread = new Thread(this);
		autonomousThread.start();
		LOGGER.info("Start Autonomousmode");
	}

	/**
	 * Set Logging
	 * 
	 * @param prop
	 */
	private static void setLogingLevel(Properties prop) {
		if (!prop.getProperty("logingLevel").trim().isEmpty()) {
			switch (prop.getProperty("logingLevel").trim().toUpperCase()) {
			case "ALL":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.ALL);
				break;
			case "DEBUG":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.DEBUG);
				break;
			case "ERROR":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.ERROR);
				break;
			case "FATAL":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.FATAL);
				break;
			case "INFO":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.INFO);
				break;
			case "TRACE":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.TRACE);
				break;
			case "WARN":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.WARN);
				break;
			case "OFF":
				Configurator.setAllLevels("", org.apache.logging.log4j.Level.OFF);
				break;
			default:
				break;
			}

		}
	}

	/**
	 * Method started in Thread by runAutonomouslyMode
	 */
	public void run() {
		ballshot = 0;
		ballcatched = 0;
		drivePosition = 0;
		autonomus = true;
		field = new Field();
		robo = new Robo(PointType.ROBO);
		robo.setStatus(Status.INITIALIZING);
		partnerRobo = new PartnerRobo(PointType.PARTNER_ROBO);

		while (autonomus) {
			// int round = 0;
			long deadTime = 0;

			switch (robo.getStatus()) {
			case INITIALIZING:

				voiceCoil.charge(true);

				// TODO Generate radmom field
//				field.field[(int) Math.round(field.adversary[0][0].getxCoordinate())][(int) Math
//						.round(field.adversary[0][0].getyCoordinate())].setBlock(true);
//				field.field[(int) Math.round(field.adversary[1][0].getxCoordinate())][(int) Math
//						.round(field.adversary[1][0].getyCoordinate())].setBlock(true);
//				field.field[(int) Math.round(field.adversary[3][1].getxCoordinate())][(int) Math
//						.round(field.adversary[3][1].getyCoordinate())].setBlock(true);
//				field.field[(int) Math.round(field.adversary[0][2].getxCoordinate())][(int) Math
//						.round(field.adversary[0][2].getyCoordinate())].setBlock(true);
//
//				field.field[(int) Math.round(field.adversary[0][0].getxCoordinate())][(int) Math
//						.round(field.adversary[0][0].getyCoordinate())].setPointType(PointType.UNKNOWN);
//				field.field[(int) Math.round(field.adversary[1][0].getxCoordinate())][(int) Math
//						.round(field.adversary[1][0].getyCoordinate())].setPointType(PointType.UNKNOWN);
//				field.field[(int) Math.round(field.adversary[3][1].getxCoordinate())][(int) Math
//						.round(field.adversary[3][1].getyCoordinate())].setPointType(PointType.UNKNOWN);
//				field.field[(int) Math.round(field.adversary[0][2].getxCoordinate())][(int) Math
//						.round(field.adversary[0][2].getyCoordinate())].setPointType(PointType.UNKNOWN);
//				// field.setRandomPoints(4); // randmoe field
//				field.setMultipleObjectsByPoints();

				// Define robo position (detect roboposition and correct angle and position
				// of robo)

				try {

					// RoboControl.envScan.scanOnceForAlignment(); // Hier als Parameter Tofnummer
					// aus List<VL53L1X>
					// tofs eintragen welcher senkrecht auf Wand der
					// Y-Achse steht
					// Ausrichten auf 0° zu
					// drive.turn(robo.getPosition().getDegree());

					// Ausrichten und dazugehöriger Vektor setzen
					// robo.getPosition().setDegree(90);

				} catch (Exception e2) {
					// TODO Auto-generated catch block
					LOGGER.error(e2);
				}

				// TODO WIEDER EINBLENDEN
				 //Start first Fieldscan
				try {
					envScan.scan();

				} catch (Exception e2) {
					// TODO Auto-generated catch block
					LOGGER.error(e2 + "envScan failed.");
				}

				// Wait for partner to be connected
				robo.setStatus(Status.CONNECT_WITH_PARTNER);
				while (!partnerCom.isPartnerConnected()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						LOGGER.error(e);
					}
				}
				robo.setStatus(Status.UNKNOWN);
				// Check partner status
				// if partnerStatus == Has_Ball then change status of Robo to drive and go to
				// first position
				boolean checkStatus = true;
				do {
					if (partnerRobo.getStatus() == PartnerRobo.Status.HAS_BALL && !voiceCoil.hasBall()) {
						robo.setStatus(Status.DRIVE);
						checkStatus = false;
					}

					// if voiceCoil.hasBall() == true then change status of robo to hasBall

					else if (voiceCoil.hasBall() && partnerRobo.getStatus() == PartnerRobo.Status.UNKNOWN) {
						robo.setStatus(Status.HAS_BALL);
						checkStatus = false;
					} else {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							LOGGER.error(e);
						}
					}
				} while (checkStatus);

				break;
			case HAS_BALL:
				deadTime = System.currentTimeMillis() + 60000;
				while (partnerRobo.getStatus() != PartnerRobo.Status.AT_POSITON) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (System.currentTimeMillis() >= deadTime) {
						robo.setStatus(Status.ERROR);
						LOGGER.error("PartnerRobo is still not in place after 30 seconds");
						break;
					}
				}
				robo.setStatus(Status.SHOOT);
				break;
			case AT_POSITON:
				deadTime = System.currentTimeMillis() + 60000;
				while (!voiceCoil.hasBall()) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (System.currentTimeMillis() >= deadTime) {
						robo.setStatus(Status.ERROR);
						LOGGER.error("No ball received after 30 seconds");
						break;
					}
				}
				ballcatched++;
				robo.setStatus(Status.HAS_BALL);
				break;
			case FINISHED:
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				drive.turn(1080);
				autonomus = false;
				break;
			case DRIVE:
				/**
				 * TODO Nächste position anfahren Nächster punkt auswählen Punkt der
				 * DriverMethode goToPoint übergeben und strecke wird abgefahten -
				 */

				// Point partnerRoboPosition = new Point(100 / 5, 100 / 5, PointType.UNKNOWN);
				// field.setPartnerRoboByPartnerPoint(partnerRobo.getPosition());

				// RoboControl.robo.getPosition().setRow(630/5);
				// RoboControl.robo.getPosition().setCol(105/5);
				// TODO Nächster punkt muss noch implementiert werden
				// Point nextPoint = new Point(380/5, 885/5,PointType.UNKNOWN,0);
				RouteCalculator route = new RouteCalculator(robo.getPosition(), field.fieldResolution);
				List<Point> pointsToDrive = route.nextPosiblePostion(possiblePosition, drivePosition);
				LOGGER.info("NextDrivePosition  X: " + possiblePosition[1][0].getRow() * field.fieldResolution);
				LOGGER.info("NextDrivePosition  Y: " + possiblePosition[1][0].getCol() * field.fieldResolution);

				if (pointsToDrive.size() > 0) { // Falls Route gefunden

					List<DrivingPoint> dp = DrivingPoint.getList(pointsToDrive, robo.getPosition().getDegree());
					field.setDrivingPoints(pointsToDrive);

					for (DrivingPoint item : dp) {

						LOGGER.info("Distance: " + item.getDistance());
						LOGGER.info("Angle: " + item.getAngle());

					}

					RoboControl.drive.driveRouteByDrivingPoints(dp);
					route.deleteOldRoute(pointsToDrive, field.field);
					drivePosition++;

					robo.setStatus(Status.AT_POSITON);

				}

				else { // Falls keine Route gefunden

					robo.setStatus(Status.AT_POSITON);
					LOGGER.error("Drive not successful");
				}

				break;
			case SHOOT:
				/**
				 * TODO Wen nicht letzter schuss(Korbwurf) dann:: Partnerposition aus
				 * partnerRobo holen Ausrichten winkel zum partner schiessen mit distanz zum
				 * partner
				 * 
				 * robo.setStatus(Status.DRIVE); ELSE Korbkordinaten nehmen sich zum korb
				 * ausrichten (drehne bi winkel stimmt) schiessen mit distanz zum korb
				 * 
				 */
				LOGGER.error("balls catched = " + ballcatched + " balls shot = " + ballshot);
				if (ballshot < 2 || ballcatched < 2) {
					voiceCoil.shootToPoint(partnerRobo.getPosition());
					while (partnerRobo.getStatus() != PartnerRobo.Status.HAS_BALL) {
						try {
							Thread.sleep(50);
							//LOGGER.error("Partner hasn't got ball. catches = " + ballcatched + "shots = " + ballshot);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					robo.setStatus(Status.DRIVE);
					ballshot++;
				} else if (ballshot >= 2 && ballcatched >= 2) {
					voiceCoil.shootToPoint(new Point(380, 908));
					robo.setStatus(Status.FINISHED);
				}
				break;
			default:
				break;
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				LOGGER.error(e);
			}
		}
	}

	/**
	 * Emergency STOP Kill applicatoin and reset GIPO
	 */
	@SuppressWarnings("deprecation")
	public static void killRunningProcess() {
		drive.stop();
		partnerCom.stop();
		autonomus = false;
		GpioFactory.getInstance().shutdown();
		if (autonomousThread != null) {
			autonomousThread.stop();
		}
		System.exit(1);
	}

	/**
	 * Give status back if is running in Autonomously mode
	 * 
	 * @return
	 */
	public static boolean isRunningAutonomously() {

		return autonomus;
	}

	public Point[][] setpossiblePositions(int firstFinalPointX, int firstFinalPointY, int distanceX, int distanceY,
			int rows, int cols) {

		Point[][] localPoints = new Point[FinalPointRows][FinalPointCols];

		for (int i = 0; i < FinalPointRows; i++) {
			for (int j = 0; j < FinalPointCols; j++) {

				localPoints[i][j] = new Point((firstFinalPointX + (i * distanceX)),
						(firstFinalPointY + (j * distanceY)));
				localPoints[i][j].setPointType(PointType.Final_Point);

			}

		}
		return localPoints;

	}

}
