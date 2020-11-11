package Prototype.Shape;

	import java.util.ArrayList;
	import java.util.List;

	public class Test {
	    public static void main(String[] args) {
	       //To Do
	    	 List<Shape> shapes = new ArrayList<>();
	    	
	       
	    	//To Do  shapesCopy = new Array of Shapes.
	    	//List<Shape> shapesCopy 

	        Circle circle = new Circle();
	        circle.x = 10;
	        circle.y = 20;
	        circle.radius = 15;
	        circle.color = "red";
	        shapes.add(circle);

	        Circle anotherCircle = (Circle) circle.clone();
	        shapes.add(anotherCircle);

	        Rectangle rectangle = new Rectangle();
	        rectangle.width = 10;
	        rectangle.height = 20;
	        rectangle.color = "blue";
	        shapes.add(rectangle);

	       //To Do 
	       // cloneAndCompare(shapes, shapesCopy);
	    }

	    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
	       //To Do
	    	// z.b foreach (s in shapes) do
	         //    shapesCopy.add(s.clone())

	         // The shapesCopy array contains exact copies of the shape array's children.
	    	
	    }
	}