package ch.ntb.orionRobo.component;

import java.io.IOException;
import java.math.BigDecimal;



import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import ch.ntb.orionRobo.component.pca.PCA9685GpioProvider;
import ch.ntb.orionRobo.component.pca.PCA9685Pin;

public class Servo {

	
	private static PCA9685GpioProvider pwmController;
	
	private int CENTER_PULSE = 1500;
	private int MIN_PULSE = 900;
	private int MAX_PULSE = 2100;
	
	
	private float MAX_DEGREE = 165.0f;
	
	private Pin channel = PCA9685Pin.PWM_00;
		
	
	public int getCENTER_PULSE() {
		return CENTER_PULSE;
	}


	public void setCENTER_PULSE(int cENTER_PULSE) {
		CENTER_PULSE = cENTER_PULSE;
	}


	public int getMIN_PULSE() {
		return MIN_PULSE;
	}


	public void setMIN_PULSE(int mIN_PULSE) {
		MIN_PULSE = mIN_PULSE;
	}


	public int getMAX_PULSE() {
		return MAX_PULSE;
	}


	public void setMAX_PULSE(int mAX_PULSE) {
		MAX_PULSE = mAX_PULSE;
	}


	public float getMAX_DEGREE() {
		return MAX_DEGREE;
	}


	public void setMAX_DEGREE(float mAX_DEGREE) {
		MAX_DEGREE = mAX_DEGREE;
	}
	
	/**
	 * 
	 * @param pwmController
	 * @param channel
	 * @throws UnsupportedBusNumberException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public Servo(Pin channel) throws InterruptedException, UnsupportedBusNumberException, IOException
	{
		this( channel, 1500, 900, 2100, 165.0f);
	}

	public Servo( Pin channel, int MIN_PULSE, int MAX_PULSE, int MAX_DEGREE) throws InterruptedException, UnsupportedBusNumberException, IOException
	{
		this( channel, (MIN_PULSE + MIN_PULSE) / 2, MIN_PULSE, MAX_PULSE, MAX_DEGREE);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param channel
	 * @param CENTER_PULSE
	 * @param MIN_PULSE
	 * @param MAX_PULSE
	 * @param MAX_DEGREE
	 * @throws InterruptedException 
	 * @throws UnsupportedBusNumberException 
	 * @throws IOException 
	 */
	public Servo(Pin channel, int CENTER_PULSE, int MIN_PULSE, int MAX_PULSE, float MAX_DEGREE) throws InterruptedException, UnsupportedBusNumberException, IOException
	{
		//int freq = 120;
        BigDecimal frequency = new BigDecimal("120.00");
        BigDecimal frequencyMeasured = new BigDecimal("120");
        // Correction factor: actualFreq / targetFreq
        // e.g. measured actual frequency is: 51.69 Hz
        // Calculate correction factor: 51.65 / 48.828 = 1.0578
        // --> To measure actual frequency set frequency without correction factor(or set to 1)
        BigDecimal frequencyCorrectionFactor = new BigDecimal("0.97505529614155812238879331531089");
        //BigDecimal frequencyCorrectionFactor = new BigDecimal("0.48752764807077906119439665765545");
        // Create custom PCA9685 GPIO provider
        

		
		
		if(pwmController == null) {
			I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
	        pwmController = new PCA9685GpioProvider(bus, 0x40, frequency, frequencyCorrectionFactor, frequencyMeasured );
	        // Define outputs in use for this example
	        provisionPwmOutputs(pwmController);
	        // Reset outputs
	        pwmController.reset();
		}
		
		this.CENTER_PULSE = CENTER_PULSE;
		this.MIN_PULSE = MIN_PULSE;
		this.MAX_PULSE = MAX_PULSE;
		this.MAX_DEGREE = MAX_DEGREE;
		this.channel = channel;
		
	}
	

