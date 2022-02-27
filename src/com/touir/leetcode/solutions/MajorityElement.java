package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class MajorityElement extends Solution {

	/**
	 * problem: 169. Majority Element
	 *
	 * url: https://leetcode.com/problems/majority-element/
	 */

	public int majorityElement(int[] nums) {
		// Boyer Moore Majority Vote Algorithm
		int count = 1;
		int current = nums[0];
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			if (current != nums[i])
				count--;
			else
				count++;
			if (count <= 0) {
				count = 1;
				current = nums[i];
			}
			if (count > n / 2)
				return current;
		}
		return current;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.majorityElement(new int[] { 3, 2, 3 }) + ", expected: 3");
		System.out.println("result: " + this.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }) + ", expected: 2");
		System.out.println("result: " + this.majorityElement(new int[] { 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2 })
				+ ", expected: 1");
	}

}
