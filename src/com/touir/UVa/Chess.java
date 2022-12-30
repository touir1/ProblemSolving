// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class Chess {

	/*
	 * problem: 278 - Chess
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=214
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/Chess.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		// flush
		scan.nextLine();
		
		while(t-- > 0) {
			String[] input = scan.nextLine().split(" ");
			
			char piece = input[0].charAt(0);
			int m = Integer.valueOf(input[1]);
			int n = Integer.valueOf(input[2]);
			
			if(piece == 'r') System.out.println(Math.min(m, n));
			if(piece == 'Q') System.out.println(Math.min(m, n));
			if(piece == 'K') System.out.println(((m+1)/2)*((n+1)/2));
			if(piece == 'k') System.out.println(((m+1)/2)*((n+1)/2) + (m/2)*(n/2));
			
		}
		
		
		scan.close();
	}
	
	

}
