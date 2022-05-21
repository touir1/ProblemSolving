// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class AutomaticAnswer {

	/*
	 * problem: 11547 - Automatic Answer
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=2542
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/AutomaticAnswer.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		while(t-- > 0) {
			int n = scan.nextInt();
			System.out.println(Math.abs(((((n*567/9)+7492)*235)/47 - 498)/10%10));
		}
		
		
		scan.close();
	}

}
