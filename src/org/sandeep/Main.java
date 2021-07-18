package org.sandeep;

import org.sandeep.TwoPointers.Interval;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String arg[])
    {
        int[] A = {5,6,9,1,23,4,0,29};
        int k = 29;
        System.out.println(pairSum(A,k));
    }

    public static int pairSum(int[] arr, int k){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == k)
                    count++;
            }
        }
        return count;
    }




}

