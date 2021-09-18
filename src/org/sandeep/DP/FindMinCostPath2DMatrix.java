package org.sandeep.DP;

import java.util.Scanner;

public class FindMinCostPath2DMatrix {

    public static int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                //for last row except last column
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                //for last column in all except last row
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                // all columns and rows except last row or column
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                //for last row and last column
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] arr = new int[n][m];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(minPathSum(arr));
    }
}
