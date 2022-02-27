package com.touir.leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

import com.touir.leetcode.Solution;

public class MaximumWidthBinaryTree extends Solution {

	/**
	 * problem: 662. Maximum Width of Binary Tree
	 *
	 * url: https://leetcode.com/problems/maximum-width-of-binary-tree/
	 */

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int maxWidth = 0;
		Deque<Object[]> queue = new ArrayDeque<Object[]>();
		queue.add(new Object[] { root, 0 });
		while (!queue.isEmpty()) {
			int size = queue.size(), start = (int) queue.peekFirst()[1], end = (int) queue.peekLast()[1];
			maxWidth = Math.max(maxWidth, start - end + 1);
			while (size-- > 0) {
				Object[] c = queue.poll();
				TreeNode node = (TreeNode) c[0];
				int idx = (int) c[1];
				if (node.right != null)
					queue.add(new Object[] { node.right, 2 * idx + 2 });
				if (node.left != null)
					queue.add(new Object[] { node.left, 2 * idx + 1 });
			}
		}
		return maxWidth;
	}

	@Override
	public void test() {
		System.out.println(
				"result: " + this.widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)),
						new TreeNode(2, null, new TreeNode(9)))) + ", expected: 4");
		System.out.println("result: "
				+ this.widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), null))
				+ ", expected: 2");
		System.out.println("result: "
				+ this.widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2)))
				+ ", expected: 2");
		System.out
				.println("result: "
						+ this.widthOfBinaryTree(
								new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
										new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7)))))
						+ ", expected: 8");
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
