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
	
	int getDepth() {
		int depthLeft = 0, depthRight = 0;
		if (left != null) depthLeft = left.getDepth();
		if (right != null) depthRight = right.getDepth();
		return Math.max(depthLeft, depthRight)+1; //postorder
	}
	
	int getWeight() {
		int weightLeft = 0, weightRight = 0;
		if (left != null) weightLeft = left.getWeight();
		if (right != null) weightRight = right.getWeight();
		return weightLeft+weightRight+1; // postorder
	}
	
	int getSum() {
		int sumLeft = 0, sumRight = 0;
		if (left != null) sumLeft = left.getSum();
		if (right != null) sumRight = right.getSum();
		return this.data+sumLeft+sumRight;  // postorder
	}
	
	int getMinValue() {
		return getMinNode().data;
	}
	int getMinValueIterative() {
		return getMinNodeIterative().data;
	}
	BinaryTree getMinNode() {
		if (left!=null) {
			return left.getMinNode();
		}
		return this;
	}
	
	BinaryTree getMinNodeIterative() {
		BinaryTree node = left;
		BinaryTree prev = this;
		while (node != null) { prev = node; node = node.left; }
		return prev;
	}
		
	void printInOrder() { // inorder: links, op, rechts
		if (left != null) left.printInOrder();
		System.out.print(data+" ");
		if (right != null) right.printInOrder();
	}
	
	int getMaxValue() {
		return getMaxNode().data;
	}
	int getMaxValueIterative() {
		return getMaxNodeIterative().data;
	}
	BinaryTree getMaxNode() {
		if (right!=null) {
			return right.getMaxNode();
		}
		return this;
	}
	BinaryTree getMaxNodeIterative() {
		BinaryTree node = right;
		BinaryTree prev = this;
		while (node != null) { prev = node; node = node.right; }
		return prev;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(3);
		tree.insert(1);
		tree.insert(4);
		tree.insert(1);
		tree.insert(5);

		/*
		3
	   / \ 	
	  1	  4
	   \   \
	    1	5
	    */
		
		BinaryTree node = tree.search(5);
		System.out.println(node);

		node = tree.search(10);
		System.out.println(node);
		
		System.out.println("Max: "+tree.getMaxValue());
		System.out.println("Min: "+tree.getMinValue());
		System.out.println("Sum: "+tree.getSum());
		System.out.println("Weight: "+tree.getWeight());
		System.out.println("Tiefe: "+tree.getDepth());
		
		tree.printInOrder();
	}

}







