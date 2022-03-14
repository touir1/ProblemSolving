package com.touir.leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

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
		int len = path.length(), i = -1, begin;
		Deque<String> queue = new ArrayDeque<String>();
		while (i < len) {
			i++;
			begin = i;
			while (i < len && path.charAt(i) != '/') {
				i++;
			}
			String s = path.substring(begin, i);
			if (s.equals(".") || s.isEmpty())
				continue;
			if (s.equals("..")) {
				if (!queue.isEmpty())
					queue.pollLast();
			} else {
				queue.add(s);
			}
		}
		if (queue.isEmpty())
			return "/";
		StringBuilder result = new StringBuilder();
		while (!queue.isEmpty()) {
			result.append("/").append(queue.pollFirst());
		}
		return result.toString();
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
