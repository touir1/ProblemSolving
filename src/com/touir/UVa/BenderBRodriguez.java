// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class BenderBRodriguez {

	/*
	 * problem: 11507 - Bender B. Rodríguez Problem
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=609&page=show_problem&problem=2502
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/BenderBRodriguez.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(true) {
			int n = scan.nextInt();
			if(n == 0) break;
			
			// flush
			scan.nextLine();
			
			String[] bends = scan.nextLine().split(" ");
			String current = "+x";
			
			for(String bend : bends) {
				if("No".equals(bend)) continue;
				
				if("+y".equals(bend)) {
					if("+x".equals(current)) current = "+y";
					else if("-x".equals(current)) current = "-y";
					else if("+y".equals(current)) current = "-x";
					else if("-y".equals(current)) current = "+x";
				}
				else if("-y".equals(bend)) {
					if("+x".equals(current)) current = "-y";
					else if("-x".equals(current)) current = "+y";
					else if("+y".equals(current)) current = "+x";
					else if("-y".equals(current)) current = "-x";
				}
				else if("+z".equals(bend)) {
					if("+x".equals(current)) current = "+z";
					else if("-x".equals(current)) current = "-z";
					else if("+z".equals(current)) current = "-x";
					else if("-z".equals(current)) current = "+x";
				}
				else if("-z".equals(bend)) {
					if("+x".equals(current)) current = "-z";
					else if("-x".equals(current)) current = "+z";
					else if("+z".equals(current)) current = "+x";
					else if("-z".equals(current)) current = "-x";
				}
			}
			System.out.println(current);
		}
		
		
		scan.close();
	}

}
