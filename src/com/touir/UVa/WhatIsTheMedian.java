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
public class WhatIsTheMedian {

	/*
	 * problem: 10107 - What is the Median?
	 * 
	 * url: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=1048
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// comment next row and uncomment the one after before submitting
		BufferedReader in = new BufferedReader(new FileReader("./src/com/touir/UVa/input/WhatIsTheMedian.txt"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10000];
		int left = 0, right = -1;
		
		while(true) {
			String input = in.readLine();
			if(input == null || input.trim().length() == 0)
				break;
			
			int next = Integer.parseInt(input.trim());
			arr[++right] = next;
			
			out.append(median(arr,left,right) + "\n");
			//System.out.println("-");
			//break;
		}
		
		out.close();
		in.close();
	}
	
	public static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static int partition(int[] arr, int left, int right, int pivot) {
		int pivotValue = arr[pivot];
		swap(arr, pivot, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(arr[i] < pivotValue) {
				swap(arr, storeIndex, i);
				storeIndex++;
			}
		}
		swap(arr, right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}	
	
	public static int quickSelect(int[] arr, int left, int right, int n) {
		if(left == right) {
  			return arr[left];
  		}
  		
  		while(true) {
  			int pivotIndex = (left + right) / 2;
  			pivotIndex = partition(arr, left, right, pivotIndex);
  			
  			if(n == pivotIndex) {
  				return arr[n];
  			} else if(n < pivotIndex) {
  				right = pivotIndex - 1;
  			} else {
  				left = pivotIndex + 1;
  			}
  		}
	}
	
	public static int median(int arr[], int left, int right) {
		if((right-left + 1)%2 == 1)
			return quickSelect(arr,left,right, (left + right)/2);
		else
			return (
					quickSelect(arr,left,right, (left+right)/2)
					+ quickSelect(arr,left,right, ((left+right)/2)+1)
					) / 2;
	}

}
