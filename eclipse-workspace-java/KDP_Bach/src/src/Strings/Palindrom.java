package src.Strings;
import java.io.*;

public class Palindrom {

	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("palindrome.txt")))) {
			
			String s = in.readLine();
			while (s != null) {
				System.out.format("%-5b: %s\n", isPalindrom(s), s);
				s = in.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}
	
	public static boolean isPalindrom(String s) {
		//TODO
		return false;
	}

}
