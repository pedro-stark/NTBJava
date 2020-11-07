package Rekursion;

import java.util.Arrays;


public class KnapsackLoes {

	int[] items;
	int itemCount;
	int[] weight;
	int[] value;
	int limitWeight;
	int sumWeight;
	int sumValue;
	int maxValue;	
	int[] itemsMaxValue;
	int itemCountMaxValue;
	
	public KnapsackLoes(int limitWeight, int[] weight, int[] value) {
		this.limitWeight = limitWeight;
		this.items = new int[weight.length];
		this.itemCount = 0;
		this.sumWeight = 0;
		this.weight = weight;
		this.value = value;
	}
	
	public static void main(String[] args) {
		 //Dummyelem 0,0
		int[] weight = new int[] {0, 10, 5, 13, 7, 8, 2, 9, 12, 17 };
		int[] value = new int[]  {0, 1,  3,  4, 1, 5, 9, 2, 6,   5 };
		KnapsackLoes knapsack = new KnapsackLoes(30,weight,value);
		
		knapsack.tryToAdd(0);			
		
		knapsack.printOptimalSolution();
	}
	
	 public void tryToAdd(int index) {
		 
		if (sumWeight+weight[index]>limitWeight) return;
		
		sumWeight += weight[index];
		sumValue += value[index];
		items[itemCount] = index;
		itemCount++;
		// test if new max was achieved
		if (sumValue>=maxValue) {
			maxValue = sumValue;
			itemsMaxValue = Arrays.copyOf(items, itemCount);
			itemCountMaxValue = itemCount;
		}
		for (int i=index+1; i<weight.length; i++) {
			tryToAdd(i);
		}
		itemCount--;
		sumWeight -= weight[index];
		sumValue -= value[index];
	}
	 
	 public void printOptimalSolution() {
		 int sumWeight=0,sumValue=0;
		 for (int i=0; i<itemCountMaxValue; i++) {
			 sumWeight+=weight[itemsMaxValue[i]];
			 sumValue+=value[itemsMaxValue[i]];
			 System.out.println(weight[itemsMaxValue[i]]+" "+value[itemsMaxValue[i]]);
		 }
		 System.out.println("TOTAL: Gewicht="+sumWeight+", Wert="+sumValue);
	 }
	
}

