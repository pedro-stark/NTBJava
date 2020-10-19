///**
// * NTB Systemtechnikprojekt Team 7
// *
// * File: ch.ntb.orionRobo.networking.NTB_RN131_Wifi.java
// * 
// * @author Basile Schoeb <basile.schoeb@ntb.ch>
// * 
// * MIT License
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy
// * of this software and associated documentation files (the "Software"), to deal
// * in the Software without restriction, including without limitation the rights
// * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// * copies of the Software, and to permit persons to whom the Software is
// * furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all
// * copies or substantial portions of the Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// * SOFTWARE.
// *
// * Copyright (c) 2018 NTB Systemtechnikprojekt Team 7
// */

package ch.ntb.orionRobo.networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.RolloverFrequency;
import org.apache.logging.log4j.core.util.ArrayUtils;

import ch.ntb.orionRobo.PartnerRobo;
import ch.ntb.orionRobo.Robo;
import ch.ntb.orionRobo.Robo.Status;
import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.environmentRecognition.Point.PointType;
import ch.ntb.orionRobo.networking.webService.WebService;

/**
 * Wifi connection Class for the RN131 Module
 */
public class NTB_RN131_Wifi implements Runnable {
	
	private static final Logger LOGGER = LogManager.getLogger(NTB_RN131_Wifi.class.getName());
	private AsynchronousServerSocketChannel serverSock = null;
	
	AsynchronousSocketChannel mySockChannel = null;
	
