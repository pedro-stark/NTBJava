/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.environmentRecognition.Point.java
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
package ch.ntb.orionRobo.environmentRecognition;

import java.io.Serializable;
import java.util.Date;

import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.environmentRecognition.*;

/**
 * 
 */
public class Point implements Serializable {

	private double xCoordinate;
	private double yCoordinate;
	private int distance;
	private Date date = null;
	private PointType pType;
	private double degree;
	// --------------------------------------------------------------
	// Kopie von class Node
	// --------------------------------------------------------------
	private int g;
	private int f;
	private int h;
	private int row;
	private int col;
	private boolean isBlock;
	private Point parent;

	public enum PointType {
		WALL, DRIVING_POINT, ROBO, PARTNER_ROBO, ADVERSARY, UNKNOWN, START_POINT, Final_Point
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public Date getDate() {
		return date;
	}

	public PointType getpType() {
		return pType;
	}

	public void setPointType(PointType pType) {
		this.pType = pType;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	/**
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param pType
	 */
	public Point(double xCoordinate, double yCoordinate, PointType pType, double degree) {

		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.pType = pType;
		this.degree = degree;
//		row = (int) xCoordinate/RoboControl.field.fieldResolution;
//		col = (int) yCoordinate/RoboControl.field.fieldResolution;
		
		row = (int) (xCoordinate/5);
		col = (int) (yCoordinate/5);
	}

	public Point(double xCoordinate, double yCoordinate, PointType pType) {

		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.pType = pType;

	
		
	}
	
	public Point(int row, int col, double degree) {
		super();
		this.degree = degree;
		this.row = row;
		this.col = col;
	}

	public Point(int distance, double degree) {

		this.distance = distance;
		this.degree = degree;
	}

	private void xCoordToRow(double x) { // x ist X-Koordinate vom Punkt ROBO
		this.row = (int)x/RoboControl.field.fieldResolution;
	}

	private void yCoordToRow(double y) {

		this.col = (int)y/RoboControl.field.fieldResolution;
	}

	// --------------------------------------------------------------
	// Kopie von class Node
	// --------------------------------------------------------------

	public Point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public void calculateHeuristic(Point finalPoint) {
		this.h = Math.abs(finalPoint.getRow() - getRow()) + Math.abs(finalPoint.getCol() - getCol());
	}

	public void setPointData(Point currentPoint, int cost) {
		int gCost = currentPoint.getG() + cost;
		setParent(currentPoint);
		setG(gCost);
		calculateFinalCost();
	}

	public boolean checkBetterPath(Point currentPoint, int cost) {
		int gCost = currentPoint.getG() + cost;
		if (gCost < getG()) {
			setPointData(currentPoint, cost);
			return true;
		}
		return false;
	}

	private void calculateFinalCost() {
		int finalCost = getG() + getH();
		setF(finalCost);
	}

	@Override
	public boolean equals(Object arg0) {
		Point other = (Point) arg0;
		return this.getRow() == other.getRow() && this.getCol() == other.getCol();
	}

	@Override
	public String toString() {
		return "Point [row=" + row + ", col=" + col + "]";
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public Point getParent() {
		return parent;
	}

	public void setParent(Point parent) {
		this.parent = parent;
	}

	public boolean isBlock() {
		return isBlock;
	}

	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getDistance() {

		return distance;
	}

	public void setXCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
		xCoordToRow(xCoordinate);
	}

	public void setYCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
		yCoordToRow(yCoordinate);
	}

}
