package org.sandeep.TwoPointers;

public class ClosestPairFromSortedArrays {
    public int[] solve(int[] A, int[] B, int C){
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        if(A.length == 1 && B.length == 1 ){
            return new int[] {A[0], B[0]};
        }

        int low = 0;
        int high = B.length-1;

        while( low < A.length && high >=0 ){
            int temp  = ( A[low] + B[high] ) - C ;
            if(Math.abs(temp) < diff){
                diff = Math.abs(temp);
                i = low;
                j = high;
            }else if (Math.abs(temp) == diff){
                j = high;
            }
            if(temp == 0){
                return new int[]{A[low], B[high]};
            }else if( temp < 0 ){
                low ++ ;
            } else{
                high--;
            }
        }

        return new int[]{A[i], B[j]};
    }

}
