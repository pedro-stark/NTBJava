package String;

import java.io.*;

/*
 * Verwenden Sie diese Vorlage. Die meisten Methoden sind schon vordefiniert, sodass
 * Sie sich auf das Wesentliche konzentrieren können (siehe auch TODO)
 */

public class ZeichenManipulation {

	public static void main(String[] args) {
		// Entfernen Sie für die zu prüfende Methode die Kommentarzeichen!

		// Aufgabe Buchstabenfunktionen
		System.out.println(">>> Character Code Table");
		printCodeTable();
		System.out.println("<<< Character Code Table");
		System.out.println();

		// Aufgabe Dateitransformation
		System.out.println(">>> Copy Textfile");
		copy();
		System.out.println("\n<<< Copy Textfile");
		System.out.println();

		System.out.println(">>> Transform to upper case");
		toUpper();
		System.out.println("\n<<< Transform to upper case");
		System.out.println();

		System.out.println(">>> Remove line breaks");
		to1Line();
		System.out.println("\n<<< Remove line breaks");
		System.out.println();
	}

	//
	// Aufgabe: Buchstabenfunktionen:
	//
	public static void printCodeTable() {
		for (char c = ' '; c < 128; c++) {
			System.out.print("Character: " + c);
			System.out.print(" Code: " + (int) c);
			System.out.print(" isUpper? " + isUpperCaseLetter(c));
			System.out.print(" isLower? " + isLowerCaseLetter(c));
			System.out.print(" isLetter? " + isLetter(c));
			System.out.print(" isDigit? " + isDigit(c));
			System.out.print(" toUpper: " + toUpperCase(c));
			System.out.print(" toLower: " + toLowerCase(c));
			System.out.println();
		}
	}

	public static boolean isUpperCaseLetter(char c) {
		return c >= 65 && c <= 90;
	}

	public static boolean isLowerCaseLetter(char c) {
		return c >= 97 && c <= 122;
	}

	public static boolean isLetter(char c) {
		return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
	}

	public static boolean isDigit(char c) {
		return c >= 48 && c <= 57;
	}

	public static char toUpperCase(char c) {
		if (c >= 97 && c <= 122) {
			return (char) (c - 32);
		} else {
			return c;
		}

	}

	public static char toLowerCase(char c) {
		if (c >= 65 && c <= 90) {
			return (char) (c + 32);
		} else {
			return c;
		}
	}

	//
	// Aufgabe: Dateitransformationen
	//
	// - Methode copy dient als Vorlage für die anderen beiden Aufgaben
	// - Hinweis: in Eclipse wird das EOF bei System.in nicht erkannt.
	// Deswegen wird die Datei direkt mit einem File geöffnet.
	// Sonst waere: InputStream is = System.in;
	//
	public static void copy() {
		// Diese Form des try-catch Statements wird in der Vorlesung über Exceptions
		// erklärt
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
			int cAsInt;
			cAsInt = in.read();
			while (cAsInt != -1) {
				char c = (char) cAsInt;
				System.out.print(c);
				cAsInt = in.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void toUpper() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
			int cAsInt;
			cAsInt = in.read();
			while (cAsInt != -1) {
				char c = (char) cAsInt;
				System.out.print(toUpperCase(c));
				cAsInt = in.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void to1Line() { // skip Carriage Return \r and Line Feed \n
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
			int cAsInt;
			cAsInt = in.read();
			while (cAsInt != -1) {
				char c = (char) cAsInt;
				if (c == '\r'|| c == '\n') { // oder so: c == 10 || c == 13
					c = 32; //oder ganz weglassen...
				}
				System.out.print(c);
				cAsInt = in.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
