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
package ch.ntb.orionRobo.component;

import java.io.IOException;

//import java.util.Date;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pi4j.io.gpio.*;

import ch.ntb.orionRobo.Robo.Status;
import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.RoboPinOut;
import ch.ntb.orionRobo.environmentRecognition.EnvironmentScanner;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.drive.Vector;

public class VoiceCoil {

	private static final Logger LOGGER = LogManager.getLogger(VoiceCoil.class.getName());

	private GpioPinDigitalOutput pinVoiceCoil;
	private GpioPinDigitalOutput pinBoostA;
	private GpioPinDigitalOutput pinBoostB;
	//private GpioPinDigitalOutput pinLEDPulse;
	private GpioPinDigitalInput pinBallerkennung;
	private long timeToCharge = 30000000000l; // in NANO sekunden
	private boolean capacitorLoading = false;
	private long startTimeCapacitorLoading = 0;
	private ChargingMode chargingMode = ChargingMode._48V;
	public UnivariateFunction function;
	
	public long maxDistance = 0;
	public long minDistance = 0;

	/**
	 * 
	 */
	public enum ChargingMode {
		_48V, _12V,
	}

	public ChargingMode getChargingMode() {
		return chargingMode;
	}

	/**
	 * 
	 * @param chargingMode
	 */
	public void setCharigngMode(ChargingMode chargingMode) {
		this.chargingMode = chargingMode;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isCapacitorLoading() {
		return capacitorLoading;
	}

	/**
	 * Check if capacitor loading time is over
	 * 
	 * @param duration in ms
	 * @return
	 */
	public boolean isCapacitorLoadedFor(long duration) {

		if (startTimeCapacitorLoading == 0) {
			return false;
		} else if (startTimeCapacitorLoading + duration <= System.nanoTime()) {
			return true;
		} else {
			return false;
		}

	}

	public VoiceCoil() {

		// Initialisierung VoiceCoilPin
		this.pinVoiceCoil = GpioFactory.getInstance().provisionDigitalOutputPin(RoboPinOut.VoiceCoil, "VoiceCoil",
				PinState.LOW);
		this.pinVoiceCoil.setShutdownOptions(true, PinState.LOW);

		// Boosterpins Initialisierung
		this.pinBoostA = GpioFactory.getInstance().provisionDigitalOutputPin(RoboPinOut.VCBoostEnA, "BoosterA",
				PinState.LOW);
		this.pinBoostA.setShutdownOptions(true, PinState.LOW);

		this.pinBoostB = GpioFactory.getInstance().provisionDigitalOutputPin(RoboPinOut.VCBoostEnB, "BoosterB",
				PinState.LOW);
		this.pinBoostB.setShutdownOptions(true, PinState.LOW);
		
		//this.pinLEDPulse = GpioFactory.getInstance().provisionDigitalOutputPin(RoboPinOut.VCBallDetectionPulse, "LEDPulse",
		//		PinState.LOW);
		//this.pinLEDPulse.setShutdownOptions(true, PinState.LOW);

		// Ballerkennungspin Initialisierung
		this.pinBallerkennung = GpioFactory.getInstance().provisionDigitalInputPin(RoboPinOut.VCBallDetection,
				PinPullResistance.PULL_DOWN);
		this.pinBallerkennung.setShutdownOptions(true);

	}

	/**
	 * Shoot distance
	 * 
	 * @param distance
	 */
	public void shootDistance(long distance) {
		long timeInNs = 0;
		if(distance > minDistance && distance < maxDistance)
		{
			timeInNs = Math.round(function.value(distance));
			
		}else if(distance < minDistance) {
			timeInNs = 0;
		}else if(distance > maxDistance) {
			timeInNs = maxDistance;
		}
		
		shoot(timeInNs);
		
	}

	/**
	 * Shoot time
	 * 
	 * @param onTime
	 */
	public void shoot(long onTimeNs) {
		if (startTimeCapacitorLoading == 0) {
			LOGGER.error("You can't shoot. Pleace first load capacitor");
			return;
		}
		long startTime = 0;
		long nowTime = System.nanoTime();
		while(nowTime <= startTimeCapacitorLoading + timeToCharge)
		{
			nowTime = System.nanoTime();
		}
		charge(false);
		startTime = nowTime = System.nanoTime();
		long endTime = nowTime + onTimeNs ;
		pinVoiceCoil.high();	
		while(nowTime <= endTime)
		{
			nowTime = System.nanoTime();
		}
		pinVoiceCoil.low();
		LOGGER.debug("Real shoot time: " + ( nowTime - startTime) );
		charge(true);
		if (capacitorLoading) {
			startTimeCapacitorLoading = System.nanoTime();
		} else {
			startTimeCapacitorLoading = 0;
		}

	}

	/**
	 * Charge condensatorbank
	 * 
	 * @param millis
	 * @param nanos
	 */
	public void charge(long millis, int nanos) {

		try {
			switch (chargingMode) {
			case _12V:
				pinBoostA.high();
				pinBoostB.low();
				break;
			case _48V:
				pinBoostA.high();
				pinBoostB.high();
				break;
			default:
				break;
			}
			capacitorLoading = true;
			Thread.sleep(millis, nanos);
			pinBoostA.low();
			pinBoostB.low();
			capacitorLoading = false;
			LOGGER.info("capacitor charged for " + millis + "ms " + nanos + "ns");
		} catch (InterruptedException e) {
			LOGGER.error(e);
		}

		// Boost A on, Boost B on = 36V

	}

	public void charge(boolean enabled) {
		if (enabled) {
			startTimeCapacitorLoading = System.nanoTime();
			switch (chargingMode) {
			case _12V:
				pinBoostA.high();
				pinBoostB.low();
				break;
			case _48V:
				pinBoostA.high();
				pinBoostB.high();
				break;
			default:
				break;
			}
			LOGGER.info("Loading capacitor: Enabled");
			capacitorLoading = true;
		} else {
			pinBoostA.low();
			pinBoostB.low();
			LOGGER.info("Loading capacitor: Disabled");
			startTimeCapacitorLoading = 0;
			capacitorLoading = false;
		}

		// Boost A on, Boost B on = 36V

	}

	/**
	 * Destructor run automaticaly befor garbagecolletion starts
	 */
	protected void finalize() {
		this.pinBoostA.setShutdownOptions(true, PinState.LOW);
		this.pinBoostB.setShutdownOptions(true, PinState.LOW);
		this.pinBallerkennung.setShutdownOptions(true);

	}

	/**
	 * check if robo has ball
	 * sho
	 * @return
	 */
	public boolean hasBall() {
		//pinLEDPulse.high();

		for (int i = 1; i <= 5; i++) {
			if (pinBallerkennung.isHigh()) {
				//pinLEDPulse.low();
				return false;
			}
		}
		//pinLEDPulse.low();
		return true;
	}

	/**
	 * Calibrate the distance for voice coil
	 */
	public void calibrate(long[] times) {
		charge(true);

		

		for (long timeInNs : times) {
			while (!hasBall()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					LOGGER.error(e);
				}
			}

			LOGGER.info("VoiceCoil Calibration: " + timeInNs + "ns");
			shoot(timeInNs);
			

		}
	}

