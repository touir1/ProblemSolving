// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class HorrorDash {

	/*
	 * problem: 11799 - Horror Dash
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=608&page=show_problem&problem=2899
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/HorrorDash.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i=1;i<=t;i++) {
			int n = scan.nextInt();
			int clownSpeed = 0;
			while(n-- > 0) {
				clownSpeed = Math.max(clownSpeed, scan.nextInt());
			}

			System.out.println("Case "+i+": "+clownSpeed);
		}
		
		
		scan.close();
	}

}
