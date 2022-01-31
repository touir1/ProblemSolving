package com.touir.leetcode.solutions;

import java.util.Map;

import com.touir.leetcode.Solution;

public class BurstBalloons extends Solution {

	/**
	 * problem: 312. Burst Balloons
	 *
	 * url: https://leetcode.com/problems/burst-balloons/
	 */

	int[] nums;
	boolean[] burst;
	Map<String, Integer> memo;

	public int maxCoins(int[] nums) {
		burst = new boolean[nums.length];
		this.nums = nums;
		return maxCoins();
	}

	public int maxCoins() {
		int max = 0;
		int current = nums[0] * (nums.length > 1 ? nums[1] : 1);
		burst[0] = true;
		max = current + maxCoins();
		burst[0] = false;

		for (int i = 1; i < burst.length - 1; i++) {
			if (burst[i])
				continue;
			burst[i] = true;
			current = (nums[i - 1] * nums[i] * nums[i + 1]) + maxCoins();
			burst[i] = false;
			if (current > max)
				max = current;
		}
		if (nums.length > 1) {
			burst[nums.length - 1] = true;
			current = (nums[nums.length - 2] * nums[nums.length - 1]) + maxCoins();
			burst[nums.length - 1] = false;
			if (current > max)
				max = current;
		}
		return max;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.maxCoins(new int[] { 3, 1, 5, 8 }) + "expected: 167");
		System.out.println("result: " + this.maxCoins(new int[] { 1, 5 }) + "expected: 10");
	}

}
