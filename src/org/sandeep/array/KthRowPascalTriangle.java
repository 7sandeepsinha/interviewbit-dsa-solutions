package org.sandeep.array;

public class KthRowPascalTriangle {
    /**
     * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
     */
    public int[] getRow(int A) {

        int[] arr=new int[A+1];

        if(A==0){
            arr[0]=1;
            return arr;
        }

        if(A==1){
            arr[0]=arr[A]=1;
            return arr;
        }

        int prev=1;
        arr[0]=1;
        for(int i=1;i<=A;i++){
            int current=(prev*(A-i+1))/i;
            arr[i]=current;
            prev=current;
        }

        return arr;
    }
}
