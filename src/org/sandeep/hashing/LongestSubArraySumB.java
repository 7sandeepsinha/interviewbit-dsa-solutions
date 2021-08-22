package org.sandeep.hashing;

import java.util.HashMap;

public class LongestSubArraySumB {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<A.length;i++){
            sum = sum + A[i];
            if(map.containsKey(sum-B)){
                int d = i - map.get(sum-B);
                max = Math.max(max,d);
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }

        return (max == Integer.MIN_VALUE) ? -1 : max;
    }

    public static void main(String[] args) {
        int[] A = {-4, 0, -3, -2, 3, 2, 5, 0, -2, 4 };
        int B = 2 ;
        LongestSubArraySumB b = new LongestSubArraySumB();
        System.out.println(b.solve(A,B));
    }
}
