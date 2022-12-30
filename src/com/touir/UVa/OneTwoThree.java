// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class OneTwoThree {

	/*
	 * problem: 12289 - One-Two-Three
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=3710
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/OneTwoThree.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		//scan.next();
		
		//flush
		scan.nextLine();
		
		while(t-- > 0) {
			String s = scan.nextLine();
			
			if(s.length() == 5) System.out.println(3);
			else if((s.charAt(0) == 'o'? 1:0) + (s.charAt(1) == 'n'? 1:0) + (s.charAt(2) == 'e'? 1:0) >= 2) System.out.println(1);
			else System.out.println(2);
		}
		
		
		scan.close();
	}

}
