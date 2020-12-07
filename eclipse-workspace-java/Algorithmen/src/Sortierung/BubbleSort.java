package Sortierung;

public class BubbleSort {

	public static void bubbleSort(int[] data) {
		int swaps = 0;
		do {
			swaps = 0;
			for (int i=0; i<data.length-1; i++) {
				if (data[i] > data[i+1]) {
					int temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
					swaps++;
				}
			}
		} while (swaps>0);
	}

	public static void main(String[] args) {
		int[] data = {3,1,4,5,1,9,2,6};
		bubbleSort(data);
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}
}
