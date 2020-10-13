package String;

import java.io.*;

public class StringConcatenation {
	
	public static void main(String[] args) {
		concatWithStrings("gutenberg_faust.txt");//args[0]);
		concatWithStringBuilder("gutenberg_faust.txt");
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
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			
			long t = System.currentTimeMillis(); //Zeitmessung
			StringBuilder sb = new StringBuilder();
			//String s = "";
			
			int cAsInt = in.read();
			int noChars = 1;
			while (cAsInt != -1) {
				sb = sb.append((char)cAsInt);
			
				cAsInt = in.read();
				noChars++;
			}
			
			t = System.currentTimeMillis() - t;		
			System.out.printf("concatWithStringBuilder: \t\t#Chars: %,d \tRuntime %,d ms\n", noChars, t);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

