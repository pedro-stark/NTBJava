package Factory.SimpleFactory.Shape;
public class FactoryMethodTest {

   public static void main(String[] args) {
	   //Erstelle Formenfabrik
      ShapeFactory shapeFactory = new ShapeFactory();

      //Erzeuge Kreis
      Shape shape1 = shapeFactory.getShape("Circle");

      //zeichne Kreis
      shape1.draw();

      //Erzeuge Rechteck
      Shape shape2 = shapeFactory.getShape("Rectangle");

      //zeichne Rechteck
      shape2.draw();

      //Erzeuge Quadrat
      Shape shape3 = shapeFactory.getShape("Square");

      //zeichne Quadrat
      shape3.draw();
      
   }
}