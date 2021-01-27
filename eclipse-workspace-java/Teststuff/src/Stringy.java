import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.*;

public class Stringy {

	public Stringy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		StringBuilder b = new StringBuilder();
		b.append("sadfsadf");
		b.append("+1");

		System.out.println(b.toString());
		System.out.println("--------------------------------");
		System.out.println("Test-Read file");
		System.out.println("--------------------------------");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
			int charAsInt = br.read();
			while (charAsInt != -1) {
				System.out.println((char)charAsInt + ": " + charAsInt);
				charAsInt= br.read();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
