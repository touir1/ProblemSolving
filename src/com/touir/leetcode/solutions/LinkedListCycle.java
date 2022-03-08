package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class LinkedListCycle extends Solution {

	/*
	 * problem: 141. Linked List Cycle
	 *
	 * url: https://leetcode.com/problems/linked-list-cycle/
	 */

	public boolean hasCycle(ListNode head) {
		ListNode cursor = head;
		while (cursor != null) {
			if (cursor.val == Integer.MIN_VALUE)
				return true;
			cursor.val = Integer.MIN_VALUE;
			cursor = cursor.next;
		}
		return false;
	}

	@Override
	public void test() {
		ListNode head = new ListNode(3), cursor = head, pos;
		cursor.next = new ListNode(2);
		pos = cursor.next;
		cursor = cursor.next;
		cursor.next = new ListNode(0);
		cursor = cursor.next;
		cursor.next = new ListNode(-4);
		cursor = cursor.next;
		cursor.next = pos;
		System.out.println("result: " + this.hasCycle(head) + ", expected: true");
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		System.out.println("result: " + this.hasCycle(head) + ", expected: true");
		head = new ListNode(1);
		System.out.println("result: " + this.hasCycle(head) + ", expected: false");

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