	/**
	 * Set Calibration
	 * 
	 * @param timeValues
	 * @param distanceValues
	 * @throws IOException
	 */
	public void setCalibrationValue(long[] timeValues, long[] distanceValues) throws IOException {
		double[] times = new double[(timeValues.length)];
		double[] distances = new double[distanceValues.length];
		minDistance = distanceValues[0];
		maxDistance = distanceValues[distanceValues.length-1];
		for (int i = 0; i < times.length; i++) {
			times[i] = (double) timeValues[i];
		}

		for (int i = 0; i < distances.length; i++) {
			distances[i] = (double) distanceValues[i];
		}
		UnivariateInterpolator interpolator = new SplineInterpolator();
		function = interpolator.interpolate(distances, times);

	}


	public static void main(String[] argument) throws InterruptedException {
		VoiceCoil blub = new VoiceCoil();
		long[] time = {2000000, 3000000, 3500000, 4000000, 5000000,6000000,7000000,8000000,9000000, 10000000,11000000 ,12000000};
		long[] distance = {0,10, 20, 40, 100,140,300,340,500, 600,700 ,800};
		try {
			blub.setCalibrationValue(time, distance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 800; i++  )
		{
			double distance2 = blub.function.value(i);
			System.out.println(distance2);
		}

	}

	/**
	 * @param point
	 */

	public void shootToPoint(Point partnerPoint) {
		/**
		 * TODO Methode die den roboter dreht und die distanz zum punkt errechnent und
		 * danach schiesst ACHTUNG!!! Die drehung muss im robo Object aktualisiert
		 * werden damit danach die richtung zum fahren stimmt beim berechnen
		 */
		// Richtungsvektor und Distanz ermitteln
		double deltadistanceX = (partnerPoint.getxCoordinate() - RoboControl.robo.getPosition().getxCoordinate());
		double deltadistanceY = (partnerPoint.getyCoordinate() - RoboControl.robo.getPosition().getyCoordinate());
		Point deltaPoint = new Point(deltadistanceX, deltadistanceY, null);
		long shootDistance = (long) Math.sqrt(Math.pow(deltadistanceX, 2) + Math.pow(deltadistanceY, 2));
		double roboAngle = RoboControl.robo.getPosition().getDegree();
		
		LOGGER.info(" Robocontrol X-Position " + RoboControl.robo.getPosition().getxCoordinate());
		LOGGER.info(" Robocontrol Y-Position " + RoboControl.robo.getPosition().getyCoordinate());
		LOGGER.info(" Robocontrol Y-Position " + RoboControl.robo.getPosition().getDegree());
		LOGGER.info(" PartnerRobo X-Position " + RoboControl.partnerRobo.getPosition().getxCoordinate());
		LOGGER.info(" PartnerRobo Y-Position " + RoboControl.partnerRobo.getPosition().getyCoordinate());
		LOGGER.info("Schussdistanz: " + shootDistance);
		

		Vector direction = new Vector((int)Math.round(Math.cos(Math.toRadians(roboAngle))*1000), (int)Math.round(Math.sin(Math.toRadians(roboAngle))*1000));
		//((int)deltadistanceX,(int)deltadistanceY);//
		double turnAngle = direction.getTurnAngleToPartnerByPoint(deltaPoint);
		RoboControl.drive.turn(turnAngle);
		RoboControl.robo.getPosition().setDegree(roboAngle + turnAngle); //Aktualisierung Robowinkel;
 		RoboControl.voiceCoil.shootDistance(shootDistance);
	}
}
