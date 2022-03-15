package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class MinimumRemoveMakeValidParentheses extends Solution {

	/*
	 * problem: 1249. Minimum Remove to Make Valid Parentheses
	 *
	 * url: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
	 */

	public String minRemoveToMakeValid(String s) {
		int count = 0;
		StringBuilder result = new StringBuilder();
		int i = -1, len = s.length();
		while (++i < len) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
				result.append(c);
			} else if (c == ')') {
				if (count > 0) {
					count--;
					result.append(c);
				}
			} else
				result.append(c);
		}
		while (count-- > 0) {
			i = result.lastIndexOf("(");
			result.deleteCharAt(i);
		}
		return result.toString();
	}

	@Override
	public void test() {
		System.out.println("result: " + this.minRemoveToMakeValid("lee(t(c)o)de)") + ", expected: lee(t(c)o)de");
		System.out.println("result: " + this.minRemoveToMakeValid("a)b(c)d") + ", expected: ab(c)d");
		System.out.println("result: " + this.minRemoveToMakeValid("))((") + ", expected: ");
		System.out.println("result: " + this.minRemoveToMakeValid("())()(((") + ", expected: ()()");
	}

}
