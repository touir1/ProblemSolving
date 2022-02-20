package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class RemoveCoveredIntervals extends Solution {

	/**
	 * problem: 1288. Remove Covered Intervals
	 *
	 * url: https://leetcode.com/problems/remove-covered-intervals/
	 */

	private boolean checkIfCovered(int idx, int[][] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			if (i != idx && intervals[idx][0] >= intervals[i][0] && intervals[idx][1] <= intervals[i][1])
				return true;
		}
		return false;
	}

	public int removeCoveredIntervals(int[][] intervals) {
		int result = intervals.length, n = intervals.length;
		for (int i = 0; i < n; i++) {
			if (checkIfCovered(i, intervals))
				result--;
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } })
				+ ", expected: 2");
		System.out.println(
				"result: " + this.removeCoveredIntervals(new int[][] { { 1, 4 }, { 2, 3 } }) + ", expected: 1");
		System.out.println("result: " + this.removeCoveredIntervals(new int[][] { { 1, 2 }, { 1, 4 }, { 3, 4 } })
				+ ", expected: 1");
	}

}
