package ch.ntb.orionRobo.drive;

import ch.ntb.orionRobo.environmentRecognition.*;
import ch.ntb.orionRobo.*;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import ch.ntb.orionRobo.drive.AStar;

public class DrivingPoint {
	private double distance;
	private double angle;
	private static List<Vector> vectors;

	public DrivingPoint(double distance, double angle) {
		this.distance = distance;
		this.angle = angle;
	}

	public DrivingPoint() {
		this.distance = 0;
		this.angle = 0;
	}

	public enum driveType {
		LINEAR, TURN
	}

	public static List<DrivingPoint> getList(List<Point> points, double roboAngle) {
		// Um die Liste, die abgearbeitetet werden muss, korrekt auszuführen,
		// muss immer zuerst die Distanz gefahren werden und dann der Winkel.
		List<DrivingPoint> dp = new ArrayList<DrivingPoint>();
		Vector startVector = new Vector((int) Math.round(Math.cos(Math.toRadians(roboAngle)) * 100000),
				(int) Math.round(Math.sin(Math.toRadians(roboAngle)) * 100000));
		List<Vector> vectors = getVector(points, startVector);
		double val = 0;

		if (points.size() > 0) {

			for (int i = 1; i < vectors.size(); i++) {

				if (vectors.get(i - 1).getTurnAngle(vectors.get(i)) == 0 && vectors.get(i - 1).isDiagonal() && i != 1) {
					val += 7.071067811;
				} else if (vectors.get(i - 1).getTurnAngle(vectors.get(i)) == 0 && !vectors.get(i - 1).isDiagonal() && i != 1) {
					val += 5;
				}

				if (vectors.get(i - 1).getTurnAngle(vectors.get(i)) != 0 && !vectors.get(i - 1).isDiagonal()) {
					if (i != 1) {
						dp.add(new DrivingPoint(val + 5, vectors.get(i - 1).getTurnAngle(vectors.get(i))));
					} else {
						dp.add(new DrivingPoint(0, vectors.get(i - 1).getTurnAngle(vectors.get(i))));
					}
					val = 0;

				} else if (vectors.get(i - 1).getTurnAngle(vectors.get(i)) != 0 && vectors.get(i - 1).isDiagonal()) {
					if (i != 1) {
						dp.add(new DrivingPoint(val + 7.071067811, vectors.get(i - 1).getTurnAngle(vectors.get(i))));
					} else {
						dp.add(new DrivingPoint(0, vectors.get(i - 1).getTurnAngle(vectors.get(i))));
					}
					val = 0;
				}

			}

			if (vectors.get(vectors.size() - 1).isDiagonal()) {
				val += 7.071067811;
			} else {
				val += 5;
			}

			dp.add(new DrivingPoint(val, 0));
			return dp;

		}

		return null;

	}

	public static List<Vector> getVector(List<Point> points, Vector startVector) {
		vectors = new ArrayList<Vector>();
		vectors.add(startVector);

		for (int i = 1; i < points.size(); i++) {

			vectors.add(new Vector(points.get(i).getRow() - points.get(i - 1).getRow(),
					points.get(i).getCol() - points.get(i - 1).getCol()));

		}

		return vectors;
	}

//	public static DrivingPoint readyToShoot(Robo robo, PartnerRobo pRobo) {
//		//evtl new Vector zu (1,0)
//		double xDiff = robo.getPosition().getxCoordinate()- pRobo.getPosition().getxCoordinate();
//		double yDiff = robo.getPosition().getyCoordinate()- pRobo.getPosition().getyCoordinate();
//		double angle = robo.getStartvector().getTurnAngle((new Vector(0,1)));
//		double distance = Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));
//		
//		return new DrivingPoint(angle, distance);
//	}

	public static void main(String[] args) {
		Vector a = new Vector(0, 1);
		Vector b = new Vector(1, 0);
		Vector c = new Vector(-1, -1);

		if (a.equals(b)) {
			System.out.println("A und B sind gleich");
		}
		if (!a.equals(b)) {
			System.out.println("A und B sind ungleich");
		}
		if (a.equals(c)) {
			System.out.println("A und C sind gleich");
		}
		if (!a.equals(c)) {
			System.out.println("A und C sind ungleich");
		}

		System.out.println("Winkel zwischen a und b: " + a.getTurnAngle(b));
		System.out.println("Winkel zwischen a und c: " + a.getTurnAngle(c));

		List<Point> vv = new ArrayList<Point>();
		vv.add(new Point(1, 1));
//		vv.add(new Point(1, 1));
	    vv.add(new Point(2, 2));
		vv.add(new Point(3, 3));
		vv.add(new Point(4, 4));
		vv.add(new Point(4, 5));
		vv.add(new Point(4, 6));
		vv.add(new Point(4, 7));
		vv.add(new Point(5, 7));
		vv.add(new Point(6, 7));
		vv.add(new Point(7, 7));
		vv.add(new Point(7, 6));
		vv.add(new Point(7, 5));
		vv.add(new Point(7, 4));
		vv.add(new Point(7, 3));
		vv.add(new Point(8, 2));
		vv.add(new Point(8, 1));

		List<Vector> v = new ArrayList<Vector>();
		List<DrivingPoint> dp = new ArrayList<DrivingPoint>();
		Point initialPoint = new Point(30, 50);
		Point finalPoint = new Point(70, 60);
		// Field feld = new Field();
		// System.out.println(feld.field.length);

		System.out.println("Feld erstellt");

		// AStar aStar = new AStar(initialPoint, finalPoint, feld);
		// List<Point> path = aStar.findPath();

		// System.out.println("Pfad gefunden mit Inhalten: " + path.size());

		// v = getVector(path);
		// System.out.println("Vektorliste erstellt mit Inhalten: " + v.size());

		v = getVector(vv, a);

		System.out.println("Startvector x/y: " + a.getX() + "/" + a.getY());
		for (int i = 0; i < v.size(); i++) {
			System.out.println("Vector Value x/y: " + v.get(i).getX() + "/" + v.get(i).getY());
		}

		double aa = 90;

		dp = getList(vv, aa);

		for (int i = 0; i < dp.size(); i++) {
			System.out.println("distance: " + dp.get(i).getDistance() + " || angle: " + dp.get(i).getAngle());
		}
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public static List<Vector> getVectorsList() {

		return vectors;
	}

}
