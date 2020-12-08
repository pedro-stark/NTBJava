package src.Funktionsplotter;
/*
 * Carlo Bach, 16.10.2007
 * Version 1.0
 *  
 */

public class Turtle {

  public static final int WIDTH = 750;
	public static final int HEIGHT = 500;

	private static double xPosition;
	private static double yPosition;
	private static double angle;
	private static boolean penUp;
	private static int color;
	
	//Schriftgr�sse (Standard = 10 Pixel)
	private static double sizeFactor = 1.0;
	
	{
		home();
	}
	
	public static double getX() {
		return xPosition;
	}
	public static double getY() {
		return yPosition;
	}
	public static double getAngle() {
		return angle;
	}
	public static boolean isPenUp() {
		return penUp;
	}
	public static boolean isPenDown() {
		return !penUp;
	}
	public static int getColor() {
		return color;
	}
	
	public static double getFontSize() {
    return sizeFactor;
  }
  
	public static void setFontSize(double g) {
    sizeFactor = g;
  }
  
  public static double getSize() {
    return 10.0 * sizeFactor;
  }
  
  public static double getWidth() {
    return 6.0 * sizeFactor;
  }
  
	
	/**
	 * 
	 */
	public static void home() {
		xPosition = 0;
		yPosition = 0;
		angle = 0;
		penUp = true;
		color = 0; //black

		TurtleGraphics.getInstance().getXYColorPlane().clear();
		TurtleGraphics.getInstance().update();
	}
	
	public static void move(double steps) {
		//Pythagoras
		moveTo(
			xPosition + steps * Math.cos(Math.PI / 180 * angle), 
			yPosition + steps * Math.sin(Math.PI / 180 * angle)
		);
	}

	public static void moveTo(double newX, double newY) {
		if (!penUp) {
			TurtleGraphics.getInstance().getXYColorPlane().drawLine(
					(int)xPosition, (int)yPosition, (int)newX, (int)newY, color
			);
		}

		xPosition = newX;
		yPosition = newY;
		
		TurtleGraphics.getInstance().update();
	}

	public static void turn(double degrees) {
		turnTo(angle + degrees);
	}
	
	public static void turnTo(double degrees) {
		angle = degrees % 360;	
		TurtleGraphics.getInstance().update();
	}

	public static void penUp() {
		penUp = true;
		TurtleGraphics.getInstance().update();
	}
	public static void penDown() {
		penUp = false;
		TurtleGraphics.getInstance().update();
	}
	public static void penToggle() {
		penUp = !penUp;
		TurtleGraphics.getInstance().update();
	}
	
	public static void setColor(int newColor) {
		color = newColor;
		TurtleGraphics.getInstance().update();
	}
	
	public static String asString() {
		return "x: " + getX() + " y: " + getY() + " a: " + getAngle() + " pen up: " + isPenUp() + " color: " + getColor(); 
	}
	
  //Schreibt eine Zahl (case enspricht der auszugebenden Zahl)
  public static void write(int i) {
    double size = getSize();
    double width = getWidth();
    double startAngle = getAngle();
    int[] number = new int[10];
    int length = 0;
    
    do {
      number[length] = i % 10;
      i = i / 10;
      length++;
    } while(i != 0);
    
    for(int h = length - 1; h >= 0; h--) {
      double startX = getX();
      double startY = getY();
      
      switch(number[h]) {
        case 0:
          penDown();
          move(width);
          turn(90);
          move(size);
          turn(90);
          move(width);
          turn(90);
          move(size);
          break;
          
        case 1:
          move(14.0 / 18.0 * width);
          penDown();
          turn(90);
          move(size);
          turn(135);
          move(Math.sqrt(2) / 3.0 * size);
          break;
          
        case 2:
          turn(90);
          move(size);
          penDown();
          turn(-90);
          move(width);
          turn(-90);
          move(size / 2.0);
          turn(-90);
          move(width);
          turn(90);
          move(size / 2.0);
          turn(90);
          move(width);
          break;
          
        case 3:
          penDown();
          move(width);
          turn(90);
          move(size / 2.0);
          turn(90);
          move(2.0 / 3.0 * width);
          penUp();
          turn(180);
          move(2.0 / 3.0 * width);
          penDown();
          turn(90);
          move(size / 2.0);
          turn(90);
          move(width);
          break;
          
        case 4:
          move(5.0 / 6.0 * width);
          penDown();
          turn(90);
          move(size);
          penUp();
          turn(90);
          move(size / 2.0);
          penDown();
          turn(90);
          move(size / 2.0);
          turn(90);
          move(width);
          break;
          
        case 5:
          penDown();
          move(width);
          turn(90);
          move(size / 2.0);
          turn(90);
          move(width);
          turn(-90);
          move(size / 2.0);
          turn(-90);
          move(width);
          break;
          
        case 6:
          turn(90);
          move(size / 2.0);
          penDown();
          turn(-90);
          move(width);
          turn(-90);
          move(size / 2.0);
          turn(-90);
          move(width);
          turn(-90);
          move(size);
          turn(-90);
          move(width);
          break;
          
        case 7:
          turn(90);
          move(size);
          penDown();
          turn(-90);
          move(width);
          turn(-116.656);
          move(5 * Math.sqrt(5) / 6 * width);
          break;
          
        case 8:
          move(width);
          turn(90);
          move(size / 2.0);
          penDown();
          turn(90);
          move(width);
          turn(90);
          move(size / 2.0);
          turn(90);
          move(width);
          turn(90);
          move(size);
          turn(90);
          move(width);
          turn(90);
          move(size / 2.0);
          break;
          
        case 9:
          move(width);
          turn(90);
          move(size / 2.0);
          penDown();
          turn(90);
          move(width);
          turn(-90);
          move(size / 2.0);
          turn(-90);
          move(width);
          turn(-90);
          move(size);
          turn(-90);
          move(width);
          break;
        default:
          return;    
      }
      penUp();
      moveTo(startX, startY);
      turnTo(startAngle);
      move(size);
    }
  }
  
	public static void main(String[] args) {
		//Demo
		Turtle.home();
		Turtle.setColor(0xFF0000);
		Turtle.moveTo(10, 250);
		Turtle.penDown();

		skyline(6, 729.0);
		Turtle.turn(180.0);
		Turtle.setColor(0x0000FF);
		skyline(6, 729.0);
		
		Turtle.penUp();
		Turtle.moveTo(300, 200);
		Turtle.turnTo(45);
		Turtle.setColor(0x00FF00);
		Turtle.setFontSize(2);
		Turtle.write(1234567890);
		
		Turtle.penUp();
		Turtle.moveTo(0, 0);
		Turtle.turnTo(0);
	}
	
	public static void skyline(int level, double width) {
		if (level == 1) {
			Turtle.move((int)width);
		} else {
	        skyline(level-1, width/3.0);
	        Turtle.turn(90); Turtle.move(width/6.0); Turtle.turn(-90);
	        skyline(level-1, width/3.0);
	        Turtle.turn(-90); Turtle.move(width/6.0); Turtle.turn(90);
	        skyline(level-1, width/3.0);
		}
	}
		
}
