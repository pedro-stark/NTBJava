package ch.ntb.orionRobo.drive;

import java.util.ArrayList;
import java.util.List;

import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.environmentRecognition.Point.PointType;

public class RouteCalculator {// extends JFrame {

	private Point initialPoint;
	public static Point finalPoint;
	public int nextRouteColSector = 0;
	public int nextRoutePointX = 0;
	public int nextRoutePointY = 0;
	private boolean routeFound;
	private final int FinalPointRows = 2;
	private final int FinalPointCols = 2;

	private int testvalue = 0;
	private List<Point> path;

	public RouteCalculator(Point initialPoint, int fieldResolution) {

		this.initialPoint = initialPoint;

		/*
		 * this.setPreferredSize(new Dimension(1350, 800)); this.pack();
		 * this.setTitle("Route Calculation COILINATOR");
		 * 
		 * this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 */

	}

	public static void main(String[] args) throws InterruptedException {

		/*
		 * System.out.println("RoutePointX: " + nextRoutePointX);
		 * System.out.println("RoutePointY: " + nextRoutePointY);
		 */

//		Field field = new Field();
//		//Point initialPoint = new Point(660 / 5, 100 / 5);
//		Point initialPoint = new Point(0, 0);
//		Point partnerRoboPosition = new Point(100 / 5, 100 / 5, PointType.UNKNOWN);
//		//.setPartnerRoboByPartnerPoint(partnerRoboPosition);
//		field.setRandomPoints(4);
//		Field.setMultipleObjectsByPoints();
//		RouteCalculator routeCalculator = new RouteCalculator(initialPoint);
//		//routeCalculator.setVisible(true);
//		routeCalculator.nextRoutePointDefiner();
//		routeCalculator.routeDefiner(getFinalPoint());
//		//routeCalculator.RouteSynchronisation();
//
//		//Vector initialVector = new Vector(-1, 0);
//		List<DrivingPoint> dp = new ArrayList<DrivingPoint>();
//		dp = DrivingPoint.getList(RouteCalculator.getPath(), 0);
//		for (int i = 0; i < dp.size(); i++) {
//			System.out.println("distance: " + dp.get(i).getDistance() + " || angle: " + dp.get(i).getAngle());
//		}

//		/*
//		 * for (int k = 0; k < finalPoints.length; k++) { for (int x = 0; x <
//		 * finalPoints[k].length; x++) {
//		 * 
//		 * System.out.println("Row: " + k + " Col: " + x);
//		 * System.out.println("Position X: " + finalPoints[k][x].getRow() *
//		 * Field.fieldSolution); System.out.println("Position Y: " +
//		 * finalPoints[k][x].getCol() * Field.fieldSolution);
//		 * 
//		 * } }
//		 */
//
//		/*
//		 * for (Point item : path) {
//		 * 
//		 * System.out.print("Row: " + item.getRow()); System.out.println(" Col: " +
//		 * item.getCol());
//		 * 
//		 * }
//		 */
//
//		/*System.out.println("RoutePointX: " + nextRoutePointX);
//		System.out.println("RoutePointY: " + nextRoutePointY);*/
//
//
//
//		Thread.sleep(2000);
//
//		System.out.println("-----------------------------------------------------");
//
//		int x = DrivingPoint.getVectorsList().get(DrivingPoint.getVectorsList().size() - 1).getX();
//		int y = DrivingPoint.getVectorsList().get(DrivingPoint.getVectorsList().size() - 1).getY();
//		//initialVector = new Vector(x, y);
//
//		field.deletePartnerRoboPosition(partnerRoboPosition);
//		//routeCalculator.RouteSynchronisation();
//		Thread.sleep(2000);
//		partnerRoboPosition = new Point(620 / 5, 885 / 5, PointType.UNKNOWN);
//		initialPoint = getFinalPoints()[nextRoutePointX][0];
//		Field.setPartnerRoboByPartnerPoint(partnerRoboPosition);
//		//routeCalculator.RouteSynchronisation();
//		Thread.sleep(2000);
//		//routeCalculator.setVisible(false);
//
//		routeCalculator.deleteOldRoute(Field.field);
//		routeCalculator = new RouteCalculator(initialPoint);
//		//routeCalculator.setVisible(true);
//
//		routeCalculator.nextRoutePointDefiner();
//		routeCalculator.routeDefiner(getFinalPoint());
//		//routeCalculator.RouteSynchronisation();
//
//		/*
//		 * for (Point item : path) {
//		 * 
//		 * System.out.print("Row: " + item.getRow()); System.out.println(" Col: " +
//		 * item.getCol());
//		 * 
//		 * }
//		 */
//
//		System.out.println("RoutePointX: " + nextRoutePointX);
//		System.out.println("RoutePointY: " + nextRoutePointY);
//
//		dp = new ArrayList<DrivingPoint>();
//		dp = DrivingPoint.getList(getPath(), 0);
//		for (int i = 0; i < dp.size(); i++) {
//			System.out.println("distance: " + dp.get(i).getDistance() + " || angle: " + dp.get(i).getAngle());
//		}

		// MULTITEST MIT N VERSCHIEDENEN ZUFÄLLIG GESETZTEN GEGNERKONSTELLATIONEN

		/*
		 * int n = 1000; for (int i = 0; i < n; i++) {
		 * 
		 * testvalue = i; field = new Field(); initialPoint = new Point(660 / 5, 100 /
		 * 5); field.setRandomPoints(4); field.setMultipleObjectsByPoints();
		 * routeCalculator = new RouteCalculator(initialPoint, 1);
		 * routeCalculator.routeDefiner(field); if (routeFound == false) {
		 * 
		 * for (int j = 0; j < field.adversary.length; j++) { for (int k = 0; k <
		 * field.adversary[j].length; k++) {
		 * 
		 * if (field.field[(int)
		 * Math.round(field.adversary[j][k].getxCoordinate())][(int) Math
		 * .round(field.adversary[j][k].getyCoordinate())].isBlock() == true) {
		 * 
		 * System.out.println("Adversarynumber X: " + j);
		 * System.out.println("Adversarynumber Y: " + k);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

	}

	/*
	 * public void RouteSynchronisation() {
	 * 
	 * Graphics g = this.getGraphics(); super.paint(g); Graphics2D g2D =
	 * (Graphics2D) g; g2D.scale(4, 4);
	 * 
	 * RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
	 * RenderingHints.VALUE_ANTIALIAS_ON);
	 * 
	 * rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	 * 
	 * g2D.setRenderingHints(rh);
	 * 
	 * g2D.setColor(Color.black); g2D.fillRect(230, 30, 5, 5); String wall = "WALL";
	 * g2D.drawString(wall, 240, 37);
	 * 
	 * g2D.setColor(Color.red); g2D.fillRect(230, 50, 5, 5); String adversary =
	 * "ADVERSARY"; g2D.drawString(adversary, 240, 57);
	 * 
	 * g2D.setColor(Color.green); g2D.fillRect(230, 70, 5, 5); String path =
	 * "EXISTING PATH"; g2D.drawString(path, 240, 77);
	 * 
	 * g2D.setColor(Color.blue); g2D.fillRect(230, 90, 5, 5); String partnerRobo =
	 * "PARTNER ROBO"; g2D.drawString(partnerRobo, 240, 97);
	 * 
	 * int rows = 2; int cols = 4; int fieldSolution = (int) Field.fieldSolution;
	 * int drawOffsetx = 20; int drawOffsety = 20;
	 * 
	 * // Line in Y-Direction int YstartFieldLinePointY = Math.round(25 /
	 * fieldSolution); int YendFieldLinePointY = Math.round(888 / fieldSolution);
	 * int YstartFieldLinePointX = Math.round(254 / fieldSolution); int
	 * YendFieldLinePointX = Math.round(254 / fieldSolution); int
	 * YFieldLinedistanceX = Math.round(251 / fieldSolution);
	 * 
	 * // Line in X-Direction int XstartFieldLinePointY = Math.round(105 /
	 * fieldSolution); int XendFieldLinePointY = Math.round(105 / fieldSolution);
	 * int XstartFieldLinePointX = Math.round(30 / fieldSolution); int
	 * XendFieldLinePointX = Math.round(730 / fieldSolution); int
	 * XFieldLinedistanceY = Math.round(261 / fieldSolution);
	 * 
	 * g2D.setColor(Color.black);
	 * 
	 * for (int i = 0; i < rows; i++) {
	 * 
	 * g2D.drawLine(YstartFieldLinePointY + drawOffsety, YstartFieldLinePointX +
	 * drawOffsetx + ((i * YFieldLinedistanceX)), YendFieldLinePointY + drawOffsety,
	 * YendFieldLinePointX + ((i * YFieldLinedistanceX)) + drawOffsetx);
	 * 
	 * }
	 * 
	 * for (int i = 0; i < cols; i++) {
	 * 
	 * g2D.drawLine(XstartFieldLinePointY + drawOffsety + ((i *
	 * XFieldLinedistanceY)), XstartFieldLinePointX + drawOffsetx,
	 * XendFieldLinePointY + drawOffsety + (i * XFieldLinedistanceY),
	 * XendFieldLinePointX + drawOffsetx);
	 * 
	 * }
	 * 
	 * for (int i = 0; i < Field.field.length; i++) { for (int j = 0; j <
	 * Field.field[i].length; j++) {
	 * 
	 * if (Field.field[i][j].getpType() == PointType.WALL) {
	 * 
	 * g2D.setColor(Color.black); g2D.fillRect(j + drawOffsetx, i + drawOffsety, 1,
	 * 1); }
	 * 
	 * else if (Field.field[i][j].getpType() == PointType.ADVERSARY) {
	 * 
	 * g2D.setColor(Color.red); g2D.fillRect(j + drawOffsetx, i + drawOffsety, 1,
	 * 1); }
	 * 
	 * else if (Field.field[i][j].getpType() == PointType.DRIVING_POINT) {
	 * 
	 * g2D.setColor(Color.green); g2D.fillRect(j + drawOffsetx, i + drawOffsety, 1,
	 * 1); }
	 * 
	 * else if (Field.field[i][j].getpType() == PointType.PARTNER_ROBO) {
	 * 
	 * g2D.setColor(Color.blue); g2D.fillRect(j + drawOffsetx, i + drawOffsety, 1,
	 * 1); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	public Point[][] setFinalPoints(int firstFinalPointX, int firstFinalPointY, int distanceX, int distanceY, int rows,
			int cols) {

		Point[][] localPoints = new Point[FinalPointRows][FinalPointCols];

		for (int i = 0; i < FinalPointRows; i++) {
			for (int j = 0; j < FinalPointCols; j++) {

				localPoints[i][j] = new Point((firstFinalPointX + (i * distanceX)),
						(firstFinalPointY + (j * distanceY)));
				localPoints[i][j].setPointType(PointType.Final_Point);

			}

		}
		return localPoints;

	}

	public List<Point> nextPosiblePostion(Point[][] points,int nextColValue) { 
		int minRoutePointsValue = 1;
		routeFound = false;
		List<Point> localpath = new ArrayList<Point>();

		for (int i = points.length - 1; i >= 0; i--) {

			finalPoint = new Point(points[i][nextColValue].getRow(), points[i][nextColValue].getCol());

			AStar aStar = new AStar(initialPoint, finalPoint, RoboControl.field.getField()); 
			//AStar aStar = new AStar(initialPoint, finalPoint, field);
			localpath = aStar.findPath();

			if (localpath.size() > minRoutePointsValue) {
				for (Point Point : localpath) {
					
					System.out.println("Versuch NR.: " + testvalue + " : " + routeFound);
					
				}

				routeFound = true;

				break;
			}

			else {

				System.out.println("Versuch NR.: " + testvalue + " : " + routeFound);

			}

		}
		return localpath;

	}
	
	public List<Point> nextPosiblePostionTestMethode(Point[][] points,int nextColValue, Point[][] field) { //, Parameter zum testen für TestClass Point[][] field

		int minRoutePointsValue = 1;
		routeFound = false;
		List<Point> localpath = new ArrayList<Point>();

		for (int i = points.length - 1; i >= 0; i--) {

			//Hier Fehler? 
			finalPoint = new Point(points[i][nextColValue].getRow(), points[i][nextColValue].getCol());
			//finalPoint = new Point(26, 47);
			

			AStar aStar = new AStar(initialPoint, finalPoint, field); 
			//AStar aStar = new AStar(initialPoint, finalPoint, field);
			localpath = aStar.findPath();

			if (localpath.size() > minRoutePointsValue) {
				
				
				for (Point Point : localpath) {
					// System.out.println("Ist Point");
					
				}

				routeFound = true;
				System.out.println("Versuch NR.: " + testvalue + " : " + routeFound);

				break;
			}

			else {

				System.out.println("Versuch NR.: " + testvalue + " : " + routeFound);

			}

		}
		return localpath;

	}


	public void routeDefiner(Point FinalPoint) {

		int minRoutePointsValue = 1;
		routeFound = false;

		AStar aStar = new AStar(initialPoint, FinalPoint, RoboControl.field.getField());
		setPath(aStar.findPath());

		if (getPath().size() > minRoutePointsValue) {
//			for (Point Point : getPath()) {
//				// System.out.println(Point);
//			}

			RoboControl.field.setDrivingPoints(getPath());
			routeFound = true;
			System.out.println("Versuch NR.: " + testvalue + " : " + routeFound);

		}
	}

	public void deleteOldRoute(List<Point> pointsToDrive,Point[][] field) {

		for (Point Point : pointsToDrive) {

			field[Point.getRow()][Point.getCol()].setBlock(false);
			field[Point.getRow()][Point.getCol()].setPointType(null);

		}

	}

	public Point getFinalPoint() {

		return finalPoint;
	}

	public int getNextRouteColSector() {
		return nextRouteColSector;
	}

	public void setNextRouteColSector(int nextRouteColSector) {
		this.nextRouteColSector = nextRouteColSector;
	}

	public List<Point> getPath() {
		return path;
	}

	public void setPath(List<Point> path) {
		this.path = path;
	}

	public boolean getrouteFound() {
		return routeFound;
	}

}
