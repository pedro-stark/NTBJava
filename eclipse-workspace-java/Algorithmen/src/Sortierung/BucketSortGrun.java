package Sortierung;

import java.util.Random;

public class BucketSortGrun {

	public static void bucketSort(int[] data) {
		//zählen
		int bucket[] = new int[100];
		for (int i = 0; i < data.length; i++) {
			bucket[data[i]]++;
		}
		int pos = 0;
		//data überschreiben mit sortierten Werten
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				bucket[data[i]]++;
			}
		}
		
		
	}

	static void fillRandom(int[] data) {
		Random generator = new Random(System.currentTimeMillis()%1000000);
		for (int i=0; i<data.length; i++) {
			data[i] = generator.nextInt(100);
		}
	}
	
	public static void main(String[] args) {
		int[] data = new int[1000000];
		fillRandom(data);
		int[] dataCopy = data.clone();
		long beforeQS = System.nanoTime();
		QuickSort.quickSort(data, 0, data.length-1);
		long afterQS = System.nanoTime();
		long beforeBS = System.nanoTime();
		bucketSort(dataCopy);
		long afterBS = System.nanoTime();
		System.out.println(data.length+"; "+(afterQS-beforeQS)+"; "+(afterBS-beforeBS));

		for (int size=1000000; size<10000000; size+=1000000) {
			data = new int[size];
			fillRandom(data);
			/*
			bucketSort(data);
			for (int i=0; i<data.length; i++) {
				System.out.print(data[i]+" ");
			}*/
			dataCopy = data.clone();
			
			beforeQS = System.nanoTime();
			QuickSort.quickSort(data, 0, data.length-1);
			afterQS = System.nanoTime();
			
			beforeBS = System.nanoTime();
			bucketSort(dataCopy);
			afterBS = System.nanoTime();
			
			System.out.println(data.length+"; "+(afterQS-beforeQS)+"; "+(afterBS-beforeBS));
		}
	}
}
