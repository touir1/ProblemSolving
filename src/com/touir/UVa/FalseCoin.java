// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class FalseCoin {

	/*
	 * problem: 665 - False coin
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=606
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/FalseCoin.txt"));
		//Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		int n, weighting,weights, result;
		char weightingResult;
		boolean[] coins;
		int[] weightedCoins;
		
		// flush
		scan.nextLine();
					
		while(t-- > 0) {
			
			// flush empty row
			scan.nextLine();
			
			n = scan.nextInt();
			weighting = scan.nextInt();
			result = 0;
			
			coins = new boolean[n+1];
			
			while(weighting-- > 0) {
				weights = scan.nextInt();
				weightedCoins = new int[weights*2];
				for(int i=0;i<weights*2;i++) {
					weightedCoins[i] = scan.nextInt();
				}
				
				// flush
				scan.nextLine();
				
				weightingResult = scan.nextLine().charAt(0);
				if(weightingResult == '=') {
					for(int i=0;i<weights*2;i++) {
						coins[weightedCoins[i]] = true;
					}
				}
				else {
					boolean[] tmp = new boolean[n+1];
					for(int i=0;i<weights*2;i++) {
						tmp[weightedCoins[i]] = true;
					}
					for(int i=1;i<=n;i++) {
						if(!tmp[i]) {
							coins[i] = true;
						}
					}
				}
			}
			for(int i=1;i<=n;i++) {
				if(!coins[i]) {
					if(result != 0) {
						result = 0;
						break;
					}
					result = i;
				}
			}
			System.out.println(result);
			if(t>0) System.out.println();
		}
		
		
		scan.close();
	}

}
