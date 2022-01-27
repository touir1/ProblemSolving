package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class MedianTwoSortedArrays extends Solution {

	/**
	 * problem: 4. Median of Two Sorted Arrays
	 *
	 * url: https://leetcode.com/problems/median-of-two-sorted-arrays/
	 */

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int p1 = 0, p2 = 0;
		double[] nums = new double[2000];

		for (int i = 0; i <= ((nums1.length + nums2.length) / 2) + 1; i++) {
			if (p1 < nums1.length && p2 < nums2.length) {
				if (nums1[p1] < nums2[p2]) {
					nums[i] = nums1[p1];
					p1++;
				} else if (nums1[p1] > nums2[p2]) {
					nums[i] = nums2[p2];
					p2++;
				} else {
					nums[i] = nums1[p1];
					nums[i + 1] = nums2[p2];
					p1++;
					p2++;
					i++;
				}
			} else if (p1 < nums1.length) {
				nums[i] = nums1[p1];
				p1++;
			} else if (p2 < nums2.length) {
				nums[i] = nums2[p2];
				p2++;
			}
		}

		return (nums1.length + nums2.length) % 2 == 1 ? nums[(nums1.length + nums2.length) / 2]
				: (nums[(nums1.length + nums2.length) / 2] + nums[((nums1.length + nums2.length) / 2) - 1]) / 2;
	}

	@Override
	public void test() {
		System.out.println(
				"result: " + this.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }) + ", expected: 2.0");
		System.out.println("result: " + this.findMedianSortedArrays(new int[] { 1, 2, 3, 4 }, new int[] { 3, 4 })
				+ ", expected: 2.5");

	}

}
