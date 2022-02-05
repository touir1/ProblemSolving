package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class MergeKSortedLists extends Solution {

	/**
	 * problem: 23. Merge k Sorted Lists
	 *
	 * url: https://leetcode.com/problems/merge-k-sorted-lists/
	 */

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode[] pointers = new ListNode[lists.length];
		for (int i = 0; i < lists.length; i++) {
			pointers[i] = lists[i];
		}
		boolean empty = false;
		ListNode result = null, pointer = null;
		List<Integer> minIndexes = new ArrayList<Integer>();
		int minVal;
		while (!empty) {
			minVal = Integer.MAX_VALUE;
			empty = true;
			for (int i = 0; i < pointers.length; i++) {
				if (pointers[i] == null)
					continue;
				empty = false;
				if (pointers[i].val < minVal) {
					minVal = pointers[i].val;
					minIndexes.clear();
					minIndexes.add(i);
				} else if (pointers[i].val == minVal)
					minIndexes.add(i);
			}
			if (empty)
				break;
			for (int i = 0; i < minIndexes.size(); i++) {
				if (result == null) {
					result = new ListNode(pointers[minIndexes.get(i)].val);
					pointer = result;
				} else {
					pointer.next = new ListNode(pointers[minIndexes.get(i)].val);
					pointer = pointer.next;
				}
				pointers[minIndexes.get(i)] = pointers[minIndexes.get(i)].next;
			}
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: "
				+ this.mergeKLists(new ListNode[] { new ListNode(1, new ListNode(4, new ListNode(5))),
						new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6)) })
				+ ", expected: 1->1->2->3->4->4->5->6");

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

		@Override
		public String toString() {
			return val + (next != null ? "->" + next : "");
		}
	}
}
