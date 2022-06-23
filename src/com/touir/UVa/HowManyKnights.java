// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class HowManyKnights {

	/*
	 * problem: 696 - How Many Knights
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=612&page=show_problem&problem=637
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/HowManyKnights.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(true) {
			int m = scan.nextInt(), n = scan.nextInt();
			if(m == 0 && n == 0) break;
			
			int result = 0,min = Math.min(m, n), max = Math.max(m, n);
			if(min == 1) result = max;
			else if(min == 2) result = 4*(max/4)+ 2* Math.min(2, max%4);
			else result = (m*n+1)/2;
			
			System.out.println(result+" knights may be placed on a "+m+" row "+n+" column board.");
		}
		
		scan.close();
	}

}
