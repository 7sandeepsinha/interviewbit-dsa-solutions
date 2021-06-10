package org.sandeep.array;

public class NextPermutation {
    /**
     * https://www.interviewbit.com/problems/next-permutation/
     */
    public int[] nextPermutation(int[] A) {
        if(A.length == 1){
            return A;
        }
        int point1 = -1;
        int point2 = -1;
        for(int i=A.length-2;i>=0;i--){
            if(A[i] < A[i+1]){
                point1 = i;
                break;
            }
        }
        if(point1 == -1){
            A = reverse(0,A);
            return A;
        }else{
            int val = A[point1];
            for(int i=A.length-1;i>=0;i--){
                if(A[i] > val){
                    point2 = i;
                    break;
                }
            }

            A[point1] = A[point2];
            A[point2] = val;

            A =  reverse(point1 + 1 , A);
        }
        return A;
    }

    public static int[] reverse (int index, int[] A){
        int l = index;
        int r = A.length-1;
        while(l <= r){
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
        return A;
    }

}
