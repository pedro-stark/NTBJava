package Factory.FactoryMethod.FormenFabrik;
public class FormenFabrikTest {

   public static void main(String[] args) {
	   //Erstelle 2D Formenfabrik
      FormenFabrik Dim2Fabrik = new Dim2Fabrik();

      //Erzeuge Form (2D) mit 3 Ecken
      Form form1 = Dim2Fabrik.getForm(3);
      
      //zeichne Form (2D) mit 3 Ecken
      form1.zeichnen(); 
      
      //Erzeuge Form (2D) mit 4 Ecken 
      Form form2 = Dim2Fabrik.getForm(4);
      
      //zeichne Form (2D) mit 4 Ecken
      form2.zeichnen();

      //Erzeuge Form (2D) mit 0 Ecken
      Form form3 = Dim2Fabrik.getForm(0);

      //zeichne Form (2D) mit 0 Ecken
      form3.zeichnen();

	   //Erstelle 3D Formenfabrik
      FormenFabrik Dim3Fabrik = new Dim3Fabrik();
      
      //Erzeuge Form (3D) mit 5 Ecken
      Form form4 = Dim3Fabrik.getForm(5);

      //zeichne Form (3D) mit 5 Ecken
      form4.zeichnen();
      
      //Erzeuge Form (3D) mit 8 Ecken
      Form form5 = Dim3Fabrik.getForm(8);
      
      //zeichne Form (3D) mit 8 Ecken
      form5.zeichnen();
      
      //Erzeuge Form (3D) mit 0 Ecken
      Form form6 = Dim3Fabrik.getForm(0);
      
      //zeichne Form (3D) mit 0 Ecken
      form6.zeichnen();
   }
}