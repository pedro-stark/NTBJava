package src.Exceptions.bsp2;

public class Vorlesung_Beispiel2 {
	//Exception <- E1
	//	    <- E2
	//	    <- E3

	public static void main(String[] args) throws E3 {
		int fall = Integer.parseInt(args[0]);
		
		try {
			System.out.println("In main:try vor f()");
			f(fall);
			System.out.println("In main:try nach f()");

		} catch (E1 e) {
			System.out.println("In main:catch(E1) " + e);
		}

		System.out.println("In main:end");
	}
	
	public static void f(int fall) throws E1, E3 {
		try {
			System.out.println("In f: vor g()");		
			g(fall);
			System.out.println("In f: nach g()");		
		} catch (E2 e) {
			System.out.println("In f:catch(E2) " + e);		
			
		} finally {
			System.out.println("In f:finally");		
		}
		System.out.println("In f:end");
	}

	public static void g(int fall) throws E1, E2, E3 {
		System.out.println("In g");		
		if (fall == 1) {
			throw new E1("Throw E1 (Fall 1)");
			
		} else if (fall == 2) {
			throw new E2("Throw E2 (Fall 2)");
			
		} else if (fall == 1) {
			throw new E1("Throw E3 (Fall 3)");
			
		}
		System.out.println("In g:end");		
	}
}
