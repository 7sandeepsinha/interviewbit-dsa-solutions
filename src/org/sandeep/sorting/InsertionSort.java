package org.sandeep.sorting;

public class InsertionSort {
    public int[] sort(int[] A){
        for(int i=1;i<A.length;i++){
            int j = i;
            while(j > 0 && A[j-1]>A[j]){
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j--;
            }
        }
        return A;

    }
}
