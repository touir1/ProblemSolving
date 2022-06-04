// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class WhatIsTheCard {

	/*
	 * problem: 10646 - What is the Card?
	 *
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=611&page=show_problem&problem=1587
	 */

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/WhatIsTheCard.txt"));
		//Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		// flush
		scan.nextLine();

		for(int i=1;i<=t;i++) {
			String cards[] = scan.nextLine().split(" ");
			boolean removed[] = new boolean[52];
			int x=0, y = 0,pointer = 26;
			for(int j=0;j<3;j++) {
				x = cards[pointer].charAt(0) == 'A'
						|| cards[pointer].charAt(0) == 'J'
						|| cards[pointer].charAt(0) == 'Q'
						|| cards[pointer].charAt(0) == 'K'
						|| cards[pointer].charAt(0) == 'T'? 10 : cards[pointer].charAt(0) - 48;
				y+=x;
				removed[pointer] = true;
				pointer--;
				for(int k=0;k<10-x;k++) {
					removed[pointer]=true;
					pointer--;
				}
			}
			for(int j=0,k=0;;j++) {
				if(!removed[j]) k++;
				if(k==y) {
					System.out.println("Case "+i+": "+cards[j]);
					break;
				}
			}
		}


		scan.close();
	}

}
