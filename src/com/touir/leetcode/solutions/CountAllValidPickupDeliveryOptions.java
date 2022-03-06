package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class CountAllValidPickupDeliveryOptions extends Solution {

	/**
	 * problem: 1359. Count All Valid Pickup and Delivery Options
	 *
	 * url:
	 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
	 */

	public int countOrders(int n) {
		if (n == 1)
			return 1;
		long result = 1;
		while (n > 1) {
			result *= n * (2 * n - 1);
			result %= 1000000007;
			n--;
		}
		return (int) result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.countOrders(1) + ", expected: 1");
		System.out.println("result: " + this.countOrders(2) + ", expected: 6");
		System.out.println("result: " + this.countOrders(3) + ", expected: 90");
	}

}
