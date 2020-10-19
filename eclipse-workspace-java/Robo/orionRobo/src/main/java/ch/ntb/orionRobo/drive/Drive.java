/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.drive.Drive.java
 * 
 * @author Basile Schoeb <basile.schoeb@ntb.ch>
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
package ch.ntb.orionRobo.drive;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.spi.SpiChannel;

import ch.ntb.orionRobo.component.VL53L1X;
import ch.ntb.orionRobo.component.DCMotor.Motor;
import ch.ntb.orionRobo.component.DCMotor.PID;
import ch.ntb.orionRobo.component.VL53L1X.DistanceMode;
import ch.ntb.orionRobo.environmentRecognition.Field;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.Robo.*;
import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.RoboPinOut;

/**
 * Drive
 */
public class Drive {

	private static final Logger LOGGER = LogManager.getLogger(Drive.class.getName());

	private Motor motorLeft;
	private Motor motorRight;
	public final GpioPinDigitalOutput motorPin;

	private static final int gearbox = 66;
	private static final int encoderResolution = 16;
	private static final int stepsPerRevolution = gearbox * encoderResolution * 4;
	private static final double roboCircumference = 158.8 * Math.PI;
	private static final double wheelCircumference = 36 * Math.PI;
	private static final double distanceOfOneTick = wheelCircumference / stepsPerRevolution;

	private static final int maxStepsTrigger = 2000;
	private static final int maxSpeed = 120;

	/**
	 * Drive Class Constructor
	 */
	public Drive() {

		motorLeft = new Motor(RoboPinOut.MotorPWMLeft, SpiChannel.CS0);
		motorRight = new Motor(RoboPinOut.MotorPWMRight, SpiChannel.CS1);

		motorPin = GpioFactory.getInstance().provisionDigitalOutputPin(RoboPinOut.MotorSleep, "Sleep");
		motorPin.setShutdownOptions(true, PinState.LOW);
		motorPin.low();
	}

	/**
	 * Drive distance in mm
	 * 
	 * @param distance in mm
	 */
	public void driveStraight(long distance) {
		motorPin.low();
		long steps = Math.round(distance / distanceOfOneTick);
		driveStraightSteps(-steps);
	}

	public void stop() {
		motorPin.low();
	}

	/**
	 * do steps
	 * 
	 * @param distance in steps
	 */
	public void driveStraightSteps(long steps) {
		motorPin.low();

		PID myPid = new PID(1, 0.008, 0.1);
		double pid = 0, value = 0;
		int speed1 = 0, speed2 = 0;
		long stepsDoneRight = 0;
		long stepsDoneLeft = 0;
		long encoderRightStartValue = motorRight.encoder.getValue(); // read encoder value
		long encoderLeftStartValue = motorLeft.encoder.getValue();
		long stepsNow = 0;
		int stepsTrigger = ((maxStepsTrigger > Math.abs(steps / 2)) ? Math.toIntExact(Math.abs(steps / 2))
				: maxStepsTrigger) - 6;
		float scalingConst = (maxSpeed - 2F) / maxStepsTrigger / maxStepsTrigger;
		myPid.setSetpoint(0);
		myPid.setOutputLimits(5);

		motorRight.setSpeed(0);
		motorLeft.setSpeed(0);
		motorPin.high();
		while ((Math.abs(stepsDoneRight) < Math.abs(steps) - 1) || stepsDoneRight != -stepsDoneLeft) {

			stepsDoneRight = motorRight.encoder.getValue() - encoderRightStartValue;
			stepsDoneLeft = motorLeft.encoder.getValue() - encoderLeftStartValue;

			pid = myPid.getOutput(stepsDoneLeft, -stepsDoneRight);
			if (Math.abs(stepsDoneRight) < (stepsTrigger)) {
				value = Math.signum(steps) * (scalingConst * stepsDoneRight * stepsDoneRight + 7);
			} else if (Math.abs(stepsNow = steps - stepsDoneRight) < stepsTrigger) {
				value = Math.signum(steps) * (scalingConst * stepsNow * stepsNow + 7);
			}

			if (Math.abs(stepsDoneRight) == Math.abs(steps)) {
				speed1 = 0;
				speed2 = Math.toIntExact(Math.round(pid - value));
			} else {
				speed1 = Math.toIntExact(Math.round(value + pid));
				speed2 = Math.toIntExact(Math.round(pid - value));
			}
			motorRight.setSpeed(speed1);
			motorLeft.setSpeed(speed2);

		}
		motorRight.setSpeed(0);
		motorLeft.setSpeed(0);
		LOGGER.info("DriveStraight - stepsDoneRight: " + stepsDoneRight + " stepsDoneLeft:" + stepsDoneLeft + " steps:"
				+ steps);
		motorPin.low();
	}

	/**
	 * turn
	 * 
	 * @param degree
	 */
	public void turn(double degree) {
		motorPin.low();
		long steps = Math.round(roboCircumference / distanceOfOneTick / 360.0F * degree);
		turnSteps(-steps);
	}

