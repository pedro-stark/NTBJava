package Lambdas;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class LambdaTest{

	public LambdaTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	    
		System.out.println("-------------Nummern-------------");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    numbers.forEach( (Integer nummer) -> { System.out.println(nummer); } );
	    //numbers.forEach(action);
	    System.out.println("-------------Mathe-------------");
	    Mathe mult = (a,b) -> a*b;
	    Mathe add = (a,b) -> a+b;
	    
	    System.out.println(mult.rechnen(1,3));
	    System.out.println(add.rechnen(1,3));
	    
	    Runnable runny = () -> {
	    	for (int i = 0; i < 100; i++) {
	    		System.out.println(i);
	    		try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    	
	    };
	    
	    Thread t = new Thread(runny);
	    t.start();
	}

}
