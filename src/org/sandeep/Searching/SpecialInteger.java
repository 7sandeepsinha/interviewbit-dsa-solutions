package org.sandeep.Searching;

public class SpecialInteger {
    public int solve(int[] A, int B){
        int k = 1;
        int low = 1;
        int high = A.length;
        int ans = 0;

        while(low <= high){
            k = low + (high-low)/2;
            if(verify(A,k,B)){
                low = k+1;
                ans = k;
            }else{
                high = k-1;
            }
        }
        return ans;

    }

    public boolean verify(int[] A, int k, int B){
        int sum = 0;
        for(int i=0;i<k;i++){
            if(sum>B) return false;
            sum = sum + A[i];
        }
        for(int i=k;i<A.length;i++){
            sum = sum + A[i];
            sum = sum - A[i-k];
            if(sum > B)
                return false;
        }
        return true;
    }
}
