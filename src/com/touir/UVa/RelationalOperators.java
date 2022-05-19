// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class RelationalOperators {

	/*
	 * problem: 11172 - Relational Operator
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2113
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/RelationalOperators.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		while(t-- > 0) {
			int a = scan.nextInt(), b = scan.nextInt();
			
			System.out.println(a > b? ">" : a < b ? "<" : "=");
		}
		
		scan.close();
	}

}
