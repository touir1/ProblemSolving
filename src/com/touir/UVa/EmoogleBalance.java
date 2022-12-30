// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class EmoogleBalance {

	/*
	 * problem: 12279 - Emoogle Balance
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=3431
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/EmoogleBalance.txt"));
		//Scanner scan = new Scanner(System.in);
		int cases = 1;
		while(true) {
			int n = scan.nextInt(), balance = 0;
			if(n == 0) break;
			
			while(n-- > 0) {
				if(scan.nextInt() > 0) balance++;
				else balance--;
			}
			
			System.out.println("Case " + cases + ": "+ balance);
			
			cases++;
		}
		
		
		scan.close();
	}

}
