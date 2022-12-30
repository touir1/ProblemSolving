// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//change classname to Main before submitting
public class CostCutting {

	/*
	 * problem: 11727 - Cost Cutting
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=607&page=show_problem&problem=2827
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/CostCutting.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i<= t; i++) {
			int[] salaries = new int[3];
			for(int j=0;j<3;j++) salaries[j] = scan.nextInt();
			Arrays.sort(salaries);
			
			System.out.println("Case "+i+": " + salaries[1]);
		}
		
		
		scan.close();
	}

}
