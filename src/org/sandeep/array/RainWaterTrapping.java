package org.sandeep.array;

public class RainWaterTrapping {
    /**
     * https://www.interviewbit.com/problems/rain-water-trapped/
     *
     */
    public int trap(final int[] A) {
        int maxI = 0;
        int maxH = Integer.MIN_VALUE;
        int totalWater = 0;

        int maxL = A[0];
        int maxR = A[A.length-1];

        for(int i=0;i<A.length;i++){
            if(A[i] > maxH){
                maxI = i;
                maxH = A[i];
            }
        }

        for(int i=1;i<maxI;i++){
            if(A[i] > maxL){
                maxL = A[i];
            }else{
                totalWater = ( maxL - A[i] ) + totalWater;
            }
        }

        for(int i=A.length-1;i>maxI;i--){
            if(A[i] > maxR){
                maxR = A[i];
            }else{
                totalWater = ( maxR - A[i] ) + totalWater;
            }
        }

        return totalWater;
    }
}
