package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class Subsets extends Solution {

	/**
	 * problem: 78. Subsets
	 *
	 * url: https://leetcode.com/problems/subsets/
	 */

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		combination(0, new ArrayList<Integer>(), nums, result);
		return result;
	}

	private void combination(int index, List<Integer> now, int[] nums, List<List<Integer>> result) {
		for (int i = index; i < nums.length; i++) {
			now.add(nums[i]);
			result.add(new ArrayList<>(now));
			combination(i + 1, now, nums, result);
			now.remove(now.size() - 1);
		}
	}

	@Override
	public void test() {
		System.out.println("result: " + this.subsets(new int[] { 1, 2, 3 })
				+ ", expected: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]");
		System.out.println("result: " + this.subsets(new int[] { 0 }) + ", expected: [[],[0]]");
	}

}
