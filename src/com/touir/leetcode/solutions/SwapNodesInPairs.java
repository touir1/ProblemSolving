package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class SwapNodesInPairs extends Solution {

	/*
	 * problem: 24. Swap Nodes in Pairs
	 *
	 * url: https://leetcode.com/problems/swap-nodes-in-pairs/
	 */

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pointer = head, tmp = head.next, last = null;
		head = pointer.next;
		while (pointer != null && pointer.next != null) {
			pointer.next = tmp.next;
			tmp.next = pointer;
			if (last != null)
				last.next = tmp;
			last = pointer;
			pointer = pointer.next;
			if (pointer != null)
				tmp = pointer.next;
		}
		return head;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.swapPairs(new ListNode(1, 2, 3, 4)) + ", expected: 2->1->4->3");
		System.out.println("result: " + this.swapPairs(null) + ", expected: null");
		System.out.println("result: " + this.swapPairs(new ListNode(1)) + ", expected: 1");
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
