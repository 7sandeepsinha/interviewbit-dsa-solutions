package org.sandeep.TwoPointers;

public class SubarrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        int i = 0;
        int j = 0;
        int sum = 0;
        boolean flag = false;
        if(A[0] > B){
            return new int[]{-1};
        }
        while( i<=j && j<A.length){
            if(i==j){
                sum = A[i];
                if(sum == B){
                    break;
                }
                if(j==A.length-1)
                    break;
                j++;
                sum = sum + A[j];
            }else{
                if(sum < B){
                    if(j==A.length-1)
                        break;
                    j++;
                    sum = sum + A[j];
                }else if(sum > B){
                    sum = sum - A[i];
                    i++;
                }else{
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            int[] resultArr = new int[j-i+1];
            int c = 0;
            for(int q=i;q<=j;q++){
                resultArr[c] = A[q];
                c++;
            }
            return resultArr;
        }else{
            return new int[]{-1};
        }
    }
}
