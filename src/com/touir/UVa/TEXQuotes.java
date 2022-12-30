// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class TEXQuotes { 

	/*
	 * problem: 272 - TEX Quotes
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=4&page=show_problem&problem=208
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/TEXQuotes.txt"));
		//Scanner scan = new Scanner(System.in);
		String input = null;
		
		boolean opening = true;
		char c;
		
		while(scan.hasNext()) {
			input = scan.nextLine();
			StringBuilder result = new StringBuilder();
			for(int i=0;i<input.length();i++) {
				c = input.charAt(i);
				if(c == '"') {
					if(opening)
						result.append("``");
					else
						result.append("''");
					opening = !opening;
				}
				else
					result.append(c);
			}
			System.out.println(result.toString());
		}
		scan.close();
	}
}
