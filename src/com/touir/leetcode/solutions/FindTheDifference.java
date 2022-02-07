package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class FindTheDifference extends Solution {

	/**
	 * problem: 389. Find the Difference
	 *
	 * url: https://leetcode.com/problems/find-the-difference/
	 */

	public char findTheDifference(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count -= s.charAt(i);
			count += t.charAt(i);
		}
		count += t.charAt(t.length() - 1);
		return (char) count;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.findTheDifference("abcd", "abcde") + ", expected: e");
		System.out.println("result: " + this.findTheDifference("", "y") + ", expected: y");
	}

}
