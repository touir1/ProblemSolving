package com.touir.leetcode.solutions;

import java.util.Stack;

import com.touir.leetcode.Solution;

public class ValidParentheses extends Solution {
	
	/**
	 * problem: 20. Valid Parentheses
	 *
	 * url: https://leetcode.com/problems/valid-parentheses
	 */
	
	public boolean isValid(String s) {
        boolean result = true;
		
		Stack<Character> stack = new Stack<Character>();
        String copy = new String(s.toCharArray());
        
        while(true) {
        	if(copy.length() <= 0) break;
        	
        	char c = copy.charAt(0);
        	copy = copy.substring(1);
        	
        	if(c == '[' || c == '(' || c == '{') stack.push(c);
        	else if(c == ']' || c == ')' || c == '}') {
        		if(!stack.isEmpty()) {
        			if(c == ']' && stack.peek() == '[') stack.pop();
        			else if(c == ')' && stack.peek() == '(') stack.pop();
        			else if(c == '}' && stack.peek() == '{') stack.pop();
        			else {
        				result = false;
        				break;
        			}
        		}
        		else {
        			result = false;
        			break;
        		}
        	}
        	else {
        		result = false;
        		break;
        	}
        }
        
        return result && stack.isEmpty();
    }

	@Override
	public void test() {
		System.out.println("result: " + this.isValid("[()]") + ", expected: true");
		System.out.println("result: " + this.isValid("()") + ", expected: true");
		System.out.println("result: " + this.isValid("[]") + ", expected: true");
		System.out.println("result: " + this.isValid("([])") + ", expected: true");
		System.out.println("result: " + this.isValid("[()]()") + ", expected: true");
		System.out.println("result: " + this.isValid("[(])") + ", expected: false");
		System.out.println("result: " + this.isValid("") + ", expected: true");
		System.out.println("result: " + this.isValid("[()") + ", expected: false");
	}
}
