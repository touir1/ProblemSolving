package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class RichestCustomerWealth extends Solution {

	/**
	 * problem: 1672. Richest Customer Wealth
	 *
	 * url: https://leetcode.com/problems/richest-customer-wealth/
	 */

	public int maximumWealth(int[][] accounts) {
		int result = 0, sum;
		for (int i = 0; i < accounts.length; i++) {
			sum = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				sum += accounts[i][j];
			}
			result = Math.max(result, sum);
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.maximumWealth(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }) + ", expected: 6");
		System.out.println(
				"result: " + this.maximumWealth(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }) + ", expected: 10");
	}

}
