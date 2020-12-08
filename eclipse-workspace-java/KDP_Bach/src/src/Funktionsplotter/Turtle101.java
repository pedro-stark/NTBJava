package src.Funktionsplotter;
//
// Turtle101 zeigt, wie die man mit der TurtleGraphics-Bibliothekt umgehen muss. // 
// C. Bach, 23.10.09
//

public class Turtle101 {

  public static void demo1() {
    //Zeichenblatt oeffnet sich. Die Schildkroete steht im Ursprung (0, 0),
    //schaut nach rechts und hat den schwarzen Zeichenstift angehoben.
    //
    //Beachten Sie Angaben oben im Zeichenfenster! 
    
    Turtle.home();
  }

  public static void demo2() {
    //Maximale Bereiche

    Turtle.penUp(); Turtle.moveTo(0.0, 0.0); Turtle.turnTo(0.0); Turtle.penDown();
    Turtle.setColor(0x0); //black
    
    Turtle.move(100.0); // 0/0 -> 100/0
    
    Turtle.moveTo(100.0, TurtleXYColorPlane.HEIGHT-1); // 100/0 -> 100/499
    
    Turtle.move(100.0); // 100/499 -> 200/499
    
    Turtle.moveTo(TurtleXYColorPlane.WIDTH-1, 200); // 200/499 -> 699/200
    
    Turtle.turn(-90); Turtle.move(100.0); // 699/200 -> 699/100
  }

  public static void demo3() {
    //Beziehung zwischen Pixelkoordinaten und Bewegungspunkten
    
    Turtle.penUp(); Turtle.moveTo(20.0, 400.0); Turtle.turnTo(0);
    Turtle.penDown(); Turtle.setColor(0xFF0000); //RED
    
    //zeichnet eine Linie von Punkt 20/20 bis und mit 40/20, insgesamt 21 Pixel (nicht 40-20=20)!
    Turtle.move(20);
    
    Turtle.penUp(); Turtle.moveTo(25.0, 398.0); Turtle.turnTo(90); Turtle.penDown(); Turtle.setColor(0xFF); 
    Turtle.move(2); // Linie von 25/398 bis und mit 25/400, 3 Pixel

    Turtle.penUp(); Turtle.moveTo(30.0, 399.0); Turtle.turnTo(90); Turtle.penDown(); Turtle.setColor(0xFF); 
    Turtle.move(1); // Linie von 25/399 bis und mit 25/400, 2 Pixel

    Turtle.penUp(); Turtle.moveTo(35.0, 400.0); Turtle.turnTo(90); Turtle.penDown(); Turtle.setColor(0xFF); 
    Turtle.move(0); // Linie von 25/400 bis und mit 25/400, 1 Pixel

  }

  public static void main(String[] args) {
    demo1();
    demo2();
    demo3();
  }
  
}
