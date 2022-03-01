package com.touir.leetcode.solutions;

import java.util.Arrays;

import com.touir.leetcode.Solution;

public class CountingBits extends Solution {

	/**
	 * problem: 338. Counting Bits
	 *
	 * url: https://leetcode.com/problems/counting-bits/
	 */

	public int[] countBits(int n) {
		int[] result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			result[i] = result[i / 2] + i % 2;
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + Arrays.toString(this.countBits(2)) + ", expected: [0,1,1]");
		System.out.println("result: " + Arrays.toString(this.countBits(5)) + ", expected: [0,1,1,2,1,2]");

	}

}
