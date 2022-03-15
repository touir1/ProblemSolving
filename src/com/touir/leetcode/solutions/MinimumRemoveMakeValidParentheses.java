package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class MinimumRemoveMakeValidParentheses extends Solution {

	/*
	 * problem: 1249. Minimum Remove to Make Valid Parentheses
	 *
	 * url: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
	 */

	public String minRemoveToMakeValid(String s) {
		int count = 0, len = s.length(), i;
		char[] chars = s.toCharArray();
		for (i = 0; i < len; i++) {
			if (chars[i] == '(')
				count++;
			else if (chars[i] == ')') {
				if (count == 0)
					chars[i] = '*';
				else
					count--;
			}
		}
		i = len - 1;
		while (count-- > 0) {
			while (chars[i] != '(')
				i--;
			chars[i] = '*';
		}

		count = 0;
		for (i = 0; i < len; i++)
			if (chars[i] != '*')
				chars[count++] = chars[i];
		return new String(chars,0,count);
	}

	@Override
	public void test() {
		System.out.println("result: " + this.minRemoveToMakeValid("lee(t(c)o)de)") + ", expected: lee(t(c)o)de");
		System.out.println("result: " + this.minRemoveToMakeValid("a)b(c)d") + ", expected: ab(c)d");
		System.out.println("result: " + this.minRemoveToMakeValid("))((") + ", expected: ");
		System.out.println("result: " + this.minRemoveToMakeValid("())()(((") + ", expected: ()()");
	}

}
