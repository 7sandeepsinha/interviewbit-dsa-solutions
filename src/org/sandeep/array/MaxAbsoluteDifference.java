package org.sandeep.array;

public class MaxAbsoluteDifference {
    /**
     * https://www.interviewbit.com/problems/maximum-absolute-difference/
     */
    public int maxArr(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            maxSum = Math.max(maxSum, A[i] + i);
            maxDiff = Math.max(maxDiff, A[i] - i);
            minSum = Math.min(minSum, A[i] + i);
            minDiff = Math.min(minDiff, A[i] - i);
        }

        int diff1 = maxSum - minSum;
        int diff2 = maxDiff - minDiff;
        if(diff1 >= diff2){
            return diff1;
        }else{
            return diff2;
        }
    }
}

