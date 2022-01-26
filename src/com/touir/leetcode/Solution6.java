package com.touir.leetcode;

public class Solution6 extends Solution {

	/**
	 *
	 * 6. Zigzag Conversion problem:
	 * https://leetcode.com/problems/zigzag-conversion/
	 *
	 */

	public String convert(String s, int numRows) {
		if (numRows == 1 || numRows > s.length())
			return s;
		String zigzag[] = new String[numRows];
		String result = "";

		int direction = -1, cursor = 0;

		for (int i = 0; i < s.length(); i++) {
			zigzag[cursor] = (zigzag[cursor] == null ? "" : zigzag[cursor]) + s.charAt(i);

			if (i % (numRows - 1) == 0)
				direction *= -1;

			cursor += direction;

		}

		for (int i = 0; i < numRows; i++) {
			result += zigzag[i];
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.convert("PAYPALISHIRING", 3) + ", expected: PAHNAPLSIIGYIR");
		System.out.println("result: " + this.convert("PAYPALISHIRING", 4) + ", expected: PINALSIGYAHRPI");
		System.out.println("result: " + this.convert("PAYPALISHIRING", 1) + ", expected: PAYPALISHIRING");
		System.out.println("result: " + this.convert("A", 2) + ", expected: A");
	}

}
