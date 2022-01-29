package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class StringToIntAtoi extends Solution {

	/**
	 * problem: 8. String to Integer (atoi)
	 *
	 * url: https://leetcode.com/problems/string-to-integer-atoi/
	 */

	public int myAtoi(String s) {
		s = s.trim();

		if (s.length() == 0)
			return 0;

		int sign = 1;
		long result = 0;

		if (s.charAt(0) == '-') {
			sign = -1;
			s = s.substring(1);
		} else if (s.charAt(0) == '+') {
			s = s.substring(1);
		}

		for (char c : s.toCharArray()) {
			if ((c < 48) || (c > 57))
				break;
			result *= 10;
			result += (c - 48);
			if (sign > 0 && result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign < 0 && result * sign < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) result * sign;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.myAtoi("42") + ", expected: 42");
		System.out.println("result: " + this.myAtoi(" -42") + ", expected: -42");
		System.out.println("result: " + this.myAtoi("4193 with words") + ", expected: 4193");
		System.out.println("result: " + this.myAtoi("9223372036854775808") + ", expected: 2147483647");
	}

}
