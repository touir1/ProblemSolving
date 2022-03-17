package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class ScoreParentheses extends Solution {

	/*
	 * problem: 856. Score of Parentheses
	 *
	 * url: https://leetcode.com/problems/score-of-parentheses/
	 */

	public int scoreOfParentheses(String s) {
		int result = 0, brackets = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				brackets *= 2;
			if (brackets == 0)
				brackets = 1;
			if (s.charAt(i) == ')' && s.charAt(i - 1) == '(')
				result += brackets;
			if (s.charAt(i) == ')')
				brackets /= 2;
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.scoreOfParentheses("(())") + ", expected: 2");
		System.out.println("result: " + this.scoreOfParentheses("()()") + ", expected: 2");
		System.out.println("result: " + this.scoreOfParentheses("((()))") + ", expected: 4");
		System.out.println("result: " + this.scoreOfParentheses("((()))()") + ", expected: 5");
		System.out.println("result: " + this.scoreOfParentheses("(((()))())") + ", expected: 10");
		System.out.println("result: " + this.scoreOfParentheses("()()()") + ", expected: 3");
		System.out.println("result: " + this.scoreOfParentheses("(())()") + ", expected: 3");
	}

}
