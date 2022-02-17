package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class CombinationSum extends Solution {

	/**
	 * problem: 39. Combination Sum
	 *
	 * url: https://leetcode.com/problems/combination-sum/
	 */

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		selectElementFromIndex(0, 0, new ArrayList<>(), candidates, target, result);
		return result;
	}

	private void selectElementFromIndex(int index, int sum, List<Integer> toAdd, int[] candidates, int target,
			List<List<Integer>> result) {
		if (sum == target) {
			result.add(new ArrayList<>(toAdd));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (sum + candidates[i] <= target) {
				toAdd.add(candidates[i]);
				selectElementFromIndex(i, sum + candidates[i], toAdd, candidates, target, result);
				toAdd.remove(toAdd.size() - 1);
			}
		}
	}

	@Override
	public void test() {
		System.out.println("result: " + this.combinationSum(new int[] { 2, 3, 6, 7 }, 7) + ", expected: [[2,2,3],[7]]");
		System.out.println(
				"result: " + this.combinationSum(new int[] { 2, 3, 5 }, 8) + ", expected: [[2,2,2,2],[2,3,3],[3,5]]");
		System.out.println("result: " + this.combinationSum(new int[] { 2 }, 1) + ", expected: []");
	}

}
