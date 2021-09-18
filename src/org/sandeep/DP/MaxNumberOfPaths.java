package org.sandeep.DP;

public class MaxNumberOfPaths {

    public static int maxPathsTopDown(int n , int m){
        int[] path = new int[m+1];
        path[0] = 0;
        for(int i=1; i<path.length; i++){
            path[i] = 1;
        }

        for(int i=1;i<n;i++){
            path[1] = path[1] + path[path.length-1];
            for(int j=2;j<m;j++){
                path[j] = path[j] + path[j-1];
            }
        }
        return path[path.length-2];
    }

    public static void main(String[] args) {
        System.out.println(maxPathsTopDown(5,4));
    }
}
