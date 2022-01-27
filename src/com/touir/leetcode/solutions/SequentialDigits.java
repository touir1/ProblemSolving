package com.touir.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

import com.touir.leetcode.Solution;

public class SequentialDigits extends Solution {

	/**
	 * problem: 1291. Sequential Digits
	 * 
	 * url: https://leetcode.com/problems/sequential-digits
	 */
	
	public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<Integer>();
        
        int numberOfDigits = getNumberOfDigits(low);
        int lastDigit = low / ((int)Math.pow(10,numberOfDigits-1));
        
        int next = -1;
        
        while(true){
            if(numberOfDigits > 9) break;
            
            next = sequence(numberOfDigits, lastDigit);
            
            if(next > high) break;
            if(next == -1) {
                numberOfDigits++;
                lastDigit = 1;
                continue;
            }
            if(next < low){
                lastDigit++;
                continue;
            }
            
            result.add(next); 
            lastDigit++;
        }
        
        return result;
    }
    
    public static int sequence(int numberOfDigits, int startingDigit){
        if(startingDigit + numberOfDigits > 10) return -1;
        
        int result = 0;
        for(int i=0;i<numberOfDigits;i++){
            result *= 10;
            result += (startingDigit+i);
        }
        
        return result;
    }
    
    public static int getNumberOfDigits(int n){
        return String.valueOf(n).length();
    }
	
	@Override
	public void test() {
		System.out.println("result: " 
				+ this.sequentialDigits(100, 300) + ", expected: [123, 234]");
		System.out.println("result: " 
				+ this.sequentialDigits(1000, 13000) 
				+ ", expected: [1234, 2345, 3456, 4567, 5678, 6789, 12345]");
	}

}
