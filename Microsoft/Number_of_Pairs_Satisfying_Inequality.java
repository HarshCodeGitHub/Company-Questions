package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Pairs_Satisfying_Inequality {
	
	public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        long[] a = new long[nums1.length];

        List<Long> list =  new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++) {
            a[i] = nums1[i]-nums2[i];
            list.add(a[i]);
        }

        list.sort(null);
        long ans = 0L;

        for(long num: a){
            long target = num-diff;
            list.remove(bs(list,num));
            ans += list.size()-bs(list,target);
        }

        return ans;
    }

    public int bs(List<Long> list, long target){
        int lo = 0, hi = list.size()-1;
        while(lo <= hi){
            int m = (lo+hi)>>1;
            if(list.get(m)<target) lo=m+1;
            else hi=m-1;
        }
        return hi+1;
    }
}
