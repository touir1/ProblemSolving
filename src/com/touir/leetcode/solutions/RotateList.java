package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class RotateList extends Solution {

	/*
	 * problem: 61. Rotate List
	 *
	 * url: https://leetcode.com/problems/rotate-list/
	 */

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		int size = 0;
		ListNode end = null;
		for (ListNode cursor = head; cursor != null; cursor = cursor.next) {
			size++;
			end = cursor;
		}

		if (k >= size)
			k %= size;
		if (k == 0)
			return head;
		end.next = head;
		while (--size - k > 0)
			head = head.next;
		end = head.next;
		head.next = null;
		return end;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.rotateRight(new ListNode(1, 2, 3, 4, 5), 2) + ", expected: 4->5->1->2->3");
		System.out.println("result: " + this.rotateRight(new ListNode(0, 1, 2), 4) + ", expected: 2->0->1");
		System.out.println("result: " + this.rotateRight(new ListNode(1, 2), 2) + ", expected: 1->2");
		System.out.println("result: " + this.rotateRight(null, 2) + ", expected: null");
		System.out.println("result: " + this.rotateRight(new ListNode(1, 2), 0) + ", expected: 1->2");
		System.out.println("result: " + this.rotateRight(new ListNode(1, 2), 9) + ", expected: 2->1");
		System.out.println("result: " + this.rotateRight(new ListNode(1, 2), 8) + ", expected: 1->2");
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		ListNode(int... vals) {
			ListNode pointer = this;
			for (int i = 0; i < vals.length; i++) {
				if (i == 0) {
					pointer.val = vals[0];
				} else {
					pointer.next = new ListNode(vals[i]);
					pointer = pointer.next;
				}
			}
		}

		@Override
		public String toString() {
			String result = "";
			ListNode pointer = this;
			while (pointer != null) {
				result += ((result != "") ? "->" : "") + pointer.val;
				pointer = pointer.next;
			}
			return result;
		}
	}

}
