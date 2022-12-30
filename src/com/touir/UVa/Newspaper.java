// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//change classname to Main before submitting
public class Newspaper {

	/*
	 * problem: 11340 - Newspaper
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=2315
	 */
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/Newspaper.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine()),n, price;
		int[] prices;
		
		String input;
		
		while(t-- > 0) {
			prices = new int[257]; //ASCII table
			price = 0;
			
			n = Integer.parseInt(in.readLine());
			
			while(n-- > 0) {
				input = in.readLine();
				// using ASCII of char as a hash
				prices[input.charAt(0)] = Integer.parseInt(input.substring(2).trim());
			}
			
			n = Integer.parseInt(in.readLine());
			
			while(n-- > 0) {
				input = in.readLine();
				for(int i=0;i< input.length();i++) {
					//ignore non ASCII characters
					price += prices[input.charAt(i)> 255? 256 : input.charAt(i)];
				}
			}
			
			System.out.println((price/100) + "." + String.format("%02d",price%100) + "$");
		}
		
		
		in.close();
	}

}
