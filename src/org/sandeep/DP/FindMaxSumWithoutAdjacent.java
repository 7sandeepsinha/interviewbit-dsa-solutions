package org.sandeep.DP;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxSumWithoutAdjacent {
    public static int adjacent(int[][] A) {
        int[] arr = new int[A[0].length];
        int[] res = new int[2];

        for(int i=0;i<A[0].length;i++){
            arr[i] = Math.max(A[0][i], A[1][i]);
            if(i==0 || i==1){
                res[i] = arr[i];
            }else{
                int max = Math.max(arr[i]+res[0], res[1]);
                if(max == 182){
                    System.out.println();
                }
                res[0] = res[1];
                res[1] = max;
            }
        }

        return res[1];
    }

    public static int adjacent(ArrayList < ArrayList < Integer >> A) {

        int n;
        int dp[];
        ArrayList< Integer > first, second;
        first = A.get(0);
        second = A.get(1);

        n = A.get(0).size();

        if (n == 0)
            return 0;

        dp = new int[n];
        dp[0] = Math.max(first.get(0), second.get(0));

        if (n < 2)
            return dp[0];

        dp[1] = Math.max(first.get(1), second.get(1));
        dp[1] = Math.max(dp[0], dp[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(first.get(i), second.get(i));
            dp[i] += dp[i - 2];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {16, 5, 54, 55, 36, 82, 61, 77, 66, 61};
        int[] arr2 = {31, 30, 36, 70, 9, 37, 1, 11, 68, 14};
        int[][] A = new int[2][arr1.length];

        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(16, 5, 54, 55, 36, 82, 61, 77, 66, 61));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(31, 30, 36, 70, 9, 37, 1, 11, 68, 14));

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(al1);
        list.add(al2);
        adjacent(list);
        adjacent(A);
    }
}
