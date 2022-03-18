package com.touir.leetcode.solutions;

import java.util.Stack;

import com.touir.leetcode.Solution;

public class RemoveDuplicateLetters extends Solution {

	/*
	 * problem: 316. Remove Duplicate Letters
	 *
	 * url: https://leetcode.com/problems/remove-duplicate-letters/
	 */

	public String removeDuplicateLetters(String s) {
		boolean[] found = new boolean[26];
		int[] last = new int[26];
		Stack<Integer> stack = new Stack<>();
		int len = s.length(), i;
		for (i = 0; i < len; i++)
			last[s.charAt(i) - 'a'] = i;

		for (i = 0; i < len; i++) {
			int c = s.charAt(i) - 'a';
			if (found[c])
				continue;
			while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
				found[stack.pop()] = false;
			stack.push(c);
			found[c] = true;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append((char) (stack.pop() + 'a'));

		return sb.reverse().toString();
	}

	@Override
	public void test() {
		System.out.println("result: " + this.removeDuplicateLetters("bcabc") + ", expected: abc");
		System.out.println("result: " + this.removeDuplicateLetters("cbacdcbc") + ", expected: acdb");
	}

}
