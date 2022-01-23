package com.touir.leetcode;

public class Solution9 {
	
	// problem: https://leetcode.com/problems/palindrome-number/
	
	public Solution9() {
		
	}
	
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		String s = String.valueOf(x);
		
		return new StringBuilder(s).reverse().toString().equals(s);
    }
}
