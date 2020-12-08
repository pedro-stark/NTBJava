package src.Zeichen;
import java.io.*;

public class TabReplacer {
	public static void main(String[] args) {
		replace(args[0], Integer.parseInt(args[1]));
	}
	
	public static void replace(String filename, int tabposition) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			int cAsInt;
			int position; // position of current character in line
			
			cAsInt = in.read();
			position = 0;

			while (cAsInt != -1) {
				char c = (char)cAsInt;
				
				if (c == '\n') {
					System.out.print(c);
					position = 0;
					
				} else if (c == '\t' ) {
					//replace '\t' with ' '; assume tab positions at multiples of tabposition
					//calculate how many spaces have to be inserted and call 'fillup' (see below) 
					//TODO
					
				} else {
					System.out.print(c);					
					position++;
				}
								
				cAsInt = in.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	private static void fillup(char c, int i) {
		//print i times character c
		while (i > 0) {
			System.out.print(c);					
			i--;
		}
	}
}
