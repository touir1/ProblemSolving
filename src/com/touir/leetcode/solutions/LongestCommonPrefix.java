package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class LongestCommonPrefix extends Solution {

	/**
	 * problem: 14. Longest Common Prefix
	 *
	 * url: https://leetcode.com/problems/longest-common-prefix/
	 */

	public String longestCommonPrefix(String[] strs) {
		String result = strs[0];

		for (int i = 1; i < strs.length; i++) {
			if (result.length() > strs[i].length())
				result = result.substring(0, strs[i].length());
			if (!result.equals(strs[i])) {
				for (int j = 0; j < result.length(); j++) {
					if (result.charAt(j) != strs[i].charAt(j)) {
						result = result.substring(0, j);
						break;
					}
				}
			}
		}

		return result;
	}

	@Override
	public void test() {
		System.out.println(
				"result: " + this.longestCommonPrefix(new String[] { "flower", "flow", "flight" }) + ", expected: fl");
		System.out.println(
				"result: " + this.longestCommonPrefix(new String[] { "dog", "racecar", "car" }) + ", expected: ");
	}
}
