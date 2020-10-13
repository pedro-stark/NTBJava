package String;

import java.io.*;

public class TabReplacer {
	public static void main(String[] args) {
		replace("inputwithtabs.txt", 20);
		//replace("2	Orange	1.00	2.00", 12);//args[0], Integer.parseInt(args[1]));
		//replace("345	Reiskorn	0.01	3.45", 12);
		//replace("1	Porsche	1000000	1000000", 12);
	}
	
	public static void replace(String filename, int tabposition) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			int cAsInt;
			int position; // position of current character in line
			
			cAsInt = in.read();
			position = 0;

			while (cAsInt != -1) {
				char c = (char)cAsInt;
				
				if (c == '\n' || c == '\r') {
					System.out.print(c);
					position = 0;
					
				} else if (c == '\t' ) {
					fillup(' ', tabposition-position);
					position = 0;
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
