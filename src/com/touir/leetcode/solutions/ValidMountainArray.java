package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class ValidMountainArray extends Solution {

	/**
	 * problem: 941. Valid Mountain Array
	 *
	 * url: https://leetcode.com/problems/valid-mountain-array/
	 */

	public boolean validMountainArray(int[] arr) {
		if (arr.length < 3)
			return false;

		boolean found = false;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i] || (found && arr[i - 1] < arr[i]) || (arr[i - 1] > arr[i] && i == 1)) {
				return false;
			}
			if (arr[i - 1] > arr[i] && !found) {
				found = true;
			}
		}
		return found;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.validMountainArray(new int[] { 2, 1 }) + ", expected: false");
		System.out.println("result: " + this.validMountainArray(new int[] { 3, 5, 5 }) + ", expected: false");
		System.out.println("result: " + this.validMountainArray(new int[] { 0, 3, 2, 1 }) + ", expected: true");
		System.out.println(
				"result: " + this.validMountainArray(new int[] { 0, 2, 3, 4, 5, 2, 1, 0 }) + ", expected: true");
		System.out.println(
				"result: " + this.validMountainArray(new int[] { 0, 2, 3, 3, 5, 2, 1, 0 }) + ", expected: false");
		System.out.println("result: " + this.validMountainArray(new int[] { 2 }) + ", expected: false");
		System.out.println(
				"result: " + this.validMountainArray(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }) + ", expected: false");
	}

}
