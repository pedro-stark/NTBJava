package src.Collections.u2_1_Lambdas_Inden;

import java.io.*;

public class U_Kap27_A5 {
	public static void main(String[] args) {
		
		//Original
		FileFilter directoryFilter = new FileFilter() { 
			public boolean accept(File pathname) { 
				return pathname.isDirectory(); 
			} 
		};
		
		FileFilter pdfFileFilter = new FileFilter() { 
			public boolean accept(File pathname) { 
				return (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf")); 
			} 
		};
		
		//und mit Lambdas
		
	}
}
