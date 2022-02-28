package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class SummaryRanges extends Solution {

	/**
	 * problem: 228. Summary Ranges
	 *
	 * url: https://leetcode.com/problems/summary-ranges/
	 */

	public List<String> summaryRanges(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<String>();
		List<String> result = new ArrayList<String>();

		int start = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - 1 != nums[i - 1]) {
				if (start != i - 1) {
					result.add(nums[start] + "->" + nums[i - 1]);
				} else {
					result.add("" + nums[start]);
				}
				start = i;
			}
		}
		if (start != nums.length - 1)
			result.add(nums[start] + "->" + nums[nums.length - 1]);
		else
			result.add("" + nums[start]);
		return result;
	}

	@Override
	public void test() {
		System.out
				.println("result: " + this.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }) + ", expected: 0->2, 4->5, 7");
		System.out.println(
				"result: " + this.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }) + ", expected: 0, 2->4, 6, 8->9");
	}

}
