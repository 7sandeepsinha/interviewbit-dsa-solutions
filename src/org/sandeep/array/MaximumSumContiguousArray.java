package org.sandeep.array;

public class MaximumSumContiguousArray {
    /**
     *https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
     */
    public int maxSubArray(final int[] A) {
        int curr_max = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i : A){
            curr_sum = curr_sum + i;
            curr_max = Math.max(curr_max, curr_sum);
            if(curr_sum < 0){
                curr_sum = 0;
            }
        }
        return curr_max;
    }
}
