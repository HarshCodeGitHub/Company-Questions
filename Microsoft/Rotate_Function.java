package com.microsoft;

public class Rotate_Function {
	public int maxRotateFunction(int[] nums) {
        int first = 0;
        int sec = 0;

        for(int i = 0; i < nums.length; i++){
            first = first + (nums[i] * i);
            sec = sec + nums[i];
        }

        int max = first;
        
        for(int i = nums.length - 1; i >= 1 ; i--){
            first = first + sec - nums.length * nums[i];
            max = Math.max(max , first);
        }

      return max;
    }
}
