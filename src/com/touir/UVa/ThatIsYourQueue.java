// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//change classname to Main before submitting
public class ThatIsYourQueue {

	/*
	 * problem: 12207 - That is Your Queue
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=629&page=show_problem&problem=3359
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/ThatIsYourQueue.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input;
		int t=1, turn;
		
		while(true) {
			input = in.readLine().split(" ");
			int population = Integer.parseInt(input[0]), orders = Integer.parseInt(input[1]);
			
			if(population == 0 && orders == 0)
				break;
			
			int min = Math.min(population,orders);
			
			out.append("Case "+t+":\n");
			Queue<Integer> queue = new ArrayDeque<>(min);
			Deque<Integer> accidentQueue = new ArrayDeque<>(min);
			
			for(int i=1;i<=min;i++) {
				queue.add(i);
			}
			
			for(int i=0; i < orders; i++) {
				input = in.readLine().split(" ");
				if(input[0].charAt(0) == 'N') {
					if(accidentQueue.isEmpty()) {
						turn = queue.poll();
						out.append(turn + "\n");
						queue.add(turn);
						
					}
					else {
						turn = accidentQueue.poll();
						out.append(turn + "\n");
						queue.add(turn);
					}
				}
				else {
					turn = Integer.parseInt(input[1]);
					accidentQueue.remove(turn);
					queue.remove(turn);
					accidentQueue.addFirst(turn);
				}
					
			}
			
			t++;
		}
		
		out.close();
		in.close();
	}

}
