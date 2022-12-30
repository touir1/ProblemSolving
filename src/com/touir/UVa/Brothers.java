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
public class Brothers {

	/*
	 * problem: 12187 - Brothers
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=624&page=show_problem&problem=3339
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/Brothers.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n,r,c,k;
		String[] input;
		int current;
		
		while(true) {
			input = in.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			r = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			k = Integer.parseInt(input[3]);
			
			if(n == 0 && r == 0 && c == 0 && k == 0)
				break;
			
			int[][] battlefield = new int[r][c];
			boolean[][] visited;
			
			for(int i=0;i<r;i++) {
				input = in.readLine().split(" ");
				for(int j=0;j<c;j++) {
					battlefield[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			while(k-- > 0) {
				visited = new boolean[r][c];
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						current = visited[i][j]? (battlefield[i][j]+1 == n? 0 : battlefield[i][j]+1) : battlefield[i][j];
						
						if(i+1<r && !visited[i+1][j] && 
								(battlefield[i+1][j]-1 == current || (battlefield[i+1][j] == 0 && current == n-1))) {
							visited[i+1][j] = true;
							battlefield[i+1][j] = current;
						}
						if(i-1>=0 && !visited[i-1][j] && 
								(battlefield[i-1][j]-1 == current || (battlefield[i-1][j] == 0 && current == n-1))) {
							visited[i-1][j] = true;
							battlefield[i-1][j] = current;
						}
						if(j+1<c && !visited[i][j+1] && 
								(battlefield[i][j+1]-1 == current || (battlefield[i][j+1] == 0 && current == n-1))) {
							visited[i][j+1] = true;
							battlefield[i][j+1] = current;
						}
						if(j-1>=0 && !visited[i][j-1] && 
								(battlefield[i][j-1]-1 == current || (battlefield[i][j-1] == 0 && current == n-1))) {
							visited[i][j-1] = true;
							battlefield[i][j-1] = current;
						}
					}
				}
			}
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c-1;j++) {
					out.append(battlefield[i][j] + " ");
				}
				out.append(battlefield[i][c-1] + "\n");
			}
		}
		
		
		
		out.close();
		in.close();
	}

}
