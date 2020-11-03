package Rekursion;

public class PascalDreieck {
//Rekursionsbasis: ganz links und ganz rechts muss eine 1 stehen

	  public static void main(String[] args) {
		    int rows = 5;
		    print(rows);
		    System.out.println(pascal(0,0));
		  }

		  public static void print(int n) {
		    for (int i = 0; i < n; i++) {
		      for (int j = 0; j <= i; j++) {
		        System.out.print(pascal(i, j) + " ");
		      }
		      System.out.println();
		    }
		  }

		  public static int pascal(int i, int j) {
		    if (j == 0 || j == i) {
		      return 1;
		    } else {
		      return pascal(i - 1, j - 1) + pascal(i - 1, j);
		    }
		  }
		}