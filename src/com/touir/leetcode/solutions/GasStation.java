package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class GasStation extends Solution {

	/**
	 * problem: 134. Gas Station
	 *
	 * url: https://leetcode.com/problems/gas-station/
	 */

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int pos = 0, current = 0, n = gas.length, total = 0;
		for (int i = 0; i < n; i++) {
			current += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (current < 0) {
				pos = i + 1;
				current = 0;
			}

		}
		if (total < 0)
			return -1;
		return pos;
	}

	@Override
	public void test() {
		System.out.println("result: "
				+ this.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }) + ", expected: 3");
		System.out.println(
				"result: " + this.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }) + ", expected: -1");
		System.out.println("result: " + this.canCompleteCircuit(new int[] { 5, 8, 2, 8 }, new int[] { 6, 5, 6, 6 })
				+ ", expected: 3");

	}

}
