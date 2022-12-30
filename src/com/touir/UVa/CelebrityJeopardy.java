// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class CelebrityJeopardy {

	/*
	 * problem: 1124 - Celebrity jeopardy
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3565
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/CelebrityJeopardy.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			String input = scan.nextLine();
			System.out.println(input);
		}
		
		scan.close();
	}

}
