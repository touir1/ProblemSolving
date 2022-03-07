package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class MergeTwoSortedLists extends Solution {

	/*
	 * problem: 21. Merge Two Sorted Lists
	 *
	 * url: https://leetcode.com/problems/merge-two-sorted-lists/
	 */

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null)
			return null;
		ListNode result = new ListNode(), cursor = result;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cursor.next = list1;
				list1 = list1.next;
			} else {
				cursor.next = list2;
				list2 = list2.next;
			}
			cursor = cursor.next;
		}
		if (list1 != null) {
			cursor.next = list1;
		}
		if (list2 != null) {
			cursor.next = list2;
		}
		return result.next;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.mergeTwoLists(new ListNode(1, 2, 4), new ListNode(1, 3, 4))
				+ ", expected: 1->1->2->3->4->4");
		System.out.println("result: " + this.mergeTwoLists(null, null) + ", expected: null");
		System.out.println("result: " + this.mergeTwoLists(null, new ListNode(0)) + ", expected: 0");
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

		ListNode(int... values) {
			if (values.length == 0)
				return;
			this.val = values[0];
			ListNode cursor = this;
			for (int i = 1; i < values.length; i++) {
				cursor.next = new ListNode(values[i]);
				cursor = cursor.next;
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
