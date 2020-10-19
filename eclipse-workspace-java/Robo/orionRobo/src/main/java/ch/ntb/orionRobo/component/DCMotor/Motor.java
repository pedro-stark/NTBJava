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
package ch.ntb.orionRobo.component.DCMotor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.spi.SpiChannel;

import ch.ntb.orionRobo.RoboPinOut;

public class Motor {
	
	private static final Logger LOGGER = LogManager.getLogger(Motor.class.getName());
	
	private final GpioPinPwmOutput pwm;
	public RotaryEncoderSPI encoder;
	
	// pwmFrequenzy in HZ = 19.2e6 / pwmClockdivisor / pwmRangeDivisor
	private int pwmClockdivisor = 2;
	private int pwmRangeDivisor = 400;
	
	
	
	/**
	 * Motor Driver Constructor
	 * 
	 * Hardware PWM:
	 * RaspiPin.GPIO_01
	 * RaspiPin.GPIO_23
	 * 
	 * @param pinPWM
	 * @param pinIN1
	 * @param pinIN2
	 * @param pinAPhase
	 * @param pinBPhase
	 */
	//
	// RaspiPin.GPIO_01
	// RaspiPin.GPIO_23
	public Motor(Pin pinPWM, SpiChannel encoderChannel) {
		GpioController gpio = GpioFactory.getInstance();
		
		this.pwm = gpio.provisionPwmOutputPin(pinPWM);
		this.pwm.setShutdownOptions(true, PinState.LOW);
        com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
        com.pi4j.wiringpi.Gpio.pwmSetRange(pwmRangeDivisor);
        com.pi4j.wiringpi.Gpio.pwmSetClock(pwmClockdivisor);
        pwm.setPwm(200);
        encoder = new RotaryEncoderSPI(encoderChannel);
        //encoder.start();
        LOGGER.info( "Motor on pin {} initialised with RotaryEncoder on channel {} ", 
        		pinPWM.getName(),encoderChannel.name());
		
	}
	
	/**
	 * Set motor speed
	 * @param speed value range  [-200,200]
	 */
	public void setSpeed(int speed)
	{
		int pwmValue = 0;
		if(speed >= 0 && speed <= 200)
		{
			pwmValue = 200 + speed;
		}else if(speed <= 0 && speed >= -200){
			pwmValue = 200 + speed; 
		}else {
			pwmValue = 200;
		}
		//LOGGER.debug( "Motor on pin {} pwm: {}", 
		//		pwm.getName(), pwmValue);
		pwm.setPwm(pwmValue);
	}
	
	/**
	 * Stop motor
	 */
	public void stop() {
		pwm.setPwm(200);

	}
	
	public static void main(String[] args) throws InterruptedException {




        GpioPinDigitalOutput motorPin = RoboPinOut.gpio.provisionDigitalOutputPin(RoboPinOut.MotorSleep, "Sleep");
        Motor motorA = new Motor(RoboPinOut.MotorPWMLeft, SpiChannel.CS0);
        Motor motorB = new Motor(RoboPinOut.MotorPWMRight ,  SpiChannel.CS1);
        motorPin.low();
        motorPin.high();
  
        
        Thread.sleep(1000);
        
        motorA.setSpeed(0);
        motorB.setSpeed(0);
        
        Thread.sleep(1000);
        
        //for(int a = 0 ; a < 10 ; a++) {
        //motorA.setSpeed(199);
        
        
        motorA.stop();
        motorB.stop();
        motorPin.low();
        Runtime.getRuntime().exit(0);
	}

}
