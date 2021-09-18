package org.sandeep.examples;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
       //create an array of size 6, and take inputs from user to fill the array
        // once the array is filled, find max, min, sum and avg of all the numbers
        int[] arr = new int[6];
        Scanner sc = new Scanner(System.in);
        System.out.println("User pls add 6 numbers to array");

        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        //print the array
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i] + " ");
//        }
        for(int x : arr){
            System.out.println(x);
        }

        System.out.println(":: Finding max, min, sum and avg");

        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        double avg = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] < min){
                min = arr[i];
            }

            sum = sum + arr[i];
        }

        avg = sum/arr.length;

        System.out.println("MAX : " + max);
        System.out.println("MIN : " + min);
        System.out.println("SUM : " + sum);
        System.out.println("AVG : " + avg);


        int[][] arr2 = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr2[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        int n = 50;
        for(int i=n;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


   /* //find the max of 5 numbers
    public static int maxTwo(int a, int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }

    public static int maxThree(int a, int b, int c){
        if(a>b){
            int max = maxTwo(a,c);
            return max;
        }else{
            int max = maxTwo(b,c);
            return max;
        }
    }

    public static int maxFour(int a, int b,int c,int d){
        if(a>b){
            int max = maxThree(a,c,d);
            return max;
        }else{
            int max = maxThree(b,c,d);
            return max;
        }
    }

    public static int maxFive(int a,int b,int c,int d,int e){
        if(a>b){
            int max = maxFour(a,c,d,e);
            return max;
        }else{
            int max = maxFour(b,c,d,e);
            return max;
        }
    }*/
}
