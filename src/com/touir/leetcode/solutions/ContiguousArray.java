package com.touir.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

import com.touir.leetcode.Solution;

public class ContiguousArray extends Solution {

	/**
	 * problem: 525. Contiguous Array
	 *
	 * url: https://leetcode.com/problems/contiguous-array/
	 */

	public int findMaxLength(int[] nums) {
		int result = 0, sum = 0, curr;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] == 0 ? -1 : 1;
			curr = map.getOrDefault(sum, -100);
			if (curr != -100) {
				result = Math.max(result, i - curr);
			} else
				map.put(sum, i);
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.findMaxLength(new int[] { 0, 1 }) + ", expected: 2");
		System.out.println("result: " + this.findMaxLength(new int[] { 0, 1, 0 }) + ", expected: 2");
		System.out.println("result: " + this.findMaxLength(new int[] { 0, 1, 1 }) + ", expected: 2");
		System.out.println("result: " + this.findMaxLength(new int[] { 0, 0, 1, 0, 0, 0, 1, 1 }) + ", expected: 6");
		System.out.println("result: " + this.findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0 }) + ", expected: 4");

	}

}
