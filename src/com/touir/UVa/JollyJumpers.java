// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class JollyJumpers {

	/*
	 * problem: 10038 - Jolly Jumpers
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=979
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/JollyJumpers.txt"));
		//Scanner scan = new Scanner(System.in);
		int n;
		boolean[] check;
		int last,curr;
		boolean result;
		
		while(scan.hasNext()) {
			n = scan.nextInt();
			check = new boolean[n];
			last = scan.nextInt();
			for(int i=0;i<n-1;i++) {
				curr = scan.nextInt();
				if(Math.abs(last-curr) <= n-1)
					check[Math.abs(last-curr)] = true;
				last=curr;
			}
			result = true;
			for(int i=1;i<n;i++) {
				if(!check[i]) {
					result = false; 
					break;
				}
			}
			if(result) System.out.println("Jolly");
			else System.out.println("Not jolly");
		}
		
		
		scan.close();
	}

}
