// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class PackingForHoliday {

	/*
	 * problem: 12372 - Packing for Holiday
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=3794
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/PackingForHoliday.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		//scan.next();
		
		for(int i=1;i<=t; i++) {
			int l = scan.nextInt(), w = scan.nextInt(), h = scan.nextInt();
			
			if(l <= 20 && w <= 20 && h <= 20) System.out.println("Case "+i+": good");
			else System.out.println("Case "+i+": bad");
			
		}
		
		
		scan.close();
	}

}
