package com.touir.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

import com.touir.leetcode.Solution;

public class FourSumII extends Solution {

	/**
	 * problem: 454. 4Sum II
	 *
	 * url: https://leetcode.com/problems/4sum-ii/
	 */

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int result = 0;
		Map<Integer, Integer> sum1 = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			for (int j : nums2) {
				sum1.put(i + j, sum1.getOrDefault(i + j, 0) + 1);
			}
		}
		for (int i : nums3) {
			for (int j : nums4) {
				result += sum1.getOrDefault(-(i + j), 0);
			}
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: "
				+ this.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 })
				+ ", expectecd: 2");
		System.out.println(
				"result: " + this.fourSumCount(new int[] { 0 }, new int[] { 0 }, new int[] { 0 }, new int[] { 0 })
						+ ", expectecd: 1");
	}

}
