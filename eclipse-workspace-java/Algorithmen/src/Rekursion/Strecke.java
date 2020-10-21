package Rekursion;

import java.math.*;

public class Strecke {
	boolean[][] pixelMap = new boolean[100][100];

	public void streckeBerechnen(int Ax, int Ay, int Bx, int By) { // Pixelmap hier nur 50x50
		int Mx; // irgendwas dazwischen
		int My;

		if (Ax > 99 || Ay > 99 || Bx > 99 || By > 99) {
			System.out.println("Coordinates out of bounds");
			return;
		}

		//Wenn benachbart, dann markieren SONST halbieren und neu versuchen.
		if (Math.abs(Ax - Bx) <= 1 && Math.abs(Ay - By) <= 1) { 
			pixelMap[Ax][Ay] = true;
			pixelMap[Bx][By] = true;
		} else {
			Mx = (Ax + Bx)/2 + (Ax + Bx) % 2;
			My = (Ay + By)/2 + (Ay + By) % 2;
			streckeBerechnen(Ax, Ay, Mx, My);
			streckeBerechnen(Mx, My, Bx, By);
		}

	}

	public void streckeAusgeben() {
		
		
		for (int i = 0; i < pixelMap.length; i++) {
			//Zeilennummerierung
			if (i<10) {
				System.out.print(i + " ");
			}else {
			System.out.print(i);
			}
			for (int j = 0; j < pixelMap[0].length; j++) {
				if (pixelMap[i][j]) {
					System.out.print("X");
				} else {
					System.out.print("o");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Strecke strecke = new Strecke();
		strecke.streckeBerechnen(10, 10, 50, 50);
		strecke.streckeAusgeben();
	}

}
