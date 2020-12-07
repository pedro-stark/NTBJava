package Sortierung;
import java.util.Random;

public class QuickSort {

	// Pivot entspricht vorderstem Element: die Elemente werden mit ihm verglichen und vertauscht
	public static void quickSortHungarianFolkDance(int[] data, int left, int right) {
		int i=left, j=right;
		int pivot=data[left];
		while(i<j) {
			while (i<right && data[i]<=pivot) i++;
			while (j>left && pivot<=data[j]) j--;
			if (i<=j) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		if (left < j) quickSort(data, left, j);
		if (i<right) quickSort(data,i,right);
	}
	
	// Im Unterricht vorgestellt: Pivot in der Mitte; landet entweder links oder rechts
	public static void quickSort(int[] data, int left, int right) {
		int i=left, j=right;
		int mid=(left+right)/2;
		int pivot=data[mid];
		while(i<=j) {
			while (i<right && data[i]<pivot) i++;
			while (j>left && pivot<data[j]) j--;
			if (i<=j) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				i++; j--;
			}
		}
		if (left < j) quickSort(data, left, j);
		if (i<right) quickSort(data,i,right);
		
	}
	static void fillRandom(int[] data) {
		Random generator = new Random(System.currentTimeMillis()%1000000);
		for (int i=0; i<data.length; i++) {
			data[i] = generator.nextInt(data.length);
		}
	}
	public static void main(String[] args) {
		int[] data = {3,1,4,5,1,9,2,6};
		quickSortHungarianFolkDance(data,0,data.length-1);
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		data = new int[100];
		fillRandom(data);
		quickSortHungarianFolkDance(data,0,data.length-1);
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}

	}

}
