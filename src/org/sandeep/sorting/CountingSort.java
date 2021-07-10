package org.sandeep.sorting;


import org.sandeep.PairData;

public class CountingSort {
    public PairData[] sort(PairData[] A){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PairData[] sorted = new PairData[A.length];
        for(PairData p : A){
            min = Math.min(p.key,min);
            max = Math.max(p.key,max);
        }

        int[] countArr = new int[max-min+1];
        for(PairData p : A){
            countArr[p.key-min]++;
        }
        for(int i=1;i<A.length;i++){
            countArr[i] = countArr[i] + countArr[i-1];
        }

        for(int i=0;i< A.length;i++){
            PairData pd = A[i];
            sorted[countArr[pd.key-min]-1] = pd;
            countArr[pd.key-min]--;
        }
        return A;
    }
}
