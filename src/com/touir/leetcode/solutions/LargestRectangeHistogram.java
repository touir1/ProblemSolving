package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class LargestRectangeHistogram extends Solution {

	/**
	 * problem: 84. Largest Rectangle in Histogram
	 *
	 * url: https://leetcode.com/problems/largest-rectangle-in-histogram/
	 */

	public int largestRectangleArea(int[] heights) {
		int result = 0, cursor = 0, n = heights.length;
		if (n == 0)
			return 0;

		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = -1;
		right[n - 1] = n;

		// initializing left height jumps array
		for (int i = 1; i < n; i++) {
			cursor = i - 1;
			while (cursor >= 0 && heights[cursor] >= heights[i])
				cursor = left[cursor];
			left[i] = cursor;
		}

		// initializing right height jumps array
		for (int i = n - 2; i >= 0; i--) {
			cursor = i + 1;
			while (cursor < n && heights[cursor] >= heights[i])
				cursor = right[cursor];
			right[i] = cursor;
		}

		// calculating result
		for (int i = 0; i < n; i++) {
			result = Math.max(result, heights[i] * (right[i] - left[i] - 1));
		}

		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }) + ", expected: 10");
		System.out.println("result: " + this.largestRectangleArea(new int[] { 2, 4 }) + ", expected: 4");
	}

}
