package com.touir.leetcode.solutions;

import java.util.Stack;

import com.touir.leetcode.Solution;

public class RemoveKDigits extends Solution {

	/**
	 * problem: 402. Remove K Digits
	 *
	 * url: https://leetcode.com/problems/remove-k-digits/
	 */

	public String removeKdigits(String num, int k) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (k > 0 && i < num.length()) {
			int nb = num.charAt(i) - '0';
			if (!stack.isEmpty()) {
				if (stack.peek() <= nb) {
					stack.push(nb);
					i++;
				} else {
					stack.pop();
					k--;
				}
			} else {
				stack.push(nb);
				i++;
			}
		}

		while (i < num.length()) {
			stack.push(num.charAt(i) - '0');
			i++;
		}
		while (k > 0 && !stack.isEmpty()) {
			stack.pop();
			k--;
		}

		// constructing result
		String result = "";
		while (!stack.isEmpty())
			result = stack.pop() + result;
		i = 0;
		while (i < result.length() && result.charAt(i) == '0')
			i++;
		result = result.substring(i);
		return result.length() > 0 ? result : "0";

	}

	@Override
	public void test() {
		System.out.println("result: " + this.removeKdigits("1432219", 3) + ", expected: 1219");
		System.out.println("result: " + this.removeKdigits("10200", 1) + ", expected: 200");
		System.out.println("result: " + this.removeKdigits("10", 2) + ", expected: 0");
		System.out.println("result: " + this.removeKdigits("9", 1) + ", expected: 0");
		System.out.println("result: " + this.removeKdigits("112", 1) + ", expected: 11");
	}

}
