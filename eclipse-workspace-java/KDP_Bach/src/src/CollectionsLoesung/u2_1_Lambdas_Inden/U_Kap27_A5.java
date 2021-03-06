package src.CollectionsLoesung.u2_1_Lambdas_Inden;

import java.io.*;

public class U_Kap27_A5 {
	public static void main(String[] args) {
		
		//Original mit anonymer Klase
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
		
		//a) klassisch
		FileFilter directoryFilter2 = pathname -> pathname.isDirectory();
		
		//a) mit Methodenreferenz
		FileFilter directoryFilter3 = File::isDirectory;
		
		//und b)
		FileFilter pdfFileFilter2 = pathname -> (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf")); 
		
	}
}
