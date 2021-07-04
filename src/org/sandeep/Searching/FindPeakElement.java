package org.sandeep.Searching;

public class FindPeakElement {
    /**
     * https://leetcode.com/problems/find-peak-element/
     */
    public int solve(int[] A){
        int low = 0;
        int high = A.length -1;

        if(A.length == 1){
            return A[0];
        }

        if(A[0] >= A[1]){
            return A[0];
        }

        if(A[high] >= A[high-1]){
            return A[high];
        }

        while( low <= high ){
            int mid = low +  ( high - low)/2 ;
            if(mid == 0 || mid == A.length-1){
                break;
            }

            if( A[mid-1] <= A[mid] && A[mid] >= A[mid+1]){
                return A[mid];
            } else if( A[mid -1 ] > A[mid] && A[mid] > A[mid+1]){
                high = mid -1;
            } else if( A[mid-1] < A[mid] && A[mid] < A[mid+1]){
                low = mid +1 ;
            }else{
                low = mid  + 1;
            }
        }

        return -1;
    }

}
