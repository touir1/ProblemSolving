package com.touir.leetcode;

public class Main {

	public static void main(String[] args) {
		
		test20();
	}
	
	public static void test20() {
		Solution20 solution = new Solution20();
		
		System.out.println("result: " + solution.isValid("[()]") + ", expected: true");
		System.out.println("result: " + solution.isValid("()") + ", expected: true");
		System.out.println("result: " + solution.isValid("[]") + ", expected: true");
		System.out.println("result: " + solution.isValid("([])") + ", expected: true");
		System.out.println("result: " + solution.isValid("[()]()") + ", expected: true");
		System.out.println("result: " + solution.isValid("[(])") + ", expected: false");
		System.out.println("result: " + solution.isValid("") + ", expected: true");
		System.out.println("result: " + solution.isValid("[()") + ", expected: false");
	}
	
	public static void test14() {
		Solution14 solution = new Solution14();
		
		System.out.println("result: " 
				+ solution.longestCommonPrefix(new String[] {"flower","flow","flight"}) 
				+ ", expected: fl");
		System.out.println("result: " 
				+ solution.longestCommonPrefix(new String[] {"dog","racecar","car"}) 
				+ ", expected: ");
	}
	
	public static void test9() {
		Solution9 solution = new Solution9();
		
		System.out.println("result: " + solution.isPalindrome(1) + ", expected: true");
		System.out.println("result: " + solution.isPalindrome(121) + ", expected: true");
		System.out.println("result: " + solution.isPalindrome(-121) + ", expected: false");
		System.out.println("result: " + solution.isPalindrome(123) + ", expected: false");
		System.out.println("result: " + solution.isPalindrome(10) + ", expected: false");
	}
	
	public static void test13() {
		Solution13 solution = new Solution13();
		
		System.out.println("input: X, result: " + solution.romanToInt("X") + ", expected: 10");
		System.out.println("input: I, result: " + solution.romanToInt("I") + ", expected: 1");
		System.out.println("input: III, result: " + solution.romanToInt("III") + ", expected: 3");
		System.out.println("input: IV, result: " + solution.romanToInt("IV") + ", expected: 4");
		System.out.println("input: VI, result: " + solution.romanToInt("VI") + ", expected: 6");
		System.out.println("input: MCMXCIV, result: " + solution.romanToInt("MCMXCIV") + ", expected: 1994");
	}
}
