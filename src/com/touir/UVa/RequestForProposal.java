// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class RequestForProposal {

	/*
	 * problem: 10141 - Request for Proposal
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=609&page=show_problem&problem=1082
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/RequestForProposal.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = 0;
		
		while(true) {
			int n = scan.nextInt(), p = scan.nextInt();
			if(n == 0) break;
			t++;
			if(t > 1) System.out.println();
			
			double bestPrice = Integer.MAX_VALUE;
			int bestMetReq = 0;
			String proposal = "";
			
			//flush
			scan.nextLine();
			while(n-- > 0) scan.nextLine();
			
			while(p-- > 0) {
				String prop = scan.nextLine();
				String[] input = scan.nextLine().split(" ");
				double price = Double.valueOf(input[0]);
				int metR = Integer.valueOf(input[1]);
				
				if(metR > bestMetReq) {
					bestMetReq = metR;
					bestPrice = price;
					proposal = prop;
				}
				else if(metR == bestMetReq) {
					if(price < bestPrice) {
						bestPrice = price;
						proposal = prop;
					}
				}
				
				//flush
				while(metR-- > 0) scan.nextLine();
			}
			System.out.println("RFP #"+t);
			System.out.println(proposal);
		}
		
		
		scan.close();
	}

}
