package com.touir.algorithms;

public class LinearSearch {

	public static void main(String[] args) {
		
		int[] array = new int[] {6,8,3,4,2,5,8,11};
		
		// we're looking for the element 5 in the array
		int found = search(array, array.length, 5);
		
		// check if the element is found
		if(found != -1)
			System.out.println("Element found at index: "+ found);
		else
			System.out.println("Element was not found");
		
		// we're looking for the element 14 in the array
		found = search(array, array.length, 14);
		
		// check if the element is found
		if(found != -1)
			System.out.println("Element found at index: "+ found);
		else
			System.out.println("Element was not found");
		
	}
	
	public static int search(int[] array, int length, int element) {
		for(int i=0;i< length; i++) {
			if(array[i] == element)
				return i;
		}
		return -1;
	}

}
