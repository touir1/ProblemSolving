// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//change classname to Main before submitting
public class SpiralTap {

	/*
	 * problem: 10920 - Spiral Tap
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=624&page=show_problem&problem=1861
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/SpiralTap.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size, coordinate;
		String[] input;
		
		int x,y, subSize, lower, upper;
		
		
		while(true) {
			input = in.readLine().split(" ");
			size = Integer.parseInt(input[0]);
			coordinate = Integer.parseInt(input[1]);
			
			if(size == 0 && coordinate == 0)
				break;
			
			x = y = 1;
			subSize = 1;
			
			while(coordinate > subSize*subSize)
				subSize+=2;
			
			if(coordinate == subSize*subSize) {
				x = y = (size + subSize)/2;
			}
			else {
				upper = (size + subSize)/2;
				lower = (size - subSize)/2 + 1;
				if(coordinate >= subSize*(subSize-1)+1) {
					y = upper;
					x = lower + coordinate - (subSize*(subSize-1)+1);
				}
				else if(coordinate >= subSize*(subSize-2) + 2) {
					x = lower;
					y = lower + coordinate - (subSize*(subSize-2) + 2);
				}
				else if(coordinate >= subSize*(subSize-3) + 3) {
					y = lower;
					x = upper - coordinate + (subSize*(subSize-3) + 3);
				}
				else {
					x = upper;
					y = upper - coordinate + (subSize*(subSize-4) + 4);
				}
			}
			
			out.append("Line = "+x+", column = "+y+".\n");
		}
		
		out.close();
		in.close();
	}

}
