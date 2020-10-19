/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.PartnerRobo.java
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

import ch.ntb.orionRobo.Robo.Status;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.environmentRecognition.Point.PointType;

/**
 * 
 */
public class PartnerRobo{


	public enum Status{
		UNKNOWN((byte)0),
		HAS_BALL((byte)1),
		AT_POSITON((byte)2),
		DRIVE((byte)3),
		FINISHED((byte)4),
		SHOOT((byte)5),	
		INITIALIZING((byte)6),
		CONNECT_WITH_PARTNER((byte)7),
		ERROR((byte)8);
		private final byte value;
		

		
		Status(final byte newValue){
			value = newValue;
		}
		public byte getValue() {
			return value;
		}
		
	}
	
	protected Status status;
	
	protected Point position;
	
	
	
////////////////////////////////////////////////
	

	public PartnerRobo(Point.PointType pointType) {
		setPosition(new Point(0, 0, PointType.ROBO, 90.0));
		setStatus(Status.UNKNOWN);
		//startVector = new Vector(0,0);
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
		//RoboControl.partnerCom.sendUpdate(status.getValue(), (int)Math.round(this.position.getxCoordinate()), (int)Math.round(this.position.getyCoordinate()));
	}
	


	public Point getPosition() {
		return position;
	}


	public void setPosition(Point position) {
		//TODO set Robo postion in field
		this.position = position;
	}
	
	
}
