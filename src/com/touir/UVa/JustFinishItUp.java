// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class JustFinishItUp {

	/*
	 * problem: 11093 - Just Finish it up
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=2034
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		// comment next row and uncomment the one after before submitting
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/JustFinishItUp.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int tCase = 1; tCase <= t; tCase++) {
			int n = scan.nextInt();

			int[] gas = new int[n];
			int[] cost = new int[n];
			int totalGas = 0;
			int totalCost = 0;
			
			for(int i=0;i<n;i++) {
				gas[i] = scan.nextInt();
				totalGas += gas[i];
			}
			for(int i=0;i<n;i++) {
				cost[i] = scan.nextInt();
				totalCost += cost[i];
			}
			
			int start = 0;
			
			if(totalGas >= totalCost) {
				int sum = gas[0];
				for(int i=1;i<=n;i++) {
					sum -= cost[(i-1)%n];
					if(sum < 0) {
						while(sum < 0 && start < i) {
							sum -= gas[start%n];
							sum += cost[start%n];
							start++;
						}
					}
					sum+= gas[i%n];
				}
			}
			else
				start = n;
			
			
			if(start < n)
				System.out.println("Case "+tCase+": Possible from station "+ (start+1));
			else
				System.out.println("Case "+tCase+": Not possible");
		}
		
		
		scan.close();
	}

}
