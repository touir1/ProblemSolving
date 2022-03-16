package com.touir.leetcode.solutions;

import java.util.Stack;

import com.touir.leetcode.Solution;

public class ValidateStackSequences extends Solution {

	/*
	 * problem: 946. Validate Stack Sequences
	 *
	 * url: https://leetcode.com/problems/validate-stack-sequences/
	 */

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int lenU = pushed.length, lenO = popped.length;
		if (lenU < lenO)
			return false;
		if (lenO == 0 || lenU == 0)
			return true;
		Stack<Integer> stack = new Stack<>();
		stack.push(pushed[0]);
		int idx = 1;

		for (int i = 0; i < lenO; i++) {
			while (idx < lenU && (stack.isEmpty() || popped[i] != stack.peek()))
				stack.push(pushed[idx++]);
			if (idx > lenU || popped[i] != stack.peek())
				return false;
			stack.pop();
		}
		return true;
	}

	@Override
	public void test() {
		System.out.println(
				"result: " + this.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 })
						+ ", expected: true");
		System.out.println(
				"result: " + this.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 })
						+ ", expected: false");
	}

}
