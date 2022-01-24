package com.touir.leetcode;

public class Solution9 extends Solution{
	
	// problem: https://leetcode.com/problems/palindrome-number/
	
	public Solution9() {
		
	}
	
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