	/**
	 *
	 * @param freq in Hz
	 * @param targetPulse in ms
	 * @return the value as an int
	 */
//	public int getServoValueFromPulse( float targetPulse) {
//		double pulseLength = 1000000; // 1s = 1,000,000 us per pulse. "us" is to be read "micro (mu) sec".
//		pulseLength /= pwmController.getFreq();  // 40..1000 Hz
//		pulseLength /= 4096; // 12 bits of resolution. 4096 = 2^12
//		int pulse = (int) Math.round((targetPulse * 1_000) / pulseLength); // in millisec
//		//LOGGER.debug(String.format("%.04f \u00b5s per bit, pulse: %d", pulseLength, pulse)); // bit? cycle?
//		return pulse;
//	}
	
//	
//	public static double getPulseFromValue(int freq, int value) {
//		double msPerPeriod = 1_000.0 / (double)freq;
//		return msPerPeriod * ((double)value / 4_096.0);
//	}



	/**
	 * @param channel 0..15
	 * @param pulse duration in microseconds.
	 */
	public void setServoPulse(int duration) {
		pwmController.setPwm(channel, duration);

	}
		

	public void setServoDegree(float degree) throws InterruptedException {
		if(degree >= 0 && degree <= MAX_DEGREE)
		{
			int aviableTicks = MAX_PULSE - MIN_PULSE;
			int pulse = MIN_PULSE + Math.round(aviableTicks / MAX_DEGREE * degree );
			//System.out.println(Math.round(aviableTicks / MAX_DEGREE * degree ));
			//System.out.println(pulse);
			pwmController.setPwm(channel,pulse);	
		}
		
	}
	
    @SuppressWarnings("unused")
	private static int checkForOverflow(int position) {
        int result = position;
        if (position > PCA9685GpioProvider.PWM_STEPS - 1) {
            result = position - PCA9685GpioProvider.PWM_STEPS - 1;
        }
        return result;
    }
	
	public static void main(String[] args) throws I2CFactory.UnsupportedBusNumberException, InterruptedException, IOException {

		
		
		Servo servo1 = new Servo(PCA9685Pin.PWM_00);

		
        //final int offset = 400;
        //final int pulseDuration = 600;
        System.out.print("run PWM");
//        for (int i = 0; i < 10; i++) {
//            Pin pin = PCA9685Pin.ALL[0];
//            int onPosition = checkForOverflow(offset * i);
//            int offPosition = checkForOverflow(pulseDuration * (i + 1));
//            pwmController.setPwm(pin, onPosition, offPosition);
//        }
        
        while(true) {
		for(float i = 0; i <= 120; i+=0.5F) {
			servo1.setServoDegree(i);
			Thread.sleep(30);
		}
		for(float i = 120; i >= 0; i-=0.5F) {
			servo1.setServoDegree(i);
			Thread.sleep(30);
		}
		Thread.sleep(500);
        }
//		System.out.print("finisch set pwm");
//		Thread.sleep(1000);
//		servo1.setServoDegree(0.0f);
//		Thread.sleep(3000);
//		
//		String value = "90.0";
//		while(!value.equals("stop") )
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			System.out.print("Enter Degree in Float: or stop to Exit");
//	        try{
//        	value = br.readLine();
//        		int value2 = Integer.parseInt(value);
//	            pwmController.setPwm(PCA9685Pin.PWM_00, value2);;
//	        }catch(NumberFormatException nfe){
//	            System.err.println("Invalid Format!");
//	        }
//		}
//		
//		servo1.setServoDegree(90.0f);
//		Thread.sleep(100);
//		System.out.println("Ouala");
	}
	
    private static GpioPinPwmOutput[] provisionPwmOutputs(final PCA9685GpioProvider gpioProvider) {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinPwmOutput myOutputs[] = {
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "Servo"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_06, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_07, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_08, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_09, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_10, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_11, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_12, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_13, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_14, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_15, "not used")};
        return myOutputs;
    }
}
