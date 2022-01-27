package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class DetectCapital extends Solution {

	/**
	 * problem: 520. Detect Capital
	 *
	 * url: https://leetcode.com/problems/detect-capital/
	 */

	public boolean detectCapitalUse(String word) {
		return word.toUpperCase().equals(word) || word.toLowerCase().equals(word)
				|| word.substring(0, 1).toUpperCase().concat(word.toLowerCase().substring(1)).equals(word);
	}

	@Override
	public void test() {
		System.out.println("result: " + this.detectCapitalUse("word") + ", expected: true");
		System.out.println("result: " + this.detectCapitalUse("Word") + ", expected: true");
		System.out.println("result: " + this.detectCapitalUse("worD") + ", expected: false");
		System.out.println("result: " + this.detectCapitalUse("WORD") + ", expected: true");
		System.out.println("result: " + this.detectCapitalUse("WorD") + ", expected: false");
	}

}
