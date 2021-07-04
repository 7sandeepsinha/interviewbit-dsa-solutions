package org.sandeep.sorting;

public class SelectionSort {
    public int[] sort(int[] A){
        int min;
        int minIndex = 0;
        for(int i=0;i<A.length;i++){
            min = Integer.MAX_VALUE;
            for(int j=i;j<A.length;j++){
                if(min > A[j]){
                    min = A[j];
                    minIndex = j;
                }
            }
            A[minIndex] = A[i];
            A[i] = min;
        }

        return A;
    }
}
