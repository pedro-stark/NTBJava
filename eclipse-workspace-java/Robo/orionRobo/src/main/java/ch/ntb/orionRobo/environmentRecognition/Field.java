/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.environmentRecognition.environmentScaner.java
 * 
 * @author Tim Helbock <timdominik.helbock@ntb.ch>
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

package ch.ntb.orionRobo.environmentRecognition;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.ntb.orionRobo.environmentRecognition.Point.*;

public class Field {

	public Point[][] field;
	public int fieldSizeX = 760;
	public int fieldSizeY = 1008;
	public int fieldResolution = 5;
	private static final double firstAdversaryPositionX = 130;
	private static final double firstAdversaryPositionY = 236;
	private static final double distanceXAdversaryToAdversary = 166.67;
	private static final double distanceYAdversaryToAdversary = 261;
	private static final int colsAdversarys = 3;
	private static final int rowsAdversarys = 4;
	private static final int safetyDistance = 10;
	private static final int radiusRobot = 80;
	private static final double adversaryRadius = 24 + radiusRobot;
	public Point[][] adversary;

	private static final Logger LOGGER = LogManager.getLogger(Field.class.getName());

	public Field() {

		adversary = new Point[rowsAdversarys][colsAdversarys];
		field = createField(fieldSizeX, fieldSizeY, fieldResolution);
		setWalls(field);
		setAdversaryPositions(firstAdversaryPositionX / fieldResolution, firstAdversaryPositionY / fieldResolution,
				distanceXAdversaryToAdversary / fieldResolution, distanceYAdversaryToAdversary / fieldResolution,
				rowsAdversarys, colsAdversarys);

	}

	public static void main(String[] args) {

		Field Basketballfeld = new Field();
		for (int i = 0; i <= Basketballfeld.adversary.length - 1; i++) {
			for (int j = 0; j <= Basketballfeld.adversary[j].length - 1; j++) {
				System.out.print("X-Koordinate " + Basketballfeld.adversary[i][j].getxCoordinate() * 5 + "    ");
				System.out.println("Y-Koordinate " + Basketballfeld.adversary[i][j].getyCoordinate() * 5);
			}
		}

	}

//	private void getRoboCoord() {
//		for (int j = 0; j < field.length; j++)
//			for (int i = 0; i < field[0].length; i++) {
//				if (field[j][i].getpType() == Point.PointType.ROBO) {
//					roboRow = j;
//					roboCol = i;
//				}
//			}
//
//	}

