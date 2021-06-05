package org.sandeep;

import org.sandeep.array.ReadingNewspaper;
import org.sandeep.array.SetMatrixZero;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SetMatrixZero b = new SetMatrixZero();
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(4);
        for(int i=0;i<4;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<4;j++){
                int val = sc.nextInt();
                list.add(j,val);
            }
            arr.add(i, list);
        }
        System.out.println(arr);
        b.setZeroes(arr);
    }
}