	public void turnSteps(long steps) {
		motorPin.low();

		PID myPid = new PID(1, 0.008, 0.1);
		double pid = 0, value = 0;
		int speed1 = 0, speed2 = 0;
		long stepsDoneRight = 0;
		long stepsDoneLeft = 0;
		long encoderRightStartValue = motorRight.encoder.getValue(); // read encoder value
		long encoderLeftStartValue = motorLeft.encoder.getValue();
		long stepsNow = 0;
		int stepsTrigger = ((maxStepsTrigger > Math.abs(steps / 2)) ? Math.toIntExact(Math.abs(steps / 2))
				: maxStepsTrigger) - 6;
		float scalingConst = (maxSpeed - 2F) / maxStepsTrigger / maxStepsTrigger;
		myPid.setSetpoint(0);
		myPid.setOutputLimits(5);

		motorRight.setSpeed(0);
		motorLeft.setSpeed(0);
		motorPin.high();

		while ((Math.abs(stepsDoneRight) < Math.abs(steps) - 1) || stepsDoneRight != stepsDoneLeft) {

			stepsDoneRight = motorRight.encoder.getValue() - encoderRightStartValue;
			stepsDoneLeft = motorLeft.encoder.getValue() - encoderLeftStartValue;

			pid = myPid.getOutput(stepsDoneLeft, stepsDoneRight);
			if (Math.abs(stepsDoneRight) < (stepsTrigger)) {
				value = Math.signum(steps) * (scalingConst * stepsDoneRight * stepsDoneRight + 7);
			} else if (Math.abs(stepsNow = steps - stepsDoneRight) < stepsTrigger) {
				value = Math.signum(steps) * (scalingConst * stepsNow * stepsNow + 7);
			}

			if (Math.abs(stepsDoneRight) == Math.abs(steps)) {
				speed1 = 0;
				speed2 = Math.toIntExact(Math.round(value + pid));
			} else {
				speed1 = Math.toIntExact(Math.round(value - pid));
				speed2 = Math.toIntExact(Math.round(value + pid));
			}
			motorRight.setSpeed(speed1);
			motorLeft.setSpeed(speed2);

		}
		motorRight.setSpeed(0);
		motorLeft.setSpeed(0);
		LOGGER.info("TurnSteps - stepsDoneRight: " + stepsDoneRight + " stepsDoneLeft:" + stepsDoneLeft + " steps:"
				+ steps);
		motorPin.low();

	}

	/**
	 * Destructor run automaticaly befor garbagecolletion starts
	 */
	protected void finalize() {
		motorRight.setSpeed(0);
		motorLeft.setSpeed(0);
		motorPin.low();

	}

	public void init() throws Exception {

		try {

		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	/**
	 * Drive the Robo to the defined positon
	 * 
	 * @param point
	 */
	public void goToPosition(Point point) {

		// TODO
		// Route mit A* generieren zum punkt

		RouteCalculator newRoute = new RouteCalculator(RoboControl.robo.getPosition(),RoboControl.field.fieldResolution);
		newRoute.routeDefiner(point);
		// newRoute.setVisible(true);

		List<DrivingPoint> dp = new ArrayList<DrivingPoint>();
		dp = DrivingPoint.getList(newRoute.getPath(), RoboControl.robo.getPosition().getDegree());
		// newRoute.setVisible(false);

		LOGGER.info("Go to position x: " + point.getxCoordinate() + " y: " + point.getyCoordinate());
		driveRouteByDrivingPoints(dp);

		dp = null;
		// newRoute.setVisible(false);

	}

	/**
	 * Drive the given Route
	 * 
	 * @param List<DrivingPoint>
	 */

	public void driveRouteByDrivingPoints(List<DrivingPoint> dp) {

		for (DrivingPoint drivingPoint : dp) {

			LOGGER.info("Drive for " + drivingPoint.getDistance() + " mm.");
			LOGGER.info("Turn for " + drivingPoint.getAngle() + " Degree.");
			driveStraight((long) drivingPoint.getDistance());
			turn(drivingPoint.getAngle());

			double nextX = ((drivingPoint.getDistance() * Math.cos(Math.toRadians(RoboControl.robo.getPosition().getDegree())))
					+ RoboControl.robo.getPosition().getxCoordinate());
			double nextY = ((drivingPoint.getDistance() * Math.sin(Math.toRadians(RoboControl.robo.getPosition().getDegree())))
			+ RoboControl.robo.getPosition().getyCoordinate());
			

			RoboControl.robo.getPosition().setXCoordinate(nextX);
			RoboControl.robo.getPosition().setYCoordinate(nextY);
			RoboControl.robo.getPosition()
					.setDegree(RoboControl.robo.getPosition().getDegree() + drivingPoint.getAngle());

		}
		LOGGER.info("Route driven");

	}

	public static void main(String[] args) throws InterruptedException {

		Drive drive = new Drive();

		for (int i = 0; i <= 5; i++) {

//		
			drive.driveStraight(300);
			drive.turn(180.0F);
			Thread.sleep(500);
			drive.driveStraight(300);
			drive.turn(180.0F);
			Thread.sleep(500);
//		drive.driveStraightSteps(300);
//		Thread.sleep(4000);
//		drive.driveStraightSteps(-300);
//		Thread.sleep(4000);
//		drive.driveStraightSteps(6000);
//		Thread.sleep(4000);
//		drive.driveStraightSteps(-6000);
//		Thread.sleep(4000);
		}
		drive.turn(720.0F);

	}
}