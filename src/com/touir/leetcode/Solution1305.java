package com.touir.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1305 extends Solution {

	// problem:
	// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> s1 = new Stack<TreeNode>(), s2 = new Stack<TreeNode>();

		TreeNode c1 = root1, c2 = root2;

		while (!s1.isEmpty() || !s2.isEmpty() || c1 != null || c2 != null) {
			while (c1 != null) {
				s1.push(c1);
				c1 = c1.left;
			}
			while (c2 != null) {
				s2.push(c2);
				c2 = c2.left;
			}

			if (!s1.isEmpty() && !s2.isEmpty()) {
				if (s1.peek().val <= s2.peek().val) {
					c1 = s1.pop();
					result.add(c1.val);
					c1 = c1.right;
				} else {
					c2 = s2.pop();
					result.add(c2.val);
					c2 = c2.right;
				}
			} else if (!s1.isEmpty()) {
				c1 = s1.pop();
				result.add(c1.val);
				c1 = c1.right;
			} else if (!s2.isEmpty()) {
				c2 = s2.pop();
				result.add(c2.val);
				c2 = c2.right;
			}

		}

		return result;
	}

	@Override
	public void test() {
		TreeNode r1 = null, r2 = null;

		r1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
		r2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
		System.out.println("params: r1=[1, 2, 4] && r2=[0, 1, 3], result: " + this.getAllElements(r1, r2)
				+ ", expected: [0, 1, 1, 2, 3, 4]");
		r1 = new TreeNode(1, null, new TreeNode(8));
		r2 = new TreeNode(8, new TreeNode(1), null);
		System.out.println("params: r1=[1, null, 8] && r2=[8, 1], result: " + this.getAllElements(r1, r2)
				+ ", expected: [1, 1, 8, 8]");

	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
