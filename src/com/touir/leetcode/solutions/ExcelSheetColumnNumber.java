package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class ExcelSheetColumnNumber extends Solution {

	/**
	 * problem: 171. Excel Sheet Column Number
	 *
	 * url: https://leetcode.com/problems/excel-sheet-column-number/
	 */

	public int titleToNumber(String columnTitle) {
		int result = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			result *= 26;
			result += (columnTitle.charAt(i) - 'A' + 1);
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.titleToNumber("A") + ", expected: 1");
		System.out.println("result: " + this.titleToNumber("AB") + ", expected: 28");
		System.out.println("result: " + this.titleToNumber("ZY") + ", expected: 701");

	}

}
