package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class ArithmeticSlices extends Solution {

	/**
	 * problem: 413. Arithmetic Slices
	 *
	 * url: https://leetcode.com/problems/arithmetic-slices/
	 */

	public int numberOfArithmeticSlices(int[] nums) {
		if (nums.length < 3)
			return 0;
		int result = 0;
		int count = 0;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				count++;
				result += count;
			} else
				count = 0;
		}

		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }) + ", expected: 3");
		System.out.println("result: " + this.numberOfArithmeticSlices(new int[] { 1 }) + ", expected: 0");

	}

}
