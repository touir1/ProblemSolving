// remove package before submitting
package com.touir.UVa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//change classname to Main before submitting
public class IDCodes {

	/*
	 * problem: 146 - ID Codes
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=82
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/IDCodes.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] input;
		
		while(true) {
			input = in.readLine().toCharArray();
			
			if(input[0] == '#')
				break;
			
			if(nextPermutation(input)) {
				out.append(String.valueOf(input));
			}
			else {
				out.append("No Successor");
			}
			out.append("\n");
		}
		
		out.close();
		in.close();
	}
	
	public static char[] swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		return arr;
	}
	
	public static char[] reverse(char[] arr, int begin, int end) {
		while(begin < end) {
			char tmp = arr[begin];
			arr[begin++] = arr[end];
			arr[end--] = tmp;
		}
		
		return arr;
	}
	
	public static boolean nextPermutation(char[] arr) {
		
		// no permutations for size < 2
		if(arr.length <= 1) return false;
		
		int pivot = arr.length - 1;
		
		// find the longest non-increasing suffix
		// the pivot would be the starting index of that suffix
		while(--pivot >= 0 && arr[pivot] >= arr[pivot + 1]);
		
		// if no increasing pair, no permutation possible
		if(pivot < 0) return false;
		
		int successor = arr.length;
		
		// find the successor of the pivot
		// rightmost element greater than the pivot
		while(--successor > pivot && arr[successor] <= arr[pivot]);
		
		// swap the pivot and the successor
		arr = swap(arr,pivot,successor);
		
		// reverse the suffix
		arr = reverse(arr, pivot + 1, arr.length - 1);
		
		return true;
	}

}
