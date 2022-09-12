// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//change classname to Main before submitting
public class PolePosition {

	/*
	 * problem: 12150 - Pole Position
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=3302
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/PolePosition.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0)
				break;
			
			int[] positions = new int[n];
			
			boolean result = true;
			for(int i=0;i<n;i++) {
				String[] input = in.readLine().split(" ");
				
				int position = Integer.parseInt(input[1]) + i;
				if(position < 0 || position >= n || positions[position] != 0) {
					result = false;
					
					// flush test case
					while(++i<n) in.readLine();
					
					continue;
				}
				positions[position] = Integer.parseInt(input[0]);
			}
			if(!result) 
				System.out.println(-1);
			else {
				for(int i=0;i<n-1;i++) {
					System.out.print(positions[i] + " ");
				}
				System.out.println(positions[n-1]);
				
				
			}
		}
		
		
		in.close();
	}

}
