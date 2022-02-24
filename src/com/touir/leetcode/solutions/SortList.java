package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class SortList extends Solution {

	/**
	 * problem: 148. Sort List
	 *
	 * url: https://leetcode.com/problems/sort-list/
	 */

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		int[] values = new int[100001 * 2];
		int idx = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		ListNode pointer = head;
		while (pointer != null) {
			values[pointer.val + 100000]++;
			min = Math.min(min, pointer.val + 100000);
			max = Math.max(max, pointer.val + 100000);
			pointer = pointer.next;
		}
		pointer = head;
		idx = min;
		while (pointer != null) {
			while (idx < max && values[idx] == 0)
				idx++;
			if (values[idx] != 0) {
				values[idx]--;
				pointer.val = idx - 100000;
				pointer = pointer.next;
			}
		}
		return head;
	}

	@Override
	public void test() {
		System.out
				.println("result: " + this.sortList(new ListNode(new int[] { 4, 2, 1, 3 })) + ", expected: 1->2->3->4");
		System.out.println(
				"result: " + this.sortList(new ListNode(new int[] { -1, 5, 3, 4, 0 })) + ", expected: -1->0->3->4->5");
		System.out.println("result: " + this.sortList(null) + ", expected: ");
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

		ListNode(int[] values) {
			ListNode pointer = this;
			for (int i = 0; i < values.length; i++) {
				pointer.val = values[i];
				if (i < values.length - 1) {
					pointer.next = new ListNode();
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
