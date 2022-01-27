package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class LongestPalindromicSubstr extends Solution {

	/**
	 * problem: 5. Longest Palindromic Substring
	 *
	 * url: https://leetcode.com/problems/longest-palindromic-substring/
	 */

	public String longestPalindrome(String s) {
		if (s.length() <= 1)
			return s;

		int maxRight = s.length() - 1, left = 0, right = 0, mid = 0, bestLength = 1, bestLeft = 0, len = 0;

		while (mid < s.length()) {
			left = mid;
			right = mid;

			while (right < maxRight && s.charAt(right + 1) == s.charAt(right))
				right++;

			while (left > 0 && right < maxRight && s.charAt(left - 1) == s.charAt(right + 1)) {
				left--;
				right++;
			}
			len = right - left + 1;
			if (bestLength < len) {
				bestLength = len;
				bestLeft = left;
			}
			mid++;
		}
		return s.substring(bestLeft, bestLeft + bestLength);
	}

	@Override
	public void test() {
		System.out.println("result: " + this.longestPalindrome("babad") + ", expected: aba or bab");
		System.out.println("result: " + this.longestPalindrome("cbbd") + ", expected: bb");
		System.out.println("result: " + this.longestPalindrome("aacabdkacaa") + ", expected: aca");
		System.out.println("result: " + this.longestPalindrome("bb") + ", expected: bb");
	}

}
