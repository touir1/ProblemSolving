package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class RemoveDuplicatesSortedListII extends Solution {

	/*
	 * problem: 82. Remove Duplicates from Sorted List II
	 *
	 * url: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	 */

	public ListNode deleteDuplicates(ListNode head) {
		ListNode cursor = head, last = null;
		boolean duplicate;
		while (cursor != null) {
			duplicate = false;
			while (cursor.next != null && cursor.val == cursor.next.val) {
				cursor = cursor.next;
				duplicate = true;
			}

			if (duplicate) {
				if (last != null)
					last.next = cursor.next;
				else
					head = cursor.next;
			} else
				last = cursor;
			cursor = cursor.next;

		}
		return head;
	}

	@Override
	public void test() {
		System.out
				.println("result: " + this.deleteDuplicates(new ListNode(1, 2, 3, 3, 4, 4, 5)) + ", expected: 1->2->5");
		System.out.println("result: " + this.deleteDuplicates(new ListNode(1, 1, 1, 2, 3)) + ", expected: 2->3");
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
