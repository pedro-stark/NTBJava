package ch.ntb.orionRobo.component.DCMotor;


import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;


public class RotaryEncoderSPI {

	private static final Logger LOGGER = LogManager.getLogger(RotaryEncoderSPI.class.getName());
	
	
	private static final int CLR = 0b00000000;
	private static final int RD = 0b01000000;
	private static final int WR = 0b10000000;
	private static final int LOAD = 0b11000000;

	private static final int MDR0 = 0b00001000;
	private static final int MDR1 = 0b00010000;
	@SuppressWarnings("unused")
	private static final int DTR = 0b00011000;
	private static final int CNTR = 0b00100000;	
	private static final int OTR = 0b00101000;
	@SuppressWarnings("unused")
	private static final int STR = 0b00110000;
	
	
	private static final int MDR0_CONF = 0b11000011;
	private static final int MDR1_CONF = 0b00000000;
	
	
	
	// SPI device
    public SpiDevice LS7366R = null;
	
	
	
    /**
     * 
     * @param spiChannel
     */
    public RotaryEncoderSPI(SpiChannel spiChannel) {
    	try {
    		LS7366R = SpiFactory.getInstance(spiChannel,
			        SpiDevice.DEFAULT_SPI_SPEED, // default spi speed 1 MHz
			        SpiDevice.DEFAULT_SPI_MODE); // default spi mode 0
			
			init();
		} catch (IOException e) {
			LOGGER.error(e);
		}

    }
    
    /**
     * 
     */
    private void init() {
    	try {
    		byte[] data = {(byte) (WR | MDR0),(byte) MDR0_CONF };
    		byte[] data2 = {(byte) (WR | MDR1),(byte) MDR1_CONF };
    		LS7366R.write(data);
    		LS7366R.write(data2);
			reset();
		} catch (IOException e) {
			
			LOGGER.error(e);
		}
    }
    
    /**
     * 
     */
    public void reset() {
    	try {
    		byte[] data = {(byte) (CLR | CNTR)};
    		LS7366R.write(data);
			
		} catch (IOException e) {
			LOGGER.error(e);
		}
    }
    
	
    /**
     * 
     * @return
     */
    public long getValue() {
    	long count = 0;
    	
    	try {
    	byte[] data = {(byte) (LOAD | OTR)};
    	LS7366R.write(data);
    	byte[] data2 = {(byte) (RD | OTR), 0x00, 0x00, 0x00, 0x00};
    	byte[] result = LS7366R.write(data2);
    	count = ByteBuffer.wrap(result, 1, 4).getInt();
    	//System.out.println(count);
    	}
    	catch(IOException e) {
    		LOGGER.error(e);
    	}


        return count;
    }
    
    
   
	
}
