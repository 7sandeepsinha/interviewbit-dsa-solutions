package org.sandeep.TwoPointers;

public class MinimizeTheAbsoluteDiff {
    public int solve(int[] A, int[] B, int[] C) {
        int i=0, j=0, k=0;
        int result = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(i<A.length &&  j<B.length && k<C.length){
            int num1 = A[i];
            int num2 = B[j];
            int num3 = C[k];

            max = ( num1 >= num2) ? ( (num1 >= num3) ? num1 : num3) :
                    ( (num2 >= num3) ? num2 : num3);

            if(num1<num2){
                if(num1<=num3){
                    min = num1;
                    i++;
                }else{
                    min = num3;
                    k++;
                }
            }else{
                if(num2<=num3){
                    min = num2;
                    j++;
                }else{
                    min = num3;
                    k++;
                }
            }

            result = Math.min(result, Math.abs( max-min));
        }
        return result;
    }

}
