package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class RegexMatching extends Solution {

	/**
	 * problem: 10. Regular Expression Matching
	 *
	 * url: https://leetcode.com/problems/regular-expression-matching/
	 */

	private final char START = '#', END = '-', ANY = '.', MORE = '*', PASS = '=';
	private char[] str;

	public boolean isMatch(String s, String p) {
		str = s.toCharArray();

		GraphNode root = new GraphNode(START);
		GraphNode cursor = root, next;

		for (char c : p.toCharArray()) {
			if (c != MORE) {
				next = new GraphNode(c);
				cursor.next.add(next);
				next.parent = cursor;
				cursor = next;
			} else {
				cursor.next.add(cursor);
				next = new GraphNode(PASS);
				cursor.parent.next.add(next);
				cursor.next.add(next);
				cursor = next;
			}
		}
		cursor.next.add(new GraphNode(END));

		return traversal(root, 0);
	}

	private boolean traversal(GraphNode node, int index) {
		if (node.value == START || node.value == PASS) {
			for (GraphNode nd : node.next) {
				if (traversal(nd, index))
					return true;
			}
			return false;
		}
		if (index >= str.length) {
			if (node.value == END)
				return true;
			return false;
		}

		if (node.value == ANY || node.value == str[index]) {
			for (GraphNode nd : node.next) {
				if (traversal(nd, index + 1))
					return true;
			}
			return false;
		}

		return false;
	}

	class GraphNode {
		char value;
		List<GraphNode> next;
		GraphNode parent;

		GraphNode(char value) {
			this.next = new ArrayList<GraphNode>();
			this.value = value;
		}
	}

	@Override
	public void test() {
		System.out.println("result: " + this.isMatch("a", "a") + ", expected: true");
		System.out.println("result: " + this.isMatch("aa", "a") + ", expected: false");
		System.out.println("result: " + this.isMatch("aa", "a*") + ", expected: true");
		System.out.println("result: " + this.isMatch("ab", ".*") + ", expected: true");
		System.out.println("result: " + this.isMatch("aab", "c*a*b") + ", expected: true");
		System.out.println("result: " + this.isMatch("aaa", "a*a") + ", expected: true");
	}

}
