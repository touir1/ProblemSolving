package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class IsSubsequence extends Solution {

	/*
	 * problem: 392. Is Subsequence
	 *
	 * url: https://leetcode.com/problems/is-subsequence/
	 */

	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		if (s.length() > t.length())
			return false;
		int counter = 0;
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(counter) == t.charAt(i))
				counter++;
			if (counter == s.length())
				return true;
			if (i + s.length() - counter > t.length())
				return false;
		}
		return false;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.isSubsequence("abc", "ahbgdc") + ", expected: true");
		System.out.println("result: " + this.isSubsequence("axc", "ahbgdc") + ", expected: false");

	}

}
