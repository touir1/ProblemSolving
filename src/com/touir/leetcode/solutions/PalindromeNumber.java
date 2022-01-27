package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class PalindromeNumber extends Solution{
	
	/**
	 * problem: 9. Palindrome Number
	 *
	 * url: https://leetcode.com/problems/palindrome-number/
	 */
	
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		String s = String.valueOf(x);
		
		return new StringBuilder(s).reverse().toString().equals(s);
    }

	@Override
	public void test() {
		System.out.println("result: " + this.isPalindrome(1) + ", expected: true");
		System.out.println("result: " + this.isPalindrome(121) + ", expected: true");
		System.out.println("result: " + this.isPalindrome(-121) + ", expected: false");
		System.out.println("result: " + this.isPalindrome(123) + ", expected: false");
		System.out.println("result: " + this.isPalindrome(10) + ", expected: false");
	}
}
