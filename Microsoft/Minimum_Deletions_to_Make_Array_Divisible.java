package com.microsoft;

import java.util.PriorityQueue;

public class Minimum_Deletions_to_Make_Array_Divisible {
	public int minOperations(int[] nums, int[] numsDivide) {
        int minVal = numsDivide[0];

        for(int i=1;i<numsDivide.length;i++)
            minVal = hcf(minVal, numsDivide[i]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num:nums)
            pq.add(num);
        
        int ans = 0;
        int removed = -1;

        while(pq.size()>0 && pq.peek()<minVal){
            removed = pq.remove();
            
            ans++;

            if(minVal % removed==0) 
                return ans-1;
        }
        
        if(pq.size()!=0 && pq.peek()==minVal) 
            return ans;
        
        return -1;
    }
    

    public int hcf(int a, int b){
        if(b==0) 
            return a;
        return hcf(b, a%b);
    }
}
