package org.sandeep.array;

public class LongestConsecutiveOnes {
    /**
     * https://leetcode.com/problems/max-consecutive-ones/
     */
    public int solve(String A) {
        int[] leftArr = new int[A.length()];
        int[] rightArr = new int[A.length()];
        int count = 0;
        int totalOne = 0;
        int maxOnes = 0;
        int result = 0;

        for(int i=0;i<A.length();i++){
            if(A.charAt(i) == '1'){
                totalOne++;
                count++;
                leftArr[i] = count;
            }else{
                count = 0;
                leftArr[i] = count;
            }
        }
        count = 0;
        for(int i=A.length()-1;i>=0;i--){
            if(A.charAt(i) == '1'){
                count++;
                rightArr[i] = count;
            }else{
                count = 0;
                rightArr[i] = count;
            }
        }

        for(int i=0;i<A.length();i++){
            if(A.charAt(i) == '0'){
                int leftOnes = 0;
                int rightOnes= 0;
                if(i!=0){
                    leftOnes = leftArr[i-1];
                }
                if(i!=A.length()-1){
                    rightOnes = rightArr[i+1];
                }

                if((leftOnes + rightOnes) < totalOne){
                    maxOnes = leftOnes + rightOnes + 1;
                    result = Math.max(result,maxOnes);
                }
            }
        }

        return result;
    }
}
