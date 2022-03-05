package com.touir.leetcode.solutions;

import java.util.Arrays;

import com.touir.leetcode.Solution;

public class DeleteAndEarn extends Solution {

	/*
	 * problem: 740. Delete and Earn
	 *
	 * url: https://leetcode.com/problems/delete-and-earn/
	 */

	int[] dp;

	public int deleteAndEarn(int[] nums) {
		dp = new int[20001];
		for (int i = 0; i < dp.length; i++)
			dp[i] = -1;
		Arrays.sort(nums);
		return score(nums, 0);
	}

	public int score(int[] nums, int index) {
		if (index >= nums.length)
			return 0;
		if (dp[index] != -1)
			return dp[index];
		int score = nums[index];
		int i = index + 1;
		while (i < nums.length && nums[i] == nums[index]) {
			score += nums[index];
			i++;
		}
		while (i < nums.length && nums[index] + 1 == nums[i])
			i++;
		return (dp[index] = Math.max(score + score(nums, i), score(nums, index + 1)));
	}

	@Override
	public void test() {
		System.out.println("result: " + this.deleteAndEarn(new int[] { 3, 4, 2 }) + ", expected: 6");
		System.out.println("result: " + this.deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }) + ", expected: 9");
	}

}
