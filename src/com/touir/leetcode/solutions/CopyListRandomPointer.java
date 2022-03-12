package com.touir.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

import com.touir.leetcode.Solution;

public class CopyListRandomPointer extends Solution {

	/*
	 * problem: 138. Copy List with Random Pointer
	 *
	 * url: https://leetcode.com/problems/copy-list-with-random-pointer/
	 */

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node original = head, result = new Node(0), cursor = result;

		Map<Node, Node> exists = new HashMap<Node, Node>();
		while (original != null) {
			cursor.next = new Node(original.val);
			exists.put(original, cursor.next);
			original = original.next;
			cursor = cursor.next;
		}
		original = head;
		cursor = result;
		while (original != null) {
			cursor.next.random = exists.getOrDefault(original.random, null);
			original = original.next;
			cursor = cursor.next;
		}

		return result.next;
	}

	@Override
	public void test() {
		System.out.println("result: "
				+ this.copyRandomList(new Node(new Object[] { 7, null }, new Object[] { 13, 7 }, new Object[] { 11, 1 },
						new Object[] { 10, 11 }, new Object[] { 1, 7 }))
				+ ", expected: [[7,null],[13,7],[11,1],[10,11],[1,7]]");
		System.out
				.println("result: "
						+ this.copyRandomList(new Node(new Object[] { 3, null }, new Object[] { 3, 3 },
								new Object[] { 11, 1 }, new Object[] { 10, 11 }, new Object[] { 1, 7 }))
						+ ", expected: [[3,null],[3,0],[3,null]]");
	}

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}

		Node(Object[]... vals) {
			Map<Integer, Node> map = new HashMap<Integer, Node>();
			Node pointer = this;
			for (int i = 0; i < vals.length; i++) {
				if (i == 0) {
					pointer.val = (int) vals[0][0];
				} else {
					pointer.next = new Node((int) vals[i][0]);
					pointer = pointer.next;
				}
				map.put(pointer.val, pointer);
			}
			pointer = this;
			for (int i = 0; i < vals.length; i++) {
				if (vals[i][1] != null) {
					pointer.random = map.get(vals[i][1]);
				}
				pointer = pointer.next;
			}
		}

		@Override
		public String toString() {
			String result = "";
			Node pointer = this;
			while (pointer != null) {
				result += ((result != "") ? "," : "") + "[" + pointer.val + ","
						+ (pointer.random != null ? pointer.random.val : "null") + "]";
				pointer = pointer.next;
			}
			return "[" + result + "]";
		}
	}

}
