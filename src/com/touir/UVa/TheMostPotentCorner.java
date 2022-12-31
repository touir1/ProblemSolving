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
public class TheMostPotentCorner {

	/*
	 * problem: 10264 - The Most Potent Corner
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=626&page=show_problem&problem=1205
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/TheMostPotentCorner.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		
		while((input = in.readLine()) != null) {
			int n = 1 << Integer.parseInt(input);  // pow(2,dimension)
			int[] potencies = new int[n];
			int maxPotency = 0;
			
			
			for(int i=0;i<n;i++) {
				int weight = Integer.parseInt(in.readLine());
				
				for(int j=0;j<n;j++) {
					if(areNeighboors(i, j) && i != j) {
						potencies[j] += weight;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(areNeighboors(i, j) && i != j) {
						maxPotency = Math.max(maxPotency, potencies[i] + potencies[j]);
					}
				}
				
			}
			
			
			out.append(maxPotency + "\n");
		}
		
		out.close();
		in.close();
	}
	
	/*
	 * to check if 2 are neighboors they need to have only one different bit
	 * to check that we do a xor operation to remove all identical bits and
	 * then check if we have one and only one bit on (at 1)
	 * to do that, we use LSB:
	 * https://github.com/touir1/Algorithms-Data-Structures-Cheat-sheet/blob/main/DataStructures/Linear%20(built-in)/Bitmask.md
	 * short explanation, LSB gives us the least significant bit that is on (first from the right)
	 * if the LSB of a number is the same as that number, then there's only one bit on (value of 1)
	 */
	public static boolean areNeighboors(int x, int y) {
		// XOR(x,y)
		int n = x^y;
		// LSB(N) == N
		return (n & (-n)) == n;
	}

}
