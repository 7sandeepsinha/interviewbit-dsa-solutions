package org.sandeep.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetDupSum {

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result = new ArrayList<>();
        Collections.sort(A);
        sumHelper(A,0,B,0,new ArrayList<>(),true);
        return result;

    }

    public void sumHelper(ArrayList<Integer> A, int i, int sum, int currSum, ArrayList<Integer> aux, boolean flag){
        if(currSum > sum)
            return;

        if(flag){
            System.out.println(aux);
            if(sum == currSum){
                System.out.println(aux);
                result.add(new ArrayList<>(aux));
            }
        }

        if(i == A.size())
            return;

        aux.add(A.get(i));
        sumHelper(A, i, sum, currSum + A.get(i),aux,true);
        aux.remove(aux.size()-1);
        sumHelper(A, i+1, sum, currSum,aux,false);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,6,8,10));
        SubsetDupSum s  = new SubsetDupSum();
        System.out.println(s.combinationSum(list,10));
    }
}
