package src.StringsLoesung;
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
		int l = 0;
		int r = s.length() - 1;
		
		for (;l < r; l++, r--) {
			while (!Character.isLetter(s.charAt(l))) l++;
			while (!Character.isLetter(s.charAt(r))) r--;
			
			if (Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r))) {
				return false;
			}
		}
		
		return true;
	}

}
