// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class Parking {

	/*
	 * problem: 11364 - Parking
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=2349
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/Parking.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		while(t-- > 0) {
			int n = scan.nextInt();
			int left=100,right=0,tmp;
			
			for(int i=0; i<n; i++) {
				tmp = scan.nextInt();
				if(tmp < left) left = tmp;
				if(tmp > right) right = tmp;
			}
			
			System.out.println((right - left) * 2);
		}
		
		scan.close();
	}

}
