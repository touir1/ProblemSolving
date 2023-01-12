// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//change classname to Main before submitting
public class BrokenKeyboardBeijuText {

	/*
	 * problem: 11988 - Broken Keyboard (a.k.a. Beiju Text)
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=627&page=show_problem&problem=3139
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/BrokenKeyboardBeijuText.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		
		while((input = in.readLine()) != null) {
			LinkedList<String> list = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			boolean start = true;
			
			for(int i=0;i<input.length();i++) {
				char c = input.charAt(i);
				if(c != '[' && c!= ']') {
					sb.append(c);
				}
				else {
					if(start)
						list.addFirst(sb.toString());
					else
						list.addLast(sb.toString());
					if(c == '[')
						start = true;
					else
						start = false;
					sb.setLength(0);
				}
			}
			if(start)
				list.addFirst(sb.toString());
			else
				list.addLast(sb.toString());
			
			
			for(String s : list) {
				out.append(s);
			}
			out.append("\n");
			//System.out.println("-");
		}
		
		out.close();
		in.close();
	}

}
