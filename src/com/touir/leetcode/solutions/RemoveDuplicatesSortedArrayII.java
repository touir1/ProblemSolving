package com.touir.leetcode.solutions;

import java.util.Arrays;

import com.touir.leetcode.Solution;

public class RemoveDuplicatesSortedArrayII extends Solution {

	/**
	 * problem: 80. Remove Duplicates from Sorted Array II
	 *
	 * url: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	 */

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;

		int pointer = 1;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[pointer] || nums[pointer - 1] != nums[pointer]) {

				nums[++pointer] = nums[i];
			}
		}
		return pointer + 1;
	}

	@Override
	public void test() {
		int[] input = new int[] { 1, 1, 1, 2, 2, 3 };
		System.out.println("result: k=" + this.removeDuplicates(input) + ", nums=" + Arrays.toString(input)
				+ ", expected: 5, [1,1,2,2,3,_]");
		input = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println("result: k=" + this.removeDuplicates(input) + ", nums=" + Arrays.toString(input)
				+ ", expected: 7, [0,0,1,1,2,3,3,_,_]");
	}

}
