package org.sandeep.TwoPointers;

public class ClosedPairFromSortedArray {
    public int[] solve(int[] A, int[] B, int C) {
        int i =0;
        int j = 0;
        int diff = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        int prevX = i;
        int prevY = j;
        while( i < A.length || j < B.length){
            int tempDiff = Math.abs( C - (A[i] + B[j]));
            if(tempDiff == 0) {

                break;
            }
            if(tempDiff <= diff){
                diff = tempDiff;
                prevX = i;
                prevY = j;
                if(A[i] <= A[j])
                    i++;
                else
                    j++;
            }else{
                break;
            }
        }
        int[] arr = new int[2];
        arr[0] = A[prevX];
        arr[1] = B[prevY];

        return arr;
    }
}
