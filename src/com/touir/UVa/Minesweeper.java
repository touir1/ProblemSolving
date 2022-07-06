// remove package before submitting
package com.touir.UVa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//change classname to Main before submitting
public class Minesweeper {

	/*
	 * problem: 10189 - Minesweeper
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=613&page=show_problem&problem=1130
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream("./src/com/touir/UVa/input/Minesweeper.txt"));
		//Scanner scan = new Scanner(System.in);
		int nb = 0;
		while(true) {
			int n = scan.nextInt(), m = scan.nextInt();
			if(n==0 && m == 0) break;
			nb++;
			
			// flush
			scan.nextLine();
			
			char[][] grid = new char[n][m];
			int[][] help = new int[n][m];
			for(int i=0;i<n;i++) {
				grid[i] = scan.nextLine().toCharArray();
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(grid[i][j]=='*') {
						if(i>0) {
							help[i-1][j]++;
							if(j>0) help[i-1][j-1]++;
							if(j+1<m) help[i-1][j+1]++;
						}
						if(i+1<n) {
							help[i+1][j]++;
							if(j>0) help[i+1][j-1]++;
							if(j+1<m) help[i+1][j+1]++;
						}
						if(j>0) help[i][j-1]++;
						if(j+1<m) help[i][j+1]++;
					}
				}
			}
			
			
			if(nb>1) System.out.println();
			System.out.println("Field #"+nb+":");
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(grid[i][j] == '*') System.out.print(grid[i][j]);
					else System.out.print(help[i][j]);
				}
				System.out.println();
			}
		}
		
		
		scan.close();
	}

}
