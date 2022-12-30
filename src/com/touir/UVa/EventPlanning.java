// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class EventPlanning {

	/*
	 * problem: 11559 - Event Planning
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=608&page=show_problem&problem=2595
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/EventPlanning.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			int nb = scan.nextInt(), 
				budget = scan.nextInt(), 
				hotels = scan.nextInt(), 
				weeks = scan.nextInt();
			
			int cheapestPrice = Integer.MAX_VALUE;
			
			
			while(hotels -- > 0) {
				int price = scan.nextInt()*nb;
				for(int i=0;i<weeks;i++) {
					if(scan.nextInt() >= nb && price <= budget && price < cheapestPrice)
						cheapestPrice = price;
				}
			}
			
			if(cheapestPrice != Integer.MAX_VALUE)
				System.out.println(cheapestPrice);
			else
				System.out.println("stay home");
		}
		
		
		scan.close();
	}

}
