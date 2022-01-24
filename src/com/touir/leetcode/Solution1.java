package com.touir.leetcode;

import java.util.Arrays;

public class Solution1 extends Solution {

	// problem: https://leetcode.com/problems/two-sum/
	
	public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length; i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target) return new int[]{i,j};
            }
        }
        
        return new int[2];
    }
	
	@Override
	public void test() {
		System.out.println("result: " 
				+ Arrays.toString(this.twoSum(new int[] {2,7,11,15}, 9)) 
				+ ", expected: [0, 1]");
		System.out.println("result: " 
				+ Arrays.toString(this.twoSum(new int[] {3,2,4}, 6))
				+ ", expected: [1, 2]");
		System.out.println("result: " 
				+ Arrays.toString(this.twoSum(new int[] {3,3}, 6))
				+ ", expected: [0, 1]");
	}

}
