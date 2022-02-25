package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class CompareVersionNumbers extends Solution {

	/**
	 * problem: 165. Compare Version Numbers
	 *
	 * url: https://leetcode.com/problems/compare-version-numbers/
	 */

	public int compareVersion(String version1, String version2) {
		int v1, v2, i = 0, j = 0;
		while (i < version1.length() || j < version2.length()) {
			v1 = 0;
			v2 = 0;
			while (i < version1.length() && version1.charAt(i) != '.') {
				v1 = v1 * 10 + (version1.charAt(i) - '0');
				i++;
			}
			while (j < version2.length() && version2.charAt(j) != '.') {
				v2 = v2 * 10 + (version2.charAt(j) - '0');
				j++;
			}
			if (v1 < v2)
				return -1;
			if (v1 > v2)
				return 1;
			i++;
			j++;
		}
		return 0;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.compareVersion("1.01", "1.001") + ", expected: 0");
		System.out.println("result: " + this.compareVersion("1.0", "1.0.0") + ", expected: 0");
		System.out.println("result: " + this.compareVersion("0.1", "1.1") + ", expected: -1");

	}

}
