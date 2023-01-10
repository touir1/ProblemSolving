// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

//change classname to Main before submitting
public class Multitasking {

	/*
	 * problem: 11926 - Multitasking
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=626&page=show_problem&problem=3077
	 */
	
	private static final int MAX_SIZE = 1_000_000;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/Multitasking.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n,m, begin, end, interval, maxCardinality;
		
		while(true) {
			String[] input = in.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			
			if(n == 0 && m == 0)
				break;
			
			BitSet bitSet = new BitSet(MAX_SIZE);
			maxCardinality = 0;
			
			for(int i=0;i<n;i++) {
				input = in.readLine().split(" ");
				begin = Integer.parseInt(input[0]);
				end = Integer.parseInt(input[1]);
				
				maxCardinality += end - begin;
				bitSet.set(begin, end);
			}
			for(int i=0;i<m;i++) {
				input = in.readLine().split(" ");
				begin = Integer.parseInt(input[0]);
				end = Integer.parseInt(input[1]);
				interval = Integer.parseInt(input[2]);
				
				while(begin <= MAX_SIZE && end <= MAX_SIZE) {
					maxCardinality += end - begin;
					bitSet.set(begin, end);
					
					begin += interval;
					end = (end + interval) <= MAX_SIZE ? end + interval : MAX_SIZE;
				}
			}
			
			if(maxCardinality != bitSet.cardinality())
				out.append("CONFLICT\n");
			else
				out.append("NO CONFLICT\n");
			//System.out.println("-");
		}
		
		out.close();
		in.close();
	}

}
