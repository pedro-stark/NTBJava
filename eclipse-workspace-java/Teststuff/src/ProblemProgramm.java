
public class ProblemProgramm {
	
	public ProblemProgramm() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) {
		double Zahl1 = 0;
		double Zahl2 = 0;
		
		
		try{
			Zahl1 = rechnen(1,3);
			Zahl2 = rechnen(0,1);
		}catch (myException e){
			System.out.println(e.getMessage());
		}finally {
			System.out.println(Zahl1);
			System.out.println(Zahl2);
		}
	}
	
	public static double rechnen(int a, int b) throws myException{
		if(a == 0 || b == 0) {
			throw new myException();
		}else {
			return  ((double)a/(double)b);
		}
	}
}
