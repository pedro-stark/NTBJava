package ch.ntb.orionRobo.drive;

import java.awt.Dimension;
import java.util.*;

import javax.swing.JFrame;

import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.environmentRecognition.Point.PointType;
import ch.ntb.orionRobo.environmentRecognition.Field;

/**
 * A Star Algorithm
 */
public class AStar {
	private static int DEFAULT_HV_COST = 10; // Horizontal - Vertical Cost
	private static int DEFAULT_DIAGONAL_COST = 14;
	private int hvCost;
	private int diagonalCost;
	private Point[][] searchArea;
	private PriorityQueue<Point> openList;
	private Set<Point> closedSet;
	private Point initialPoint;
	private Point finalPoint;

	public AStar(Point initialPoint, Point finalPoint, int hvCost, int diagonalCost, Point[][] currentField) {
		this.hvCost = hvCost;
		this.diagonalCost = diagonalCost;
		setinitialPoint(initialPoint);
		setFinalPoint(finalPoint);
		this.searchArea = currentField;
		this.openList = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point Point0, Point Point1) {
				return Integer.compare(Point0.getF(), Point1.getF());
			}
		});
		this.closedSet = new HashSet<>();

	}

	public AStar(Point initialPoint, Point finalPoint, Point[][] currentField) {
		this(initialPoint, finalPoint, DEFAULT_HV_COST, DEFAULT_DIAGONAL_COST, currentField);
	}

	public List<Point> findPath() {
		openList.add(initialPoint);
		while (!isEmpty(openList)) {
			Point currentPoint = openList.poll();
			closedSet.add(currentPoint);
			if (isFinalPoint(currentPoint)) {
				return getPath(currentPoint);
			} else {
				addAdjacentPoints(currentPoint);
			}
		}
		return new ArrayList<Point>();
	}

	private List<Point> getPath(Point currentPoint) {
		List<Point> path = new ArrayList<Point>();
		path.add(currentPoint);
		Point parent;
		while ((parent = currentPoint.getParent()) != null) {
			path.add(0, parent);
			currentPoint = parent;
		}
		return path;
	}

	private void addAdjacentPoints(Point currentPoint) {
		addAdjacentUpperRow(currentPoint);
		addAdjacentMiddleRow(currentPoint);
		addAdjacentLowerRow(currentPoint);
	}

	private void addAdjacentLowerRow(Point currentPoint) {
		int row = currentPoint.getRow();
		int col = currentPoint.getCol();
		int lowerRow = row + 1;
		if (lowerRow < getSearchArea().length) {
			if (col - 1 >= 0) {
				checkPoint(currentPoint, col - 1, lowerRow, getDiagonalCost()); // Comment this line if diagonal
																				// movements are not allowed
			}
			if (col + 1 < getSearchArea()[0].length) {
				checkPoint(currentPoint, col + 1, lowerRow, getDiagonalCost()); // Comment this line if diagonal
																				// movements are not allowed
			}
			checkPoint(currentPoint, col, lowerRow, getHvCost());
		}
	}

	private void addAdjacentMiddleRow(Point currentPoint) {
		int row = currentPoint.getRow();
		int col = currentPoint.getCol();
		int middleRow = row;
		if (col - 1 >= 0) {
			checkPoint(currentPoint, col - 1, middleRow, getHvCost());
		}
		if (col + 1 < getSearchArea()[0].length) {
			checkPoint(currentPoint, col + 1, middleRow, getHvCost());
		}
	}

	private void addAdjacentUpperRow(Point currentPoint) {
		int row = currentPoint.getRow();
		int col = currentPoint.getCol();
		int upperRow = row - 1;
		if (upperRow >= 0) {
			if (col - 1 >= 0) {
				checkPoint(currentPoint, col - 1, upperRow, getDiagonalCost()); // Comment this if diagonal movements
																				// are not allowed
			}
			if (col + 1 < getSearchArea()[0].length) {
				checkPoint(currentPoint, col + 1, upperRow, getDiagonalCost()); // Comment this if diagonal movements
																				// are not allowed
			}
			checkPoint(currentPoint, col, upperRow, getHvCost());
		}
	}

	private void checkPoint(Point currentPoint, int col, int row, int cost) {
		Point adjacentPoint = getSearchArea()[row][col];
		if (!adjacentPoint.isBlock() && !getClosedSet().contains(adjacentPoint)) {
			if (!getOpenList().contains(adjacentPoint)) {
				adjacentPoint.setPointData(currentPoint, cost);
				getOpenList().add(adjacentPoint);
			} else {
				boolean changed = adjacentPoint.checkBetterPath(currentPoint, cost);
				if (changed) {
					// Remove and Add the changed Point, so that the PriorityQueue can sort again
					// its
					// contents with the modified "finalCost" value of the modified Point
					getOpenList().remove(adjacentPoint);
					getOpenList().add(adjacentPoint);
				}
			}
		}
	}

	private boolean isFinalPoint(Point currentPoint) {
		return currentPoint.equals(finalPoint);
	}

	private boolean isEmpty(PriorityQueue<Point> openList) {
		return openList.size() == 0;
	}

	private void setBlock(int row, int col) {
		this.searchArea[row][col].setBlock(true);
	}

	public Point getinitialPoint() {
		return initialPoint;
	}

	public void setinitialPoint(Point initialPoint) {
		this.initialPoint = initialPoint;
	}

	public Point getFinalPoint() {
		return finalPoint;
	}

	public void setFinalPoint(Point finalPoint) {
		this.finalPoint = finalPoint;
	}

	public Point[][] getSearchArea() {
		return searchArea;
	}

	public void setSearchArea(Point[][] searchArea) {
		this.searchArea = searchArea;
	}

	public PriorityQueue<Point> getOpenList() {
		return openList;
	}

	public void setOpenList(PriorityQueue<Point> openList) {
		this.openList = openList;
	}

	public Set<Point> getClosedSet() {
		return closedSet;
	}

	public void setClosedSet(Set<Point> closedSet) {
		this.closedSet = closedSet;
	}

	public int getHvCost() {
		return hvCost;
	}

	public void setHvCost(int hvCost) {
		this.hvCost = hvCost;
	}

	private int getDiagonalCost() {
		return diagonalCost;
	}

	private void setDiagonalCost(int diagonalCost) {
		this.diagonalCost = diagonalCost;
	}

}
