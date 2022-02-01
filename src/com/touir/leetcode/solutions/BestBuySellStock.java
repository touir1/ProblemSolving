package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class BestBuySellStock extends Solution {

	/**
	 * problem: 121. Best Time to Buy and Sell Stock
	 *
	 * url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 */

	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;

		int low = Integer.MAX_VALUE, profit = 0;
		for (int i = 0; i < n; i++) {
			low = Math.min(low, prices[i]);
			profit = Math.max(profit, prices[i] - low);
		}
		return profit;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }) + ", expected: 5");
		System.out.println("result: " + this.maxProfit(new int[] { 7, 6, 4, 3, 1 }) + ", expected: 0");

	}

}
