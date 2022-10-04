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
public class RotatedSquare {

	/*
	 * problem: 10855 - Rotated square
	 * 
	 * url: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=624&page=show_problem&problem=1796
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/RotatedSquare.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input;
		String row;
		int N,n;
		boolean r1,r2,r3,r4;
		
		int countR1,countR2,countR3,countR4;
		
		while(true) {
			// input
			input = in.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			
			if(N == 0 && n == 0)
				break;
			
			String[] bigSquare = new String[N];
			String[] smallSquare = new String[n];
			countR1 = countR2 = countR3 = countR4 = 0;
			
			for(int i=0;i<N;i++) {
				row = in.readLine();
				bigSquare[i] = row;
			}
			for(int i=0;i<n;i++) {
				row = in.readLine();
				smallSquare[i] = row;
			}
			
			// solution
			for(int i=0;i<N-n+1;i++) {
				for(int j=0;j<N-n+1;j++) {
					r1 = r2 = r3 = r4 = true;
					
					for(int ii=0;ii<n;ii++) {
						for(int jj=0;jj<n;jj++) {
							//   0 deg
							if(r1 && bigSquare[i+ii].charAt(j+jj) != smallSquare[ii].charAt(jj))
								r1 = false;
							//  90 deg
							if(r2 && bigSquare[i+ii].charAt(j+jj) != smallSquare[n-jj-1].charAt(ii))
								r2 = false;
							// 180 deg
							if(r3 && bigSquare[i+ii].charAt(j+jj) != smallSquare[n-ii-1].charAt(n-jj-1))
								r3 = false;
							// 270 deg
							if(r4 && bigSquare[i+ii].charAt(j+jj) != smallSquare[jj].charAt(n-ii-1))
								r4 = false;
							
							if(!r1 && !r2 && !r3 && !r4)
								break;
						}
					}
					if(r1) countR1++;
					if(r2) countR2++;
					if(r3) countR3++;
					if(r4) countR4++;
					
				}
			}
			
			out.append(countR1 + " " + countR2 + " " + countR3 + " " + countR4 + "\n");
		}
		
		out.close();
		in.close();
	}

}
