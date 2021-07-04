package org.sandeep.Searching;

public class SingleElementInSortedArray {
    /**
     * https://leetcode.com/problems/single-element-in-a-sorted-array/
     */
    public int solve(int[] A){
        if(A.length==1)
            return A[0];

        int low = 0;
        int high = A.length - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid == 0 || mid == A.length-1){
                if(mid == 0 && A[mid] != A[mid+1])
                    return A[mid];
                if(mid == A.length-1 && A[mid] != A[mid-1])
                    return A[mid];
                break;
            }else{
                if(A[mid] != A[mid-1]){
                    if(A[mid] != A[mid+1])
                        return A[mid];
                    else{
                        if(mid %2 ==0 )
                            low = mid + 1;
                        else
                            high = mid-1;
                    }
                }else{
                    if((mid-1) %2 ==0 )
                        low = mid + 1;
                    else
                        high = mid-1;
                }
            }
        }
        return -1;
    }
}