	public void setAdversaryPositions(double firstAdversaryX, double firstAdversaryY, double distanceX,
			double distanceY, int rows, int cols) {

		/*
		 * Setzt durch definieren von:
		 * 
		 * 1.) Startpositionen in X/Y ->
		 * "firstAdversaryPositionX"/"firstAdversaryPositionY" 2.) Delta Position in X/Y
		 * -> "distanceXAdversaryToAdversary"/"distanceYAdversaryToAdversary" 3.) Anzahl
		 * Spalten (Y) ->"colsAdversarys" 4.) Anzahl Zeilen (X) -> "rowsAdversarys"
		 * 
		 * mögliche Gegnerpositionen in ein Array.
		 * 
		 **/

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				adversary[i][j] = new Point(firstAdversaryX + (i * distanceX), firstAdversaryY + (j * distanceY),
						PointType.UNKNOWN);
				adversary[i][j].setBlock(false);

			}

		}

	}

	public void setAdversary(int adversaryNumberX, int adversaryNumberY) {

		/*
		 * 
		 * Setzt durch Eingabe der Positionsnummer des in der Methode
		 * ("setAdversaryPositions") gesetzten Arrays einen Gegner auf dessen X/Y
		 * Koordinate, dabei ist die größe des Gegners abhängig von
		 * 
		 * 1.) Dessen definierten Radiuses - > ("adversaryRadius") 2.) zusätzlicher
		 * Sicherheitsabstand -> ("safetyDistance") 3.) Radius des Roboters
		 * ->("radiusRobot")
		 * 
		 * Dabei wird nicht die Anzahl gemessener Punkt in diesem Bereich verwendet und
		 * nach dieser gesetzt
		 * 
		 **/

		double adversaryPositionX = adversary[adversaryNumberX][adversaryNumberY].getxCoordinate();
		double adversaryPositionY = adversary[adversaryNumberX][adversaryNumberY].getyCoordinate();

		for (int i = 0; i < (int) Math
				.round((((adversaryRadius * 2) + safetyDistance+5) / fieldResolution) + 1); i++) {
			for (int j = 0; j < (int) Math
					.round((((adversaryRadius * 2) + safetyDistance +5) / fieldResolution) + 1); j++) {
//				if (field[(int) (Math.round(adversaryPositionX))][(int) (Math.round(adversaryPositionY))]
//						.isBlock() == true) {

				if ((i + ((int) (Math
						.round(adversaryPositionX - ((adversaryRadius + safetyDistance) / fieldResolution)))) > 0)
						&& (j + ((int) (Math.round(
								adversaryPositionY - ((adversaryRadius + safetyDistance) / fieldResolution)))) > 0)
						&& (i + ((int) (Math.round(adversaryPositionX
								- ((adversaryRadius + safetyDistance) / fieldResolution)))) < field.length - 1)
						&& (j + ((int) (Math.round(adversaryPositionY
								- ((adversaryRadius + safetyDistance) / fieldResolution)))) < field[0].length - 1)) {
//						&& ((field[i + ((int) (Math
//								.round(adversaryPositionX - ((adversaryRadius + safetyDistance) / fieldResolution))))][j
//										+ ((int) (Math.round(adversaryPositionY
//												- ((adversaryRadius + safetyDistance) / fieldResolution))))]
//														.getpType() == PointType.UNKNOWN)
//								|| (field[i + ((int) (Math.round(adversaryPositionX
//										- ((adversaryRadius + safetyDistance) / fieldResolution))))][j
//												+ ((int) (Math.round(adversaryPositionY
//														- ((adversaryRadius + safetyDistance) / fieldResolution))))]
//																.getpType() == PointType.PARTNER_ROBO)) {

					field[i + ((int) (Math
							.round(adversaryPositionX - ((adversaryRadius + safetyDistance) / fieldResolution))))][j
									+ ((int) (Math.round(adversaryPositionY
											- ((adversaryRadius + safetyDistance) / fieldResolution))))].setBlock(true);
					field[i + ((int) (Math
							.round(adversaryPositionX - ((adversaryRadius + safetyDistance) / fieldResolution))))][j
									+ ((int) (Math.round(adversaryPositionY
											- ((adversaryRadius + safetyDistance) / fieldResolution))))]
													.setPointType(PointType.ADVERSARY);

					// }
				}

			}

		}

	}

	public void setMultipleAdversarys() {

		/*
		 * Setzen von mehreren Gegnern auf einmal
		 * 
		 */

		for (int i = 0; i < adversary.length; i++) {
			for (int j = 0; j < adversary[i].length; j++) {

				setAdversary(i, j);

			}

		}
	}

	public Point[][] createField(int fieldSizeInX, int fieldSizeInY, double fieldSolution) {

		/*
		 * Erstellen des Spielfeldes, abhängig von:
		 * 
		 * 1.) Breite in X -> "fieldSizeinX" 2.) Breite in Y -> "fieldSizeInY" 3.)
		 * Feldauflösung -> "fieldSolution"
		 * 
		 **/

		fieldSizeX = (int) (fieldSizeInX / fieldSolution);
		fieldSizeY = (int) (fieldSizeInY / fieldSolution);

		if ((fieldSizeX % fieldSolution) != 0.0) {

			fieldSizeX = (int) (Math.ceil(fieldSizeInX / (fieldSolution)));

		}

		if ((fieldSizeY % fieldSolution) != 0.0) {

			fieldSizeY = (int) (Math.ceil(fieldSizeInY / (fieldSolution)));

		}

		Point[][] localPoint = new Point[fieldSizeX][fieldSizeY];

		for (int i = 0; i < localPoint.length; i++) {
			for (int j = 0; j < localPoint[0].length; j++) {
				Point point = new Point(i, j);
				localPoint[i][j] = point;
			}
		}

		return localPoint;
	}

	public void setWalls(Point[][] fieldArray) {

		/*
		 * 
		 * Setzen der Wände des Spielfeldes abhängig von:
		 * 
		 * 1.) zusätzlicher Sicherheitsabstand -> ("safetyDistance") 2.) Radius des
		 * Roboters ->("radiusRobot")
		 * 
		 **/

		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray[i].length; j++) {
				if (i < (radiusRobot / fieldResolution + safetyDistance / fieldResolution + 1)
						|| j < (radiusRobot / fieldResolution + safetyDistance / fieldResolution + 1)
						|| i > (fieldArray.length - 1
								- (radiusRobot / fieldResolution + safetyDistance / fieldResolution + 1))
						|| j > (fieldArray[0].length - 1
								- (radiusRobot / fieldResolution + safetyDistance / fieldResolution + 1))) {

					fieldArray[i][j].setBlock(true);
					fieldArray[i][j].setPointType(PointType.WALL);
				}
			}
		}
	}

	public void setPointsBeforeAlignment(List<Point> scannedPoints, Point initialPoint) {

		/*
		 * 
		 * Ins Feld setzen der gemessenen Punkte aus gegebener List
		 * 
		 **/
		// Point point = new Point((Math.cos(Math.toRadians(degree)) *
		// distance)+roboX,(Math.sin(Math.toRadians(degree))* distance)+roboY,
		// Point.PointType.UNKNOWN, degree);

		for (Point item : scannedPoints) {

			if ((field[(int) Math.round(item.getxCoordinate())][(int) Math.round(item.getyCoordinate())]
					.getpType() == null)) {
				field[(int) Math.round(item.getxCoordinate())][(int) Math.round(item.getyCoordinate())].setBlock(true);
				field[(int) Math.round(item.getxCoordinate())][(int) Math.round(item.getyCoordinate())]
						.setPointType(PointType.UNKNOWN);

			}
		}

	}

	public void setPointsAfterAlignment(List<Point> scannedPoints, int fieldResolution) {

		/*
		 * 
		 * Ins Feld setzen der gemessenen Punkte aus gegebener List
		 * 
		 **/

		for (Point item : scannedPoints) {

			if (item.getxCoordinate() / fieldResolution < fieldSizeX - 1
					&& item.getyCoordinate() / fieldResolution < fieldSizeY - 1 && item.getxCoordinate() > 0
					&& item.getyCoordinate() > 0) {

				if ((field[(int) (Math.round(item.getxCoordinate() / fieldResolution))][(int) (Math
						.round(item.getyCoordinate() / fieldResolution))].getpType() == null)) {
					field[(int) (Math.round(item.getxCoordinate() / fieldResolution))][(int) (Math
							.round(item.getyCoordinate() / fieldResolution))].setBlock(true);
					field[(int) (Math.round(item.getxCoordinate() / fieldResolution))][(int) (Math
							.round(item.getyCoordinate() / fieldResolution))].setPointType(PointType.UNKNOWN);

				}
			}
		}

	}

	public void setDrivingPoints(List<Point> scannedPoints) {

		/*
		 * 
		 * Ins Feld setzen der gemessenen Punkte aus gegebenem Array
		 * 
		 **/

		for (Point item : scannedPoints) {
			field[item.getRow()][item.getCol()].setBlock(true);
			field[item.getRow()][item.getCol()].setPointType(PointType.DRIVING_POINT);

		}
	}

	public void setPoint(Point measuredPoint) {

		/*
		 * 
		 * Ins Feld setzen eines einzelnen gemessenen Punkts
		 * 
		 **/

		if ((field[(int) Math.round(measuredPoint.getyCoordinate() / fieldResolution)][(int) Math
				.round(measuredPoint.getxCoordinate() / fieldResolution)].getpType() != PointType.ADVERSARY)) {
			field[(int) Math.round(measuredPoint.getyCoordinate() / fieldResolution)][(int) Math
					.round(measuredPoint.getxCoordinate() / fieldResolution)].setBlock(true);
			field[(int) Math.round(measuredPoint.getyCoordinate() / fieldResolution)][(int) Math
					.round(measuredPoint.getxCoordinate() / fieldResolution)].setPointType(PointType.UNKNOWN);
		}
	}

	public void setObjectByPoint(int adversaryNumberX, int adversaryNumberY, int minAmountOfPoints) {

		/*
		 * Analyse der möglichen Gegnerposition gegeben durch Methode
		 * "setAdversaryPositions" und dessen erzeugtem Array. Dabei werden die am Feld
		 * gesetzten Punkte ermittelt und falls bei einer möglichen Gegnerposition eine
		 * mindest Anzahl an Punkten gemessen wurden, wird an dieser Position durch die
		 * Methode "setAdversary" ein Gegner gesetzt
		 * 
		 **/

		double adversaryPositionX = adversary[adversaryNumberX][adversaryNumberY].getxCoordinate();
		double adversaryPositionY = adversary[adversaryNumberX][adversaryNumberY].getyCoordinate();
		int neighbourcounter = 0;

		System.out.println("AdversaryPosition X " + adversary[adversaryNumberX][adversaryNumberY].getxCoordinate());
		System.out.println("AdversaryPosition Y " + adversary[adversaryNumberX][adversaryNumberY].getyCoordinate());

		for (int i = 0; i < (int) Math.round(((adversaryRadius * 2) / (fieldResolution)) + 1); i++) {
			for (int j = 0; j < (int) Math.round(((adversaryRadius * 2) / (fieldResolution)) + 1); j++) {

				if ((field[i + ((int) (Math.round(adversaryPositionX - (adversaryRadius / fieldResolution))))][j
						+ ((int) (Math.round(adversaryPositionY - (adversaryRadius / fieldResolution))))]
								.isBlock() == true)
						&&

						(field[i + ((int) (Math.round(adversaryPositionX - (adversaryRadius / fieldResolution))))][j
								+ ((int) (Math.round(adversaryPositionY - (adversaryRadius / fieldResolution))))]
										.getpType() == (PointType.UNKNOWN))) {

					neighbourcounter++;

				}

			}

		}

		if (neighbourcounter >= minAmountOfPoints) {

			this.setAdversary(adversaryNumberX, adversaryNumberY);

		}

	}

	public void setPartnerRobobByToF(Field[][] currentField) {

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {

				if (field[i][j].isBlock() == true && field[i][j].getpType() == PointType.UNKNOWN) {

					field[i][j].setPointType(PointType.PARTNER_ROBO);

				}

				else if (field[i][j].isBlock() == true && field[i][j].getpType() == PointType.PARTNER_ROBO) {

					field[i][j].setPointType(PointType.UNKNOWN);
					field[i][j].setBlock(false);

				}

			}

		}

	}

	public void deletePartnerRoboPosition(Point currentPartnerPosition) {

		for (int i = 0; i < (int) Math.round(((radiusRobot * 2) + safetyDistance * 2) / fieldResolution) + 1; i++) {
			for (int j = 0; j < (int) Math.round(((radiusRobot * 2) + safetyDistance * 2) / fieldResolution) + 1; j++) {

				/*
				 * if ((field[i + ((int)
				 * (Math.round(currentPartnerPosition.getxCoordinate()/fieldSolution -
				 * ((radiusRobot + safetyDistance) / fieldSolution))))][j + ((int)
				 * (Math.round(currentPartnerPosition.getyCoordinate()/fieldSolution -
				 * ((radiusRobot + safetyDistance) / fieldSolution))))] .getpType() !=
				 * (PointType.ADVERSARY))) {
				 */

				int currentPositionX = (int) Math.round(currentPartnerPosition.getxCoordinate())
						- ((int) Math.round(((radiusRobot) + safetyDistance) / fieldResolution)) + i;

				int currentPositionY = (int) Math.round(currentPartnerPosition.getyCoordinate())
						- ((int) Math.round(((radiusRobot) + safetyDistance) / fieldResolution)) + j;

				if ((currentPositionX >= 0) && (currentPositionY >= 0)
						&& field[currentPositionX][currentPositionY].getpType() == PointType.PARTNER_ROBO) {

					field[currentPositionX][currentPositionY].setBlock(false);
					field[currentPositionX][currentPositionY].setPointType(null);
				}
			}

		}

	}

	public void setPartnerRoboByPartnerPoint(Point currentPartnerPosition) {

		for (int i = 0; i < (int) Math.round(((radiusRobot * 2) + safetyDistance * 2) / fieldResolution) + 1; i++) {
			for (int j = 0; j < (int) Math.round(((radiusRobot * 2) + safetyDistance * 2) / fieldResolution) + 1; j++) {

				/*
				 * if ((field[i + ((int)
				 * (Math.round(currentPartnerPosition.getxCoordinate()/fieldSolution -
				 * ((radiusRobot + safetyDistance) / fieldSolution))))][j + ((int)
				 * (Math.round(currentPartnerPosition.getyCoordinate()/fieldSolution -
				 * ((radiusRobot + safetyDistance) / fieldSolution))))] .getpType() !=
				 * (PointType.ADVERSARY))) {
				 */

				int currentPositionX = (int) Math.round(currentPartnerPosition.getxCoordinate())
						- ((int) Math.round(((radiusRobot) + safetyDistance) / fieldResolution)) + i;

				int currentPositionY = (int) Math.round(currentPartnerPosition.getyCoordinate())
						- ((int) Math.round(((radiusRobot) + safetyDistance) / fieldResolution)) + j;

				if ((currentPositionX >= 0) && (currentPositionY >= 0)
						&& field[currentPositionX][currentPositionY].getpType() == null) {

					field[currentPositionX][currentPositionY].setBlock(true);
					field[currentPositionX][currentPositionY].setPointType(PointType.PARTNER_ROBO);

				}
			}

		}

	}

	public void setMultipleObjectsByPoints() {

		/*
		 * 
		 * Setzten mehrerer Gegner, abhängig von gemessenen Punkten auf einmal
		 * 
		 **/

		for (int i = 0; i < this.adversary.length; i++) {
			for (int j = 0; j < this.adversary[i].length; j++) {

				setObjectByPoint(i, j, 5);

			}

		}

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {

				if (field[i][j].getpType() == PointType.UNKNOWN) {

					field[i][j].setBlock(false);
					field[i][j].setPointType(null);

				}

			}
		}
	}

	public void setRandomPoints(int adversaryNumbers) {

		/*
		 * 
		 * Setzen von Zufallsgegnern die auf den möglichen Gegnerpositionen stehen
		 * können, welche durch die Methode "setAdversaryPositions" bestimmt wurden.
		 * Durch Eingabe einer GegnerAnzahl -> ("adversaryNumbers"), kann die Anzahl der
		 * Zufallsgegner bestimmt werden
		 * 
		 **/

		Random random = new Random();
		int randomx;
		int randomy;
		for (int i = 0; i < adversaryNumbers; i++) {

			randomx = random.nextInt(adversary.length);
			randomy = random.nextInt(adversary[randomx].length);
			/*
			 * System.out.println(testvalue+ " Randomwert X: " + randomx);
			 * System.out.println(testvalue+ " Randomwert Y: " + randomy);
			 * System.out.println(testvalue+ " GegnerArray X-Wert: " + (int)
			 * Math.round(adversary[randomx][randomy].getxCoordinate()));
			 * System.out.println(testvalue+ " GegnerArray Y-Wert: " + (int)
			 * Math.round(adversary[randomx][randomy].getyCoordinate()));
			 * System.out.println(field[(int)
			 * Math.round(adversary[randomx][randomy].getxCoordinate())][(int) Math
			 * .round(adversary[randomx][randomy].getyCoordinate())].isBlock());
			 * System.out.println(field[(int)
			 * Math.round(adversary[randomx][randomy].getxCoordinate())][(int) Math
			 * .round(adversary[randomx][randomy].getyCoordinate())].isBlock());
			 */

			if (field[(int) Math.round(adversary[randomx][randomy].getxCoordinate())][(int) Math
					.round(adversary[randomx][randomy].getyCoordinate())].isBlock() == false) {

				field[(int) Math.round(adversary[randomx][randomy].getxCoordinate())][(int) Math
						.round(adversary[randomx][randomy].getyCoordinate())].setBlock(true);

				field[(int) Math.round(adversary[randomx][randomy].getxCoordinate())][(int) Math
						.round(adversary[randomx][randomy].getyCoordinate())].setPointType(PointType.UNKNOWN);
				;

			}

			else {

				i -= 1;

			}

		}
		// testvalue++;

	}

	public void setBlocks(int[][] blocksArray) {
		for (int i = 0; i < blocksArray.length; i++) {
			int row = blocksArray[i][0];
			int col = blocksArray[i][1];
			setBlock(row, col);
		}
	}

	private void setBlock(int row, int col) {
		this.field[row][col].setBlock(true);
	}

	public Point[][] getField() {
		return field;
	}

	public void setField(Point[][] field) {
		this.field = field;
	}

	public void printfield(Point[][] field) {

		for (int i = 0; i < field.length; i++) {

			for (int j = 0; j < field[i].length; j++) {

				if (j < field[i].length - 1) {

					System.out.print(field[i][j]);
				} else {

					System.out.println(field[i][j]);

				}

			}

		}

	}

	public void printfieldinint(Point[][] field) {

		final int Wall = 0;
		final int Adversary = 1;
		final int DrivinPoint = 2;
		final int Robo = 3;
		final int PartnerRobo = 4;
		final int Unknown = 0;
		String result = "";

		for (int i = 0; i < field.length; i++) {

			for (int j = 0; j < field[i].length; j++) {

				if (j < field[i].length - 1) {

					if (field[i][j].isBlock() == true && (field[i][j].getpType() == PointType.WALL
							|| field[i][j].getpType() == PointType.ADVERSARY
							|| field[i][j].getpType() == PointType.UNKNOWN)) {

						result += "1";
					}

					else if (field[i][j].getpType() == PointType.DRIVING_POINT) {

						result += "8";
					}

					else {

						result += "0";
					}
				} else {

					if (field[i][j].isBlock() == true) {

						result += "1\r\n";
					}

					else {

						result += "0\r\n";
					}
				}

			}

		}
		LOGGER.debug(result);

	}

	public void printGraphic() {

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {

				if (field[i][j].getpType() == PointType.WALL) {

					System.out.println(field[i][j].getpType());
				}

			}
		}
	}

}
