package src.Strings;
import java.io.*;

public class StringConcatenation {
	
	public static void main(String[] args) {
		concatWithStrings(args[0]); //bereits erledigt
		concatWithStringBuilder(args[0]); //für Sie zu tun!
	}
	
	public static void concatWithStrings(String filename) {	
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			
			long t = System.currentTimeMillis(); //Zeitmessung
			
			String s = "";
			
			int cAsInt = in.read();
			int noChars = 1;
			while (cAsInt != -1) {
				s = s + (char)cAsInt;
			
				cAsInt = in.read();
				noChars++;
			}
			
			t = System.currentTimeMillis() - t;		
			System.out.printf("concatWithStrings: \t\t#Chars: %,d \tRuntime %,d ms\n", noChars, t);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void concatWithStringBuilder(String filename) {
		//TODO (wie oben nur mit StringBuilder statt String 
	}
}

