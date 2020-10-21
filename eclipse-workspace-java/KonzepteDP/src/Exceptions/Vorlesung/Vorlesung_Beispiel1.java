package Exceptions.Vorlesung;

public class Vorlesung_Beispiel1 {
	//Exception <- E1 <- E2
	//	    <- E3

	public static void main(String[] args) throws E3 {

		anordnung1();
		
		//anordnung2();
		
		//anordnung3();
	}
	
	public static void anordnung1() {
		try {
			System.out.println("try");
			throw new E2("E2");
			//throw new E1("E1");
			//throw new Exception("Exception");
			
		} catch (E1 e) {
			System.out.println("catch(E1) " + e);
		} catch (Exception e) {
			System.out.println("catch(Exception) " + e);
		} finally {
			System.out.println("finally");
		}	
	}

	public static void anordnung2() {
		try {
			throw new E2("E2");
			//throw new E1("E1");
			//throw new Exception("Exception");

		} catch (Exception e) {
			System.out.println("catch(Exception) " + e);
//		} catch (E1 e) {
//			System.out.println("catch(E1) " + e);
//		} catch (E2 e) {
//			System.out.println("catch(E2) " + e);
		} finally {
			System.out.println("finally");
		}	
	}

	public static void anordnung3() {
		try {
			if (true) throw new E3("E3"); else throw new E1("E1");
			
		} catch (E3 | E1 e) {
			System.out.println("catch(E3 oder E1) " + e);
		} finally {
			System.out.println("finally");
		}	
	}
	
}
