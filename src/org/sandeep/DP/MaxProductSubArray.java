package org.sandeep.DP;

import java.util.LinkedList;
import java.util.Queue;

public class MaxProductSubArray {
    public static int maxProduct(final int[] A) {
        int maxP = 0;
        int maxN = 0;
        int p = 0;
        int n = 0;
        if(A.length == 1){
            return A[0];
        }

        if(A[0] == 0){
            maxP = 0;
            p=0;
            n=0;
            maxN = 0;
        }else if(A[0] > 0){
            maxP = A[0];
            p= A[0];
            n=0;
            maxN = 0;
        }else{
            maxP = 0;
            maxN = A[0];
            p=0;
            n = A[0];
        }

        for(int i=1;i<A.length;i++){
            if(A[i] == 0){
                p = 0;
                n = 0;
            }else if(A[i] > 0){

                if(p != 0 ){
                    p = p * A[i];
                }else{
                    p = A[i];
                }

                if(n != 0 ){
                    n = n * A[i];
                }else{
                    n = A[i];
                }

            }else {
                if(n != 0 ){
                    n = n * A[i];
                }else{
                    n = A[i];
                }
                p=0;
                if(n > p){
                    p = n;
                }
            }

            maxP = Math.max(p, maxP);
            maxN = Math.max(n, maxN);
        }

        return maxP;

    }

    static int maxProductC(int arr[], int n) {

        // Variables to store maximum and minimum
        // product till ith index.
        int minVal = arr[0];
        int maxVal = arr[0];

        int maxProduct = arr[0];

        for (int i = 1; i < n; i++) {

            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;

            }

            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array.

        Queue<Integer> q = new LinkedList<>();
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 2, -3, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, -3, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, -3, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -3, -2,};
        maxProduct(A);
    }
}
