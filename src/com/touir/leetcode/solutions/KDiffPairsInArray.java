package com.touir.leetcode.solutions;

import java.util.Arrays;

import com.touir.leetcode.Solution;

public class KDiffPairsInArray extends Solution {

	/**
	 * problem: 532. K-diff Pairs in an Array
	 *
	 * url: https://leetcode.com/problems/k-diff-pairs-in-an-array/
	 */

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int count = 0;
		int i = 0, j = 0, n = nums.length;
		while (j < n) {
			j = i + 1;
			while (j < n && nums[j] - nums[i] < k)
				j++;
			if (j < n && nums[j] - nums[i] == k)
				count++;
			while (i + 1 < n && nums[i + 1] == nums[i])
				i++;
			i++;
		}
		return count;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.findPairs(new int[] { 3, 1, 4, 1, 5 }, 2) + ", expected: 2");
		System.out.println("result: " + this.findPairs(new int[] { 1, 2, 3, 4, 5 }, 1) + ", expected: 4");
		System.out.println("result: " + this.findPairs(new int[] { 1, 3, 1, 5, 4 }, 0) + ", expected: 1");
	}

}
