package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class AddDigits extends Solution {

	/**
	 * problem: 258. Add Digits
	 *
	 * url: https://leetcode.com/problems/add-digits/
	 */

	public int addDigits(int num) {
		return (num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9);
	}

	@Override
	public void test() {
		System.out.println("result: " + this.addDigits(38) + ", expected: 2");
		System.out.println("result: " + this.addDigits(0) + ", expected: 0");
	}

}
