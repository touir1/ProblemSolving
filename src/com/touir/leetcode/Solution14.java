package com.touir.leetcode;

public class Solution14 {
	
	public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        
        for(int i=1;i<strs.length;i++){
            if(result.length() > strs[i].length()) 
            	result = result.substring(0, strs[i].length());
            if(!result.equals(strs[i])) {
            	for(int j=0;j<result.length();j++) {
            		if(result.charAt(j) != strs[i].charAt(j)) {
            			result = result.substring(0, j);
            			break;
            		}
            	}
            }
        }
        
        return result;
    }
}
