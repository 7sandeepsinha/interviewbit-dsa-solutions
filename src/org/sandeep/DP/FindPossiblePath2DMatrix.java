package org.sandeep.DP;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPossiblePath2DMatrix {
    public static boolean findPath(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[] dp = new int[m];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j != m-1) {
                    if(arr[i][j] != 0 ) {
                        dp[j] = dp[j+1];
                    }
                }else if(i != n-1 && j == m-1){
                    if(arr[i][j] == 0 ){
                        dp[j] = 0;
                    }
                }else if(i != n-1 && j != m-1){
                    if(arr[i][j] != 0 ){
                        dp[j] = Math.max(dp[j], dp[j+1]);
                    }
                }else{
                    dp[j] = arr[i][j];
                }
            }
        }
        if(dp[0] == 1){
            return true;
        }else{
            return false;
        }
    }

    public static int findPath2(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i= arr.length-2;i>=0;i--){
            if((arr[i][m-1] != 0)){
                arr[i][m-1] = arr[i+1][m-1];
            }
        }

        for(int j=m-2;j>=0;j--){
            if(arr[n-1][j] != 0 ){
                arr[n-1][j] = arr[n-1][j+1];
            }
        }


        for(int i= n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if ( arr[i][j] != 0) {
                    arr[i][j] = Math.max(arr[i+1][j],arr[i][j+1]);
                }
            }
        }

        arr[0][0] = Math.max(arr[0][1], arr[1][0]);

        return arr[0][0];
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] arr = new int[n][m];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(0,1,0,1));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1,1,1,1));
        ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(0,0,1,0));
        ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(0,0,1,1));

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        System.out.println(findPath(arr));
    }
}
