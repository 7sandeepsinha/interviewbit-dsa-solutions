package org.sandeep.TwoPointers;

public class PairsWithGivenSum {
    public int solve(int[] A , int B){
        int i = 0 ;
        int j = A.length-1;
        int count = 0;

        while(i<j){
            int sum = A[i] + A[j];
            if(sum > B){
                j--;
            }else if(sum < B){
                i++;
            }else{
                if(A[i] == A[j]){
                    int n = j-i + 1;
                    count = count + ( n*(n-1)/2);
                    break;
                }else{
                    int  left = 1;
                    int right = 1;
                    while( i < A.length-1){
                        if(A[i] == A[i+1]){
                            left++;
                            i++;
                        }else{
                            i++;
                            break;
                        }
                    }
                    while( j > 0 ){
                        if(A[j] == A[j-1]){
                            right++;
                            j--;
                        }else{
                            j--;
                            break;
                        }
                    }
                    count = count + ( left * right );
                }
            }
        }
        return count;
    }
}
