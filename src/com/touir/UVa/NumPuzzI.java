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
public class NumPuzzI {

	/*
	 * problem: 12398 - NumPuzz I
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=624&page=show_problem&problem=3829
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/NumPuzzI.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cases = 0;
		
		while(in.ready()) {
			cases++;
			
			String input = in.readLine();
			int[][] matrix = new int[3][3];
			int x, y;
			for(int i=input.length()-1;i>=0;i--) {
				x = (input.charAt(i)-'a')/3;
				y = (input.charAt(i)-'a')%3;
				
				matrix[x][y] = (matrix[x][y]+1)%10;
				if(x+1 < 3) matrix[x+1][y] = (matrix[x+1][y]+1)%10;
				if(x-1 >= 0) matrix[x-1][y] = (matrix[x-1][y]+1)%10;
				if(y+1 < 3) matrix[x][y+1] = (matrix[x][y+1]+1)%10;
				if(y-1 >= 0) matrix[x][y-1] = (matrix[x][y-1]+1)%10;
			}
			
			out.append("Case #"+cases+":\n");
			for(int i=0;i<3;i++) {
				out.append(""+matrix[i][0]);
				for(int j=1;j<3;j++) {
					out.append(" "+matrix[i][j]);
				}
				out.append("\n");
			}
		}
		
		out.close();
		in.close();
	}

}
