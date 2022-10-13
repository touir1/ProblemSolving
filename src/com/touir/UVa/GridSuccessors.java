// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

//change classname to Main before submitting
public class GridSuccessors {

	/*
	 * problem: 11581 - Grid Successors
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=624&page=show_problem&problem=2628
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/GridSuccessors.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(in.readLine());
		
		String matrix, nextMatrix;
		int result;
		
		String finish = "000000000";
		
		while(t-- > 0) {
			//flush empty line
			in.readLine();
			
			Set<String> visited = new HashSet<>();
			
			matrix = in.readLine()+in.readLine()+in.readLine();
			visited.add(matrix);
			result = -1;
			
			while(true) {
				nextMatrix = nextMatrix(matrix.toCharArray());
				if(!visited.contains(nextMatrix)) {
					result++;
					if(finish.equals(nextMatrix))
						break;
					visited.add(nextMatrix);
					matrix = nextMatrix;
				}
				else {
					result = -1;
					break;
				}
			}
			out.append(result + "\n");
		}
		
		out.close();
		in.close();
	}
	
	private static String nextMatrix(char[] matrix) {
		char[] result = new char[9];
		for(int i=0;i<9;i++) {
			result[i] = (char)('0'+(
					(i+3<9?matrix[i+3]-'0':0) +
					(i-3 >=0? matrix[i-3]-'0':0) +
					(i%3!=2?matrix[i+1]-'0':0) +
					(i%3!=0? matrix[i-1]-'0':0)
					) % 2);
		}
		return new String(result);
	}
}
