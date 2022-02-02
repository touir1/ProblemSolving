package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class AllAnagramInString extends Solution {

	/**
	 * problem: 438. Find All Anagrams in a String
	 *
	 * url: https://leetcode.com/problems/find-all-anagrams-in-a-string/
	 */

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		int np = p.length(), ns = s.length();
		if (np > ns)
			return result;

		int[] anagram = new int[26], found = new int[26];

		// flag to check if all letter counts are the same
		int bitVerif = 67108863;
		int bitCursor = 67108863, curr1, curr2, i;

		for (i = 0; i < np; i++) {
			curr1 = p.charAt(i) - 'a';
			curr2 = s.charAt(i) - 'a';
			anagram[curr1]++;
			found[curr2]++;

			if (found[curr1] == anagram[curr1])
				bitCursor |= (1 << curr1);
			else
				bitCursor &= ~(1 << curr1);
			if (found[curr2] == anagram[curr2])
				bitCursor |= (1 << curr2);
			else
				bitCursor &= ~(1 << curr2);
		}
		if (bitCursor == bitVerif)
			result.add(0);

		for (i = np; i < ns; i++) {
			curr1 = s.charAt(i) - 'a';
			curr2 = s.charAt(i - np) - 'a';
			found[curr2]--;
			if (found[curr2] == anagram[curr2])
				bitCursor |= (1 << curr2);
			else
				bitCursor &= ~(1 << curr2);
			found[curr1]++;
			if (found[curr1] == anagram[curr1])
				bitCursor |= (1 << curr1);
			else
				bitCursor &= ~(1 << curr1);

			if (bitCursor == bitVerif)
				result.add(i - np + 1);
		}
		return result;
	}

	@Override
	public void test() {
		System.out.println("result: " + this.findAnagrams("cbaebabacd", "abc") + ", expected: [0, 6]");
		System.out.println("result: " + this.findAnagrams("abab", "ab") + ", expected: [0, 1, 2]");

	}

}
