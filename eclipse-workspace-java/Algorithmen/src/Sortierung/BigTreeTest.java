package Sortierung;

import java.util.Random;

public class BigTreeTest {
	
	static BinaryTree getBigTreePseudoRandom(int size, int maxValue) {
		Random generator = new Random();
		BinaryTree tree = new BinaryTree(generator.nextInt(maxValue));
		for (int i=1; i<size; i++) {
			tree.insert(generator.nextInt(maxValue));
		}
		return tree;
	}

	public static void main(String[] arg) {
		BinaryTree tree = getBigTreePseudoRandom(1000, 100);
		System.out.println("Tiefe: "+tree.getDepth());
		System.out.println("Gewicht: "+tree.getWeight());
		System.out.println("Summe: "+tree.getSum());
		System.out.println("MinValue: "+tree.getMinValue());
		System.out.println("MinValue iterative: "+tree.getMinValueIterative());
		System.out.println("MaxValue: "+tree.getMaxValue());
		System.out.println("MaxValue iterative: "+tree.getMaxValueIterative());
		System.out.println();
		tree.printInOrder();
//		int[][] values = tree.getTreeValues();
//		for (int i=0; i<values.length; i++) {
//			for (int j=0; j<values[i].length; j++) {
//				System.out.print(values[i]+" ");
//			}
//			System.out.println();
//		}

	}
}
