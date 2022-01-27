package com.touir.leetcode;

public class Solution421 extends Solution {

	/**
	 * problem: 421. Maximum XOR of Two Numbers in an Array url:
	 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
	 */

	int intBits = Integer.SIZE;

	public int findMaximumXOR(int[] nums) {
		TreeNode root = new TreeNode();
		int maxXOR = 0, xor;
		for (int num : nums) {
			addToTree(num, root);
			xor = getMaxXOR(root, num, intBits - 1);
			if (xor > maxXOR)
				maxXOR = xor;
		}

		return maxXOR;
	}

	public void addToTree(int val, TreeNode root) {
		int and;
		for (int i = intBits - 1; i >= 0; i--) {
			and = (1 << i) & val;
			if (and != 0) {
				if (root.left == null)
					root.left = new TreeNode();
				root = root.left;
			} else {
				if (root.right == null)
					root.right = new TreeNode();
				root = root.right;
			}
		}
	}

	public int getMaxXOR(TreeNode root, int val, int pos) {
		if (root == null || pos < 0)
			return 0;

		int and = ((1 << pos) & val);

		if (and > 0) {
			if (root.right != null) {
				return and | getMaxXOR(root.right, val, pos - 1);
			}
			if (root.left != null) {
				return getMaxXOR(root.left, val, pos - 1);
			}
			return 0;
		}
		if (root.left != null) {
			return (1 << pos) | getMaxXOR(root.left, val, pos - 1);
		}
		if (root.right != null) {
			return getMaxXOR(root.right, val, pos - 1);
		}
		return 0;
	}

	public class TreeNode {
		TreeNode left;
		TreeNode right;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }) + ", expected: 28");
		System.out
				.println("result: " + this.findMaximumXOR(new int[] { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 })
						+ ", expected: 127");
	}

}
