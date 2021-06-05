package org.sandeep.array;

public class PrintSpiralMatrix {
    /**
     * https://www.interviewbit.com/problems/spiral-order-matrix-ii/
     */
    public int[][] generateMatrix(int A) {
        int count = 1;
        int max = A * A;
        int l = 0 ;  //left
        int r = A-1; //right
        int t = 0;   //top
        int b = A-1; //bottom
        int[][] arr = new int[A][A];
        int dir = 1;

        while(count <= max){
            if(dir == 1){
                for(int i=l; i<= r; i++){
                    arr[t][i] = count;
                    count++;
                }
                t++;
                dir = 2;
            }else if(dir == 2){
                for(int i=t;i<=b;i++){
                    arr[i][r] = count;
                    count++;
                }
                r--;
                dir = 3;
            }else if(dir == 3){
                for(int i=r;i>=l;i--){
                    arr[b][i] = count;
                    count++;
                }
                b--;
                dir = 4;
            }else{
                for(int i=b;i>=t;i--){
                    arr[i][l] = count;
                    count++;
                }
                l++;
                dir = 1;
            }
        }
        return arr;
    }
}
