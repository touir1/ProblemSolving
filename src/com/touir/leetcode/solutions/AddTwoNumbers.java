package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class AddTwoNumbers extends Solution {

	/**
	 * problem: 2. Add Two Numbers
	 *
	 * url: https://leetcode.com/problems/add-two-numbers/
	 */ 

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		int rest = 0;

		ListNode pointer = result;

		do {
			if (l1 == null && l2 == null) {
				pointer.val = (rest) % 10;
				rest = (rest) / 10;
			} else if (l1 == null) {
				pointer.val = (l2.val + rest) % 10;
				rest = (l2.val + rest) / 10;
				l2 = l2.next;
			} else if (l2 == null) {
				pointer.val = (l1.val + rest) % 10;
				rest = (l1.val + rest) / 10;
				l1 = l1.next;
			} else {
				pointer.val = (l1.val + l2.val + rest) % 10;
				rest = (l1.val + l2.val + rest) / 10;
				l1 = l1.next;
				l2 = l2.next;
			}

			if (l1 != null || l2 != null || rest != 0) {
				pointer.next = new ListNode();
				pointer = pointer.next;
			}
		} while (l1 != null || l2 != null || rest != 0);

		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " 
				+ this.addTwoNumbers(new ListNode(2,4,3),new ListNode(5,6,4)) 
				+ ", expected: 7->0->8");
		System.out.println("result: " 
				+ this.addTwoNumbers(new ListNode(0), new ListNode(0)) 
				+ ", expected: 0");
		System.out.println("result: " 
				+ this.addTwoNumbers(new ListNode(9,9,9,9,9,9,9), new ListNode(9,9,9,9)) 
				+ ", expected: 8->9->9->9->0->0->0->1");

	}

	/*
	 * Definition for singly-linked list.
	 * modified slightly for testing purposes by adding 
	 * an args constructor and toString redefinition
	 */
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
		
		ListNode(int...vals){
			ListNode pointer = this;
			for(int i=0;i<vals.length;i++){
				if(i == 0) {
					pointer.val = vals[0];
				}
				else {
					pointer.next = new ListNode(vals[i]);
					pointer = pointer.next;
				}
			}
		}
		
		@Override
		public String toString() {
			String result = "";
			ListNode pointer = this;
			while(pointer != null) {
				result += ((result != "")? "->" : "") + pointer.val;
				pointer = pointer.next;
			}
			return result;
		}
	}
}
