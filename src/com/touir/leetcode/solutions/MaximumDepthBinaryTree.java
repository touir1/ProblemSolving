package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class MaximumDepthBinaryTree extends Solution {

	/**
	 * problem: 104. Maximum Depth of Binary Tree
	 *
	 * url: https://leetcode.com/problems/maximum-depth-of-binary-tree/
	 */

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	@Override
	public void test() {
		System.out.println("result: "
				+ this.maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))
				+ ", expected: 3");
		System.out.println("result: " + this.maxDepth(new TreeNode(1, null, new TreeNode(2))) + ", expected: 2");
	}

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
