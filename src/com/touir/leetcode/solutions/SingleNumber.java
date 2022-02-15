package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class SingleNumber extends Solution {

	/**
	 * problem: 136. Single Number
	 *
	 * url: https://leetcode.com/problems/single-number/
	 */

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.singleNumber(new int[] { 2, 2, 1 }) + ", expected: 1");
		System.out.println("result: " + this.singleNumber(new int[] { 4, 1, 2, 1, 2 }) + ", expected: 4");

	}

}
