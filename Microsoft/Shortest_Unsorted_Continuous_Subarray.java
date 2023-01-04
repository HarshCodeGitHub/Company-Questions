package com.microsoft;

import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray {
	public int findUnsortedSubarray(int[] nums) {
        // using Two Pointer approach : O(nlogn) + O(n)
        // 2 [6 4 8 10 9] 15 -> unsorted array
        // 2 [4 6 8 9 10] 15 -> sorted array
        // see the diff of 5 elements

        int []sorted = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            sorted[i] = nums[i];

        Arrays.sort(sorted);
        
        int low = 0;// upper end
        int high = sorted.length;// lower end

        for(int i=0;i<sorted.length;i++){
            if(nums[i] != sorted[i]){
                low = Math.max(low,i);
                high = Math.min(high,i);
            }
        }

        // we have pointers at a dist
        if((low - high) >= 0)
            return (low - high + 1);

        return 0;// there r no changes    
        
    }
}
