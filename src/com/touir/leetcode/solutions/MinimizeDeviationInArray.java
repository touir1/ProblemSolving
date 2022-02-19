package com.touir.leetcode.solutions;

import java.util.TreeSet;

import com.touir.leetcode.Solution;

public class MinimizeDeviationInArray extends Solution {

	/**
	 * problem: 1675. Minimize Deviation in Array
	 *
	 * url: https://leetcode.com/problems/minimize-deviation-in-array/
	 */

	public int minimumDeviation(int[] nums) {
		TreeSet<Integer> tree = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				tree.add(nums[i]);
			} else {
				tree.add(nums[i] * 2);
			}
		}

		// max - min
		int min = tree.first();
		int max = tree.last();
		int result = max - min;

		while (max % 2 == 0 && result != 0) {
			tree.remove(max);
			tree.add(max / 2);
			min = tree.first();
			max = tree.last();
			result = Math.min(result, max - min);
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.minimumDeviation(new int[] { 1, 2, 3, 4 }) + ", expected: 1");
		System.out.println("result: " + this.minimumDeviation(new int[] { 4, 1, 5, 20, 3 }) + ", expected: 3");
		System.out.println("result: " + this.minimumDeviation(new int[] { 2, 10, 8 }) + ", expected: 3");
	}

}
