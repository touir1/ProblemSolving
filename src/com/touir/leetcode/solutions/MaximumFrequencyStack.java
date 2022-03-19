package com.touir.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.touir.leetcode.Solution;

public class MaximumFrequencyStack extends Solution {

	/*
	 * problem: 895. Maximum Frequency Stack
	 *
	 * url: https://leetcode.com/problems/maximum-frequency-stack/
	 */

	class FreqStack {
		Map<Integer, Integer> count;
		Map<Integer, Stack<Integer>> occurences;
		int maxOccurence;

		public FreqStack() {
			this.maxOccurence = 0;
			this.count = new HashMap<>();
			this.occurences = new HashMap<>();
		}

		public void push(int val) {
			int freq = this.count.getOrDefault(val, 0) + 1;
			this.count.put(val, freq);
			if (freq > maxOccurence) {
				maxOccurence = freq;
				Stack<Integer> stack = new Stack<>();
				stack.push(val);
				this.occurences.put(freq, stack);
			} else
				this.occurences.get(freq).push(val);
		}

		public int pop() {
			Stack<Integer> stack = this.occurences.get(maxOccurence);
			int value = stack.pop();
			this.count.compute(value, (k, v) -> v - 1);

			if (stack.isEmpty())
				maxOccurence--;

			return value;
		}
	}

	@Override
	public void test() {
		// ["FreqStack","push","push","push","push","push","push","pop","push","pop","push","pop","push","pop","push","pop","pop","pop","pop","pop","pop"]
		// [[],[4],[0],[9],[3],[4],[2],[],[6],[],[1],[],[1],[],[4],[],[],[],[],[],[]]
		FreqStack s = new FreqStack();
		s.push(4);
		s.push(0);
		s.push(9);
		s.push(3);
		s.push(4);
		s.push(2);
		System.out.println(s.pop());
		s.push(6);
		System.out.println(s.pop());
		s.push(1);
		System.out.println(s.pop());
		s.push(1);
		System.out.println(s.pop());
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}
