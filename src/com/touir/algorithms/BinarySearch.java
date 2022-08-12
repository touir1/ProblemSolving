package com.touir.algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = new int[] {1,3,11,23,42,54,59,67,70,73,75,80,81,83,87,92};
		
		// we're looking for the element 59 in the array
		int value = 59;
		int found = -1;
		// initializing left = 0 and right = size of array
		int left = 0, right = array.length -1;
		int pivot;
		
		// continue while left <= right and value not found
		while(left <= right) {
			pivot = (left+right)/2;
			
			if(array[pivot] == value) {
				found = pivot;
				break;
			}
			
			if(array[pivot] > value)
				right = pivot - 1;
			else
				left = pivot + 1;
		}
		
		// check if the element is found
		if(found != -1)
			System.out.println("Element found at index: "+ found);
		else
			System.out.println("Element was not found");
		
		// using the function to find the value 59
		found = search(array,array.length, 59);
		
		// check if the element is found
		if(found != -1)
			System.out.println("Element found at index: "+ found);
		else
			System.out.println("Element was not found");
		
		// using the function to find the value 60
		found = search(array,array.length, 60);
		
		// check if the element is found
		if(found != -1)
			System.out.println("Element found at index: "+ found);
		else
			System.out.println("Element was not found");
		
	}
	
	public static int search(int[] array, int length, int element) {
	    int left = 0, right = length - 1;
	    int pivot;
	    
	    while(left <= right) {
	    	pivot = (left + right) / 2;
	    	
	    	if(array[pivot] == element) {
				return pivot;
			}
			
			if(array[pivot] > element)
				right = pivot - 1;
			else
				left = pivot + 1;
	    }
		
	    return -1;
	}

}
