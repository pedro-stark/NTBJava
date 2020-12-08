package src.CollectionsLoesung.bsp6_Generics_BoundedTypes;

//Diese Box unterstützt nur Typen, die das Comparable-Interface implementiert haben!
public class BoxForComparables<T extends Comparable<T>> {
	private T boxedT;
	
	public BoxForComparables() {
		boxedT = null;
	}
	
	public BoxForComparables(T t) {
		box(t);
	}
	
	public void box(T t) {
		boxedT = t;
	}
	 
	public T unbox() {
		return boxedT;
	}
	
	public String toString() {
		return boxedT.toString();
	}
	
	public boolean equals(Object t) {
		return boxedT.compareTo((T)t) == 0;
	}
}
