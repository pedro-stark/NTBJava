package ch.ntb.orionRobo.drive;

import ch.ntb.orionRobo.component.VoiceCoil;
import ch.ntb.orionRobo.environmentRecognition.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.math.*;

public class Vector {
	private int x;
	private int y;
	private static final Logger LOGGER = LogManager.getLogger(VoiceCoil.class.getName());

	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Vector v) {
		if (this.x == v.getX() && this.y == v.getY()) {
			return true;
		} else {
			return false;
		}
	}

	public double getTurnAngle(Vector v) {
		double d = 0;

		d = (this.x * v.getX() + this.y * v.getY()) / (Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)))
				* Math.sqrt((Math.pow(v.getX(), 2) + Math.pow(v.getY(), 2))));

		d = Math.round(Math.toDegrees(Math.acos(d)) * 100) / 100.0;

		if (d == 180) {

			return d;
		}

		return d * Math.signum(this.x * v.getY() - v.getX() * this.y);// Kreuzprodukt Z-Linie
	}

	public double getTurnAngleToPartnerByPoint(Point deltaPoint) {

		double d = 0;

		d = (this.x * deltaPoint.getxCoordinate() + this.y * deltaPoint.getyCoordinate())
				/ (Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2))) * Math
						.sqrt((Math.pow(deltaPoint.getxCoordinate(), 2) + Math.pow(deltaPoint.getyCoordinate(), 2))));

		d = Math.round(Math.toDegrees(Math.acos(d)) * 100) / 100.0;

		if (d == 180) {

			LOGGER.info("Winkel zu Partner: " + d);

			return d;

		}



		d = d * Math.signum(this.x * deltaPoint.getyCoordinate() - deltaPoint.getxCoordinate() * this.y);// Kreuzprodukt
		LOGGER.info("Winkel zu Partner: " + d);
		return d; // Z-Linie

	}

//	public double getTurnAngle(Vector v) {
//		double absolutValueV1 = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
//		double absolutValueV2 = Math.sqrt(Math.pow(v.getX(),2)+Math.pow(v.getY(),2));
//		double angleV1 = Math.round(Math.toDegrees(Math.acos(this.x/absolutValueV1)));
//		double angleV2 = Math.round(Math.toDegrees(Math.acos(v.getX()/absolutValueV2)));
//		
//		if(this.y<0) {
//			angleV1 += 180;
//		}
//		
//		if(v.getY()<0) {
//			angleV2 += 180;
//		}
//		
//		return angleV1 - angleV2;
//	}

	public boolean isDiagonal() {
		if (this.x != 0 && this.y != 0) {
			return true;
		} else {
			return false;
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
