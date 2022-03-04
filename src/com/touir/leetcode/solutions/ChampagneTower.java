package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class ChampagneTower extends Solution {

	/*
	 * problem: 799. Champagne Tower
	 *
	 * url: https://leetcode.com/problems/champagne-tower/
	 */

	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[101][101];
		dp[0][1] = poured;
		for (int i = 0; i <= query_row; i++) {
			for (int j = 0; j <= i + 1; j++) {
				if (dp[i][j] > 1) {
					dp[i + 1][j] += (dp[i][j] - 1) / 2;
					dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
				}
			}
		}
		return Math.min(dp[query_row][query_glass + 1], 1);
	}

	@Override
	public void test() {
		System.out.println("result: " + this.champagneTower(1, 1, 1) + ", expected: 0.00000");
		System.out.println("result: " + this.champagneTower(2, 1, 1) + ", expected: 0.50000");
		System.out.println("result: " + this.champagneTower(100000009, 33, 17) + ", expected: 1.00000");
	}

}
