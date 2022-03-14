package com.touir.leetcode.solutions;

import java.util.Stack;

import com.touir.leetcode.Solution;

public class SimplifyPath extends Solution {

	/*
	 * problem: 71. Simplify Path
	 *
	 * url: https://leetcode.com/problems/simplify-path/
	 */

	public String simplifyPath(String path) {
		if (path.length() <= 1)
			return path;
		String temp = "";
		int countP = 0;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < path.length(); i++) {
			char curr = path.charAt(i);
			if (curr != '.' && curr != '/') {
				if (countP != 0)
					for (; countP > 0; countP--)
						temp += '.';
				temp += curr;
				countP = 0;
			} else if (curr == '/') {
				if (countP == 1)
					countP = 0;
				if (countP == 2) {
					if (!stack.isEmpty())
						stack.pop();
					countP = 0;
				} else if (temp != "") {
					stack.push(temp);
					temp = "";
				}
			} else {
				if (temp == "")
					countP++;
				else {
					temp += '.';
				}
			}
		}
		if (temp != "") {
			if (countP != 0 && temp.charAt(temp.length() - 1) != '.') {
				for (; countP > 0; countP--)
					temp += '.';
			}
			stack.push(temp);
		} else {
			if (countP == 2) {
				if (!stack.isEmpty())
					stack.pop();
			} else if (countP >= 3) {
				for (; countP > 0; countP--)
					temp += '.';
				stack.push(temp);
			}
		}

		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}
		return result == "" ? "/" : result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.simplifyPath("/home/") + ", expected: /home");
		System.out.println("result: " + this.simplifyPath("/../") + ", expected: /");
		System.out.println("result: " + this.simplifyPath("/home//foo/") + ", expected: /home/foo");
		System.out.println("result: " + this.simplifyPath("/a/./b/../../c/") + ", expected: /c");
		System.out.println("result: " + this.simplifyPath("/a//b////c/d//././/..") + ", expected: /a/b/c");
		System.out.println("result: " + this.simplifyPath("/...") + ", expected: /...");
		System.out.println("result: " + this.simplifyPath("/..hidden") + ", expected: /..hidden");
		System.out.println("result: " + this.simplifyPath("/.....hidden") + ", expected: /.....hidden");
	}

}
