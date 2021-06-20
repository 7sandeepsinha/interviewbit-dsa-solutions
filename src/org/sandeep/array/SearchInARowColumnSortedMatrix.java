package org.sandeep.array;

public class SearchInARowColumnSortedMatrix {
    /**
     *https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
     */
    public int solve(int[][] A, int B) {
        int i = 0;
        int j = A[0].length-1;
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        while( i >=0 && i<A.length && j>=0 && j<A[0].length){
            if(A[i][j] == B){
                flag = true;
                int temp =  ((i+1) * 1009 ) + (j+1);
                result = Math.min(result, temp);
                j--;
            }
            else if(A[i][j] > B){
                j--;
            }else{
                i++;
            }
        }
        if(flag)
            return result;
        else
            return -1;
    }
}
