/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.RoboPin.java
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
package ch.ntb.orionRobo;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.spi.SpiChannel;

/**
 * 
 */
public class RoboPinOut {
	
	public static final GpioController gpio = GpioFactory.getInstance();

	public static final Pin MotorPWMLeft  = RaspiPin.GPIO_01;
	public static final Pin MotorPWMRight = RaspiPin.GPIO_23;
	public static final SpiChannel MotorEncoderRight = SpiChannel.CS1;
	public static final SpiChannel MotorEncoderLeft = SpiChannel.CS0;
	public static final Pin MotorSleep = RaspiPin.GPIO_15;
	public static final Pin VCBoostEnA = RaspiPin.GPIO_05;
	public static final Pin VCBoostEnB = RaspiPin.GPIO_06;
	public static final Pin VoiceCoil = RaspiPin.GPIO_22;
	public static final Pin VCBallDetection = RaspiPin.GPIO_29;
	public static final Pin VCBallDetectionPulse = RaspiPin.GPIO_21;
	
	public static final Pin TOF1_xshot = RaspiPin.GPIO_25;
	public static final Pin TOF2_xshot = RaspiPin.GPIO_28;
	
}