	/**
	 * open socket for conections from RN131 Module
	 * @param bindAddr Ipaddress to open socket and listen to (all interfaces 0.0.0.0)
	 * @param bindPort on which port will be listen
	 * @throws IOException
	 */
    public NTB_RN131_Wifi( String bindAddr, int bindPort ) throws IOException {
        InetSocketAddress sockAddr = new InetSocketAddress(bindAddr, bindPort);
        
        //create a socket channel and bind to local bind address
        serverSock =  AsynchronousServerSocketChannel.open().bind(sockAddr);
        
        
       //start to accept the connection from client
        serverSock.accept(serverSock, new CompletionHandler<AsynchronousSocketChannel,AsynchronousServerSocketChannel >() {

            @Override
            public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock ) {
            	mySockChannel = sockChannel;
            	Thread mysender = new Thread();
            	mysender.start();
                //a connection is accepted, start to accept next connection
                serverSock.accept( serverSock, this );
                //start to read message from the client
                startRead( sockChannel );
                
            }

            @Override
            public void failed(Throwable exc, AsynchronousServerSocketChannel serverSock) {
                System.out.println( "fail to accept a connection");
            }
            
        } );
        
    }
    
    /**
     * read data from socket
     * @param sockChannel
     */
    private void startRead( AsynchronousSocketChannel sockChannel ) {
        final ByteBuffer buf = ByteBuffer.allocate(2048);
        
        //read message from client
        sockChannel.read( buf, sockChannel, new CompletionHandler<Integer, AsynchronousSocketChannel >() {

            /**
             * some message is read from client, this callback will be called
             */
            @Override
            public void completed(Integer result, AsynchronousSocketChannel channel  ) {
                buf.flip();
                byte[] bytesArray = new byte[buf.remaining()];
                buf.get(bytesArray, 0, bytesArray.length);
                // echo the message
                if(bytesArray.length == 0)
                {
                	try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	return;
                }
                //LOGGER.debug("byteArray Value: " + Arrays.toString(bytesArray));
                
                switch(bytesArray[0])
                {
                	case -64:
                		if(bytesArray.length > 6 )//&& bytesArray[1] == 17)
                		{
                			RoboControl.partnerRobo.setStatus(PartnerRobo.Status.values()[bytesArray[2]]);
                			double x = ((int)bytesArray[3]) << 4 | ((bytesArray[4] & 0x00F0 ) >> 4 );
                			double y = ((int)bytesArray[4] & 0x000F) << 8 | bytesArray[5];
                			
                			Point point = new Point(x, y, PointType.PARTNER_ROBO, 0);
                			LOGGER.debug("partner");
                			RoboControl.partnerRobo.setPosition(point);
                		}
                		
                		
                		break;
                	case -12:
                		startWrite( channel, buf );
                		break;
                	case -45:
                		if(bytesArray.length > 1){
                			if(bytesArray[1] == -64 )//&& bytesArray[1] == 17)
                    		{
                    			RoboControl.partnerRobo.setStatus(PartnerRobo.Status.values()[bytesArray[3]]);
                    			double x = ((int)bytesArray[4]) << 4 | ((bytesArray[5] & 0x00F0 ) >> 4 );
                    			double y = ((int)bytesArray[5] & 0x000F) << 8 | bytesArray[6];
                    			
                    			Point point = new Point(x, y, PointType.PARTNER_ROBO, 0);
                    			LOGGER.debug("partner");
                    			RoboControl.partnerRobo.setPosition(point);
                    		}
                			
                		}else {
                			startWrite( channel, buf );
                		}
                	default:
                		
                		break;
                }
                
                LOGGER.debug("rec byteArrray length: " + bytesArray.length );//buf.position());
                LOGGER.debug("rec byteArray Value: " + Arrays.toString(bytesArray));
                //start to read next message again
                startRead( channel );
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel channel ) {
            	LOGGER.error( "fail to read message from client");
            }
        });
    }
     
    /**
     * Send update methode Status and position
     */
     public void sendUpdate(byte status, int x , int  y ) {
    	 //cleanClientList();
    	 //int x = (int)RoboControl.robo.getPosition().getxCoordinate();
    	 //int y = (int)RoboControl.robo.getPosition().getyCoordinate();
    	 byte x0 = (byte)((x & 0x0FF0) >> 4); 
    	 byte xy = (byte)(((x & 0x000F) << 4) | ((y & 0x0F00) >> 8)) ;
    	 byte y0 = (byte)(y & 0x00FF);
    	 LOGGER.debug("Send: "+ status + " " + x + " " + y );
    	 LOGGER.debug("Send: "+ x0 + " " + xy + " " + y0 );
    	 byte[] data = {-64, 17, status , x0, xy, y0,-64};
    	 LOGGER.debug(Arrays.toString(data));
    	 //for(AsynchronousSocketChannel channel : listSockChannel)
    	 //{
    	 if(mySockChannel != null)
    	 {
    		 ByteBuffer buf = ByteBuffer.wrap(data);
    		 startWrite(mySockChannel, buf);
    	 }
    	 //}
    	 
     };
     
     
     
     /**
      * Send data to socketChannel
      * @param sockChannel
      * @param buf
      */
     private void startWrite(AsynchronousSocketChannel sockChannel, final ByteBuffer buf) {
         sockChannel.write(buf, sockChannel, new CompletionHandler<Integer, AsynchronousSocketChannel >() {

             @Override
             public void completed(Integer result, AsynchronousSocketChannel channel) {                 
                 //finish to write message to client, nothing to do
             }

             @Override
             public void failed(Throwable exc, AsynchronousSocketChannel channel) {
                 //fail to write message to client
            	 LOGGER.error( "Fail to write message to client");
             }
             
         });
     }
     
//     /**
//      * check if connection active else remove it from listSockChannel
//      */
//     private void cleanClientList()
//     {
//    	 List<AsynchronousSocketChannel> cleanChannel = new ArrayList<AsynchronousSocketChannel>();
//    	 for(AsynchronousSocketChannel channel : listSockChannel)
//    	 {
//    		 if(!channel.isOpen())
//    		 {
//    			 cleanChannel.add(channel);
//    		 }
//    	 }
//    	 for(AsynchronousSocketChannel channel : cleanChannel)
//    	 {
//    		 listSockChannel.remove(channel);
//    	 }
//     }
     
     /**
      * Check if someone is Connected
      * @return
      */
     public boolean isPartnerConnected() {
    	 //cleanClientList();
    	 if(mySockChannel != null) {
    		 if(mySockChannel.isOpen())
    		 {
    			 return true;
    		 }
    	 }
    	 
    	 return false;
     }
     
     /**
      * Close all open channels and socket
      */
     public void stop() {
    	 try {
    	    mySockChannel.close();
    	 
			serverSock.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
     }

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true) {
			sendUpdate(RoboControl.robo.getStatus().getValue(), (int)RoboControl.robo.getPosition().getxCoordinate(), (int)RoboControl.robo.getPosition().getyCoordinate());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
     

}
