package Generics;

import java.util.*;

public class MyGenericClass<T, E> {

	private T obj1;
	private E obj2;
	
	public MyGenericClass(T obj1, E obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public void showTypes() {
		System.out.println("Objekt der Klasse \"" + this.getClass().getName() + "\" beinhaltet folgende generischen Typen:");
		System.out.println(obj1.getClass().getName());
		System.out.println(obj2.getClass().getName() +"\n");
	}
	
	public <K> void noReturnValue(K k) {
		System.out.println(k);
	}
	
	public <K extends Vater> K extendsVater(K k) {
		return k;
	}
	
	public void superVater(ArrayList<? super Vater> k) {
		System.out.println(k);
	}
	
	public String toString() {
		return "Generic 1 contains: " + obj1.toString() + ", Generic 2 contains: " + obj2.toString();
	}

	public static void main(String args[]) {
		
		System.out.println("----------------Standardtest----------------");
		MyGenericClass<Integer,Double> m1 = new MyGenericClass<>(100, 100.0);
		MyGenericClass<String, Character> m2 = new MyGenericClass<>("dismami", 'M');
		
		m1.showTypes();
		m2.showTypes();
		
		m1.noReturnValue(new MyGenericClass<Integer, Double>(10, 20.0));
		m2.noReturnValue(m2);
		
		System.out.println("----------------Bounded Tests----------------");
		Grossvater grossvater1 = new Grossvater("Grossvater A"); //Grossvater
		Grossvater grossvater2 = new Grossvater("Grossvater B");
		Grossvater grossvater3 = new Grossvater("Grossvater C");
		Vater vater = new Vater("Vater A");			  //extends Grossvater
		Kind kind = new Kind("Kind A");			  //extends Vater
		try{Kind kind2 = new Kind();}catch(Exception e){e.printStackTrace();}finally {System.out.println("dismami");}			  
		
		System.out.println("----------------Test der Methode extendsVater: upperBounds----------------");
		//m1.extendsVater(grossvater);
		m1.extendsVater(vater);
		m1.extendsVater(kind);
		
		System.out.println("----------------Test der Methode superVater: lowerBounds----------------");
		ArrayList<Grossvater> list = new ArrayList<>();
		list.add(grossvater1);
		list.add(vater);
		list.add(kind);
		list.add(grossvater2);
		list.add(grossvater3);
		m1.superVater(list);
		//m1.superVater(list);
		//m1.superVater(list);
		System.out.println(list);
		list.sort((obj1,obj2) -> {return obj1.compareTo(obj2);});
		System.out.println(list);
		
		Vater daddy = kind;
		//Kind kiddo = (Kind) vater;		
		System.out.println(daddy.toString());
	}
	
	public static synchronized <K> MyGenericClass forthelulz(K k) throws Exception{
		String[] a = {"a", "b", "c", "d", "e", "f"};
		Integer[] b = {1,2,3,4,5,6,7};
		int[] c = {1,2,3,4,5,6,7};
		int d = 1;
		MyGenericClass<Integer[], K> m = new MyGenericClass<>(b, k);
		return m;
	}
}
