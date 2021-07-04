package org.sandeep.sorting;

public class BubbleSort {
    public int[] sort(int[] A){
        boolean swapped = false;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<(A.length-i-1);j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
        return A;
    }
}
