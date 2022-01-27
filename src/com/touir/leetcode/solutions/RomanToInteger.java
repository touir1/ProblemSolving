package com.touir.leetcode.solutions;

import com.touir.leetcode.Solution;

public class RomanToInteger extends Solution {
	
	/**
	 * problem: 13. Roman to Integer
	 * 
	 * url: https://leetcode.com/problems/roman-to-integer/
	 */
	
	public int romanToInt(String s) {
		int result = 0;
		
		boolean firstIteration = true;
		
		int lastValue = 0,
				value = 0,
				sum = 0;
		
		for(char c : s.toCharArray()) {
			value = romanToInt(c);
			if(firstIteration) {
				sum = value;
				firstIteration = false;
			}
			else if(value == lastValue) {
				sum+= value;
			}
			else if(value > lastValue) {
				sum = value - sum;
				
			}
			else {
				result += sum;
				sum = value;
			}
			
			lastValue = value;
		}
		
		result += sum;
		
		return result;
    }
	
	public int romanToInt(char c) {
		switch(c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	@Override
	public void test() {
		System.out.println("input: X, result: " + this.romanToInt("X") + ", expected: 10");
		System.out.println("input: I, result: " + this.romanToInt("I") + ", expected: 1");
		System.out.println("input: III, result: " + this.romanToInt("III") + ", expected: 3");
		System.out.println("input: IV, result: " + this.romanToInt("IV") + ", expected: 4");
		System.out.println("input: VI, result: " + this.romanToInt("VI") + ", expected: 6");
		System.out.println("input: MCMXCIV, result: " + this.romanToInt("MCMXCIV") + ", expected: 1994");
	}
}
