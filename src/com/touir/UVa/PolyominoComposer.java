// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//change classname to Main before submitting
public class PolyominoComposer {

	/*
	 * problem: 12291 - Polyomino Composer
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=624&page=show_problem&problem=3712
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/PolyominoComposer.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n,m;
		String[] inputArray;
		String input;
		
		while(true) {
			inputArray = in.readLine().split(" ");
			
			n = Integer.parseInt(inputArray[0]);
			m = Integer.parseInt(inputArray[1]);
			
			if(n == 0 && m == 0)
				break;
			
			char[][] matrix = new char[n][n];
			char[][] sub = new char[m][m];
			
			for(int i=0;i<n;i++) {
				input = in.readLine();
				for(int j=0;j<input.length();j++) {
					matrix[i][j] = input.charAt(j);
				}
			}
			for(int i=0;i<m;i++)
			{
				input = in.readLine();
				for(int j=0;j<input.length();j++) {
					sub[i][j] = input.charAt(j);
				}
			}
			
			out.append(compute(matrix,sub,n,m)+"\n");
		}
		
		out.close();
		in.close();
	}
	
	private static boolean canPutAtPosition(char[][] matrix, char[][] sub, int posX, int posY, int n, int m, int skipX, int skipY) {		
		for(int i=skipX;i<m;i++) {
			for(int j=skipY;j<m;j++) {
				if(sub[i][j] == '*' && (i-skipX+posX >=n || j-skipY+posY >= n || matrix[i-skipX+posX][j-skipY+posY] != '*'))
					return false;
			}
		}
		return true;
	}
	
	private static int compute(char[][] matrix, char[][] sub, int n, int m) {
		// pre check
		int countM = 0, countN = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j] == '*')
					countN++;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(sub[i][j] == '*')
					countM++;
			}
		}
		if(countM*2 != countN)
			return 0;
		
		
		int skipX = m, skipY = m;
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(sub[i][j] == '*') {
					skipX = Math.min(skipX, i);
					skipY = Math.min(skipY, j);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(canPutAtPosition(matrix, sub, i,j, n, m, skipX, skipY)) {
					flag(matrix, sub, m, skipX, skipY, i, j, '*', '#');
					for(int k=0;k<n;k++) {
						for(int l=0;l<n;l++) {
							if(canPutAtPosition(matrix, sub, k, l, n, m, skipX, skipY)) {
								//flag(matrix, sub, m, skipX, skipY, k, l, '*', '#');
								//if(checkIfEmpty(matrix, n))
									return 1;
								//flag(matrix, sub, m, skipX, skipY, k, l, '*', '*');
							}
						}
					}
					flag(matrix, sub, m, skipX, skipY, i, j, '*', '*');
				}
			}
		}
		return 0;
	}

	private static void flag(char[][] matrix, char[][] sub, int m, int skipX, int skipY, int i, int j, char lookup, char tag) {
		for(int k=skipX;k<m;k++) {
			for(int l=skipY;l<m;l++) {
				if(sub[k][l] == lookup) {
					matrix[i+k-skipX][j+l-skipY] = tag;
				}
			}
		}
	}
	
	private static boolean checkIfEmpty(char[][] matrix, int m) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(matrix[i][j] == '*')
					return false;
			}
		}
		return true;
	}

}
