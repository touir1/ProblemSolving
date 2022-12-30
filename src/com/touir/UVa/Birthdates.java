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
public class Birthdates {

	/*
	 * problem: 12541 - Birthdates
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=3986
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/Birthdates.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(in.readLine());
		String youngerName = null, olderName = null;
		int youngerDays = Integer.MIN_VALUE, olderDays = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			String[] input = in.readLine().split(" ");
			int days = convertDateToDays(input[1],input[2],input[3]);
			if(days < olderDays) {
				olderName = input[0];
				olderDays = days;
			}
			if(days > youngerDays) {
				youngerName = input[0];
				youngerDays = days;
			}
		}
		
		out.append(youngerName + "\n"+olderName+"\n");
		
		out.close();
		in.close();
	}
	
	public static int convertDateToDays(String day, String month, String year) {
		// supposing a month is 31 days
		return Integer.valueOf(year) * 12 * 31 +
				Integer.valueOf(month) * 31 +
				Integer.valueOf(day);
	}

}
