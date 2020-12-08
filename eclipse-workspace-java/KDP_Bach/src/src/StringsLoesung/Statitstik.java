package src.StringsLoesung;
import java.io.*;

public class Statitstik {

	public static void main(String[] args) {
		statistik("gutenberg_faust.txt");

	}

	public static void statistik(String filename) {
		int total = 0;
		int[] histogram = new int[256];
		for (int i=0; i < histogram.length; i++) {
			histogram[i] = 0;
		}		
		
		try (InputStream in = new FileInputStream(filename)) {
			
			int cAsInt = in.read();
			total++;
			while (cAsInt != -1) {
				histogram[cAsInt]++;
			
				cAsInt = in.read();
				total++;
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		for (int i=' '; i < histogram.length; i++) {
			if (histogram[i] > 0) {
				System.out.printf("Häufigkeit von %c: absolut %,7d; relativ %6.4f\n", i, histogram[i], histogram[i]/(double)total);				
			}
		}
		
	}

}
