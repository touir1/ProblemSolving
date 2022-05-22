// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class LoansomeCarBuyer {

	/*
	 * problem: 10114 - Loansome Car Buyer
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=608&page=show_problem&problem=1055
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/LoansomeCarBuyer.txt"));
		//Scanner scan = new Scanner(System.in);
		
		while(true) {
			String[] input = scan.nextLine().split(" ");
			int months = Integer.valueOf(input[0]);
			double downPayment = Double.valueOf(input[1]), loan = Double.valueOf(input[2]);
			int depreciations = Integer.valueOf(input[3]);
			double[] depValues = new double[101];
			
			if(months < 0) break;
			
			for(int i=0;i<depreciations;i++) {
				input = scan.nextLine().split(" ");
				int month = Integer.valueOf(input[0]);
				double dep = Double.valueOf(input[1]);
				depValues[month] = dep;
			}
			
			double owed = loan, depPrice = (loan + downPayment);
			double depValue = depValues[0];
			
			for(int i=0;i<=months;i++) {
				if(depValues[i] != 0) depValue = depValues[i];
				
				depPrice -= depPrice * depValue;
				//System.out.println(i+": depPrice: "+depPrice + ", owed: "+owed);
				if(depPrice > owed) {
					System.out.println(i + " month"+(i != 1?"s":""));
					break;
				}
				owed -= loan/months;
			}
		}
		
		
		scan.close();
	}

}
