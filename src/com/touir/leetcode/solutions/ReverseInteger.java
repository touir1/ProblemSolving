package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class ReverseInteger extends Solution {

	/**
	 * problem: 7. Reverse Integer
	 *
	 * url: https://leetcode.com/problems/reverse-integer/
	 */

	public int reverse(int x) {
		if (x == 0)
			return 0;
		int result = 0, sign = (x > 0 ? 1 : -1);
		x = Math.abs(x);
		if (x < 0)
			return 0;
		while (x > 0) {
			if (Integer.MAX_VALUE / 10 < result
					|| (Integer.MAX_VALUE / 10 == result && x % 10 > Integer.MAX_VALUE % 10))
				return 0;
			result *= 10;
			result += x % 10;
			x /= 10;

		}
		return result * sign;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.reverse(123) + ", expected: 321");
		System.out.println("result: " + this.reverse(-123) + ", expected: -321");
		System.out.println("result: " + this.reverse(120) + ", expected: 21");
		System.out.println("result: " + this.reverse(1534236469) + ", expected: 0");
	}

}
