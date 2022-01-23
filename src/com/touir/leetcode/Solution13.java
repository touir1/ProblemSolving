package com.touir.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution13 {
	
	// problem: https://leetcode.com/problems/roman-to-integer/
	
	public Solution13() {

	}
	
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
}
