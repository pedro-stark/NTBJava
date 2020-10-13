package String;

import java.io.*;

public class Statitstik {

	public static void main(String[] args) {
		statistik("gutenberg_faust.txt");

	}

	public static void statistik(String filename) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			
			long t = System.currentTimeMillis(); //Zeitmessung
			int[] nrCharSpecific = new int[66000];
			
			int cAsInt = in.read();
			int noChars = 1;
			while (cAsInt != -1) {
				nrCharSpecific[cAsInt] += 1;
				
				cAsInt = in.read();
				noChars++;
			}
			

			
			for (int i = 0; i < nrCharSpecific.length; i++) {
				if (nrCharSpecific[i]!=0) {
					System.out.println("Character " + (char)i + " kommt so viel mal vor: " + nrCharSpecific[i]);
					System.out.println("Character " + (char)i + " relativer Anteil: " + ((double)nrCharSpecific[i]/(double)noChars));
				}
			}
			t = System.currentTimeMillis() - t;		
			System.out.printf("Laufzeit für Analyse: \t\t#Chars: %,d \tRuntime %,d ms\n", noChars, t);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
