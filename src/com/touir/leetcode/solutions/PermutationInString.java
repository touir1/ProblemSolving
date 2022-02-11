package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class PermutationInString extends Solution {

	/**
	 * problem: 567. Permutation in String
	 *
	 * url: https://leetcode.com/problems/permutation-in-string/
	 */

	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length())
			return false;
		int[] count = new int[26], countS = new int[26];
		int begin = 0, end = 0;
		int check = 0;
		for (char c : s1.toCharArray()) {
			count[c - 'a']++;
			check |= (1 << (c - 'a'));
		}

		while (end < s2.length()) {
			countS[s2.charAt(end) - 'a']++;
			if (countS[s2.charAt(end) - 'a'] == count[s2.charAt(end) - 'a']) {
				check &= ~(1 << (s2.charAt(end) - 'a'));
			} else {
				check |= (1 << (s2.charAt(end) - 'a'));
			}

			if (end - begin + 1 < s1.length()) {
				end++;
				continue;
			}
			if (end - begin + 1 == s1.length() && check == 0) {
				return true;
			}
			end++;
			countS[s2.charAt(begin) - 'a']--;
			if (countS[s2.charAt(begin) - 'a'] == count[s2.charAt(begin) - 'a']) {
				check &= ~(1 << (s2.charAt(begin) - 'a'));
			} else {
				check |= (1 << (s2.charAt(begin) - 'a'));
			}
			begin++;
		}

		return false;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.checkInclusion("ab", "eidbaooo") + ", expected: true");
		System.out.println("result: " + this.checkInclusion("ab", "eidboaoo") + ", expected: false");
	}

}
