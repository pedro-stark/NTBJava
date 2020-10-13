package String;

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
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int stringlength = s.length() -1;
		
		while (stringlength != -1) {
			char c = s.charAt(stringlength);
			if((c >= 97 && c <= 122)) {
				sb1.append(s.charAt(stringlength));
				sb2.insert(0, s.charAt(stringlength));
			}else if(c >= 65 && c <= 90){
				sb1.append((char)(s.charAt(stringlength)+32));
				sb2.insert(0, (char)(s.charAt(stringlength)+32));
			}
			stringlength--;
		}
			
		if(sb1.toString().equals(sb2.toString())) {
			return true;
		}else {
			return false;
		}
	}

}
