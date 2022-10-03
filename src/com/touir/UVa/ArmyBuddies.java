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
public class ArmyBuddies {

	/*
	 * problem: 12356 - Army Buddies
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=623&page=show_problem&problem=3778
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/ArmyBuddies.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int s,b,left,right;
		
		// next alive going left or right
		int[] aliveL = new int[100_001];
		int[] aliveR = new int[100_001];
		
		while(true) {
			String[] input = in.readLine().split(" ");
			s = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			
			if(s == 0 && b == 0)
				break;
			
			// initialize lists
			for(int i=1;i<s;i++) {
				aliveL[i] = i-1;
				aliveR[i] = i+1;
			}
			aliveL[1] = -1;
			aliveR[s] = -1;
			
			
			while(b-- > 0) {
				input = in.readLine().split(" ");
				left = Integer.parseInt(input[0]);
				right = Integer.parseInt(input[1]);
				
				// linking between next alive left and next alive right
				// (next alive right) of the (next alive left) of the (dead left) is the (next alive right) of the (dead right)
				if(left != 1 && aliveL[left] != -1)
					aliveR[aliveL[left]] = aliveR[right];
				// (next alive left) of the (next alive right) of the (dead right) is the (next alive left) of the (dead left)
				if(right != s && aliveR[right] != -1)
					aliveL[aliveR[right]] = aliveL[left];
				
				out.append((aliveL[left]==-1?"*":aliveL[left])+" "+(aliveR[right]==-1?"*":aliveR[right]) + "\n");
				//System.out.println((aliveL[left]==-1?"*":aliveL[left])+" "+(aliveR[right]==-1?"*":aliveR[right]));
			}
			out.append("-\n");
			//System.out.println("-");
		}
		
		out.close();
		in.close();
	}

}
