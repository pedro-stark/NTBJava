package Sortierung;
public class BinaryTree {
	BinaryTree left, right;
	int data;
	
	BinaryTree(int value) {
		data = value;
	}
	
	void insert(int value) {
		if (value < data) {  // nach links
			if (left == null) {
				BinaryTree newNode = new BinaryTree(value);
				left = newNode;
			} else {
				left.insert(value);
			}
		} else { // value >= data
			if (right == null) {
				BinaryTree newNode = new BinaryTree(value);
				right = newNode;
			} else {
				right.insert(value);
			}
		}
	}

	BinaryTree search(int value) {
		if (value == data) return this;
		if (value < data) {
			if (left == null) {
				return null;
			} else {
				return left.search(value);
			}
		} else { // value >= data
			if (right == null) {
				return null;
			} else {
				return right.search(value);
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(3);
		tree.insert(1);
		tree.insert(4);
		tree.insert(1);
		tree.insert(5);

		BinaryTree node = tree.search(5);
		System.out.println(node);

		node = tree.search(10);
		System.out.println(node);
		
		System.out.println("Tiefe: "+tree.getDepth());
		System.out.println("Max: "+tree.getMaxValue());
		System.out.println("Min: "+tree.getMinValue());
		System.out.println("Weight: "+tree.getWeight());
		System.out.println("Sum: "+tree.getSum());
				
	}

}







