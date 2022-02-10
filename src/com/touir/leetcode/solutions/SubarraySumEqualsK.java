package com.touir.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

import com.touir.leetcode.Solution;

public class SubarraySumEqualsK extends Solution {

	/**
	 * problem: 560. Subarray Sum Equals K
	 *
	 * url: https://leetcode.com/problems/subarray-sum-equals-k/
	 */

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(0, 1);
		for (int num : nums) {
			sum += num;
			count += map.getOrDefault(sum - k, 0);
			map.compute(sum, (key, value) -> value == null ? 1 : value + 1);
		}
		return count;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.subarraySum(new int[] { 1, 1, 1 }, 2) + ", expected: 2");
		System.out.println("result: " + this.subarraySum(new int[] { 1, 2, 3 }, 3) + ", expected: 2");
	}

}
