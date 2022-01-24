package com.touir.leetcode;

public class Solution3 extends Solution {

	// problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
	
	public int lengthOfLongestSubstring(String s) {
        if(s.length()<=0) return 0;
        
        int[] seen = new int[256];
        
        int result = 0;
        
        int start = 0,
            end = 0;
        
        while(end < s.length()){
            if(seen[s.charAt(end)]==0){
                result = result < end-start+1 ? end-start+1 : result;
            }
            else {
                for(int i=start;i<seen[s.charAt(end)]-1;i++){
                    seen[s.charAt(i)] = 0;
                }
                start = seen[s.charAt(end)];
                
            }
            seen[s.charAt(end)] = end + 1;
            
            end++;
        }
        
        return result;
    }
	
	@Override
	public void test() {
		System.out.println("result: " 
				+ this.lengthOfLongestSubstring("abcabcbb") + ", expected: 3");
		System.out.println("result: " 
				+ this.lengthOfLongestSubstring("bbbbb") + ", expected: 1");
		System.out.println("result: " 
				+ this.lengthOfLongestSubstring("pwwkew") + ", expected: 3");

	}

}
