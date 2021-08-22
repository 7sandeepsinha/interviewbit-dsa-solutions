package org.sandeep.hashing;

import java.util.HashMap;

public class LongestSubArraySumZero {
    public int[] lszero(int[] A) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<A.length;i++){
            sum = sum + A[i];
            if(map.containsKey(sum)){
                int d = i - (map.get(sum)+1);
                if(d > max){
                    l = map.get(sum) + 1;
                    r = i;
                }
            }else{
                map.put(sum,i);
            }
        }

        int[] arr = new int[r-l+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = A[l];
            l++;
        }

        return arr;

    }

    public static void main(String[] args) {
        int[] A = { -19, 8, 2, -8, 19, 5, -2, -23 };
        LongestSubArraySumZero s = new LongestSubArraySumZero();
        s.lszero(A);
    }
}
