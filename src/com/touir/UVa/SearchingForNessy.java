// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class SearchingForNessy {

	/*
	 * problem: 11044 - Searching for Nessy
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1985
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/SearchingForNessy.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		while(t-- > 0) {
			int n = scan.nextInt(), m = scan.nextInt();
			
			System.out.println((n/3) * (m/3));
		}
		
		scan.close();
	}

}
