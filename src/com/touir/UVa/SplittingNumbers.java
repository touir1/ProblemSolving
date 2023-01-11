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
public class SplittingNumbers {

	/*
	 * problem: 11933 - Splitting Numbers
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=626&page=show_problem&problem=3084
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/SplittingNumbers.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String input = in.readLine();
			int bitmask = Integer.parseInt(input);
			boolean turn = false;
			
			if(bitmask == 0)
				break;
			
			int[] result = new int[] {bitmask, bitmask};
			
			while(bitmask != 0) {
				int lsb = bitmask & (-bitmask); // get the least significant bit
				
				if(turn)
					result[0] &= ~lsb;
				else
					result[1] &= ~lsb;
				
				bitmask &= ~lsb; // set the lsb off
				turn = !turn;
			}
			
			out.append(result[0] + " " + result[1] + "\n");
		}
		
		out.close();
		in.close();
	}

}
