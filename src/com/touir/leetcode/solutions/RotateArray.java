package com.touir.leetcode.solutions;

import java.util.Arrays;

import com.touir.leetcode.Solution;

public class RotateArray extends Solution {

	/**
	 * problem: 189. Rotate Array
	 *
	 * url: https://leetcode.com/problems/rotate-array/
	 */

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		if (k == 0)
			return;

		int n = nums.length;

		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
	}

	public void reverse(int[] nums, int left, int right) {
		int pivot;
		while (left < right) {
			pivot = nums[right];
			nums[right] = nums[left];
			nums[left] = pivot;
			left++;
			right--;
		}
	}

	@Override
	public void test() {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		this.rotate(input, 3);
		System.out.println("result: " + Arrays.toString(input) + ", expected: [5, 6, 7, 1, 2, 3, 4]");
		input = new int[] { -1, -100, 3, 99 };
		this.rotate(input, 2);
		System.out.println("result: " + Arrays.toString(input) + ", expected: [3, 99, -1, -100]");
	}

}
