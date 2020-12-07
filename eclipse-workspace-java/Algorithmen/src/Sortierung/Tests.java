package Sortierung;
import java.util.Random;
public class Tests {

	static void fillRandom(int[] data) {
		Random generator = new Random(System.currentTimeMillis()%1000000);
		for (int i=0; i<data.length; i++) {
			data[i] = generator.nextInt(data.length);
		}
	}
	
	public static void main(String[] args) {
		int[] dataPre = new int[10000];
		fillRandom(dataPre);
		int[] dataPreCopy = dataPre.clone();
		
		long beforeQS = System.nanoTime();
		QuickSort.quickSort(dataPre, 0, dataPre.length-1);
		long afterQS = System.nanoTime();
		
		long beforeBS = System.nanoTime();
		BubbleSort.bubbleSort(dataPreCopy);
		long afterBS = System.nanoTime();
		System.out.println(dataPreCopy.length+"; "+(afterQS-beforeQS)+"; "+(afterBS-beforeBS));
		
		for (int size=10000; size<100000; size=size+10000) {
			int[] data = new int[size];
			fillRandom(data);
			int[] dataCopy = data.clone();
			
			beforeQS = System.nanoTime();
			QuickSort.quickSort(data, 0, data.length-1);
			afterQS = System.nanoTime();
			
			beforeBS = System.nanoTime();
			BubbleSort.bubbleSort(dataCopy);
			afterBS = System.nanoTime();
			
			System.out.println(data.length+"; "+(afterQS-beforeQS)+"; "+(afterBS-beforeBS));
		}

	}
}





