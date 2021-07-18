package org.sandeep.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result = genSubset(A, A.size());
        return result;
    }

    public ArrayList<ArrayList<Integer>> genSubset(ArrayList<Integer> A,int n){
        if(n==0){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        }

        ArrayList<ArrayList<Integer>> listN = genSubset(A, n-1);
        ArrayList<ArrayList<Integer>> listForLast = new ArrayList<>();

        int element = A.get(n-1);

        for(ArrayList<Integer> l : listN){
            ArrayList<Integer> temp = new ArrayList<>(l);
            temp.add(element);
            listForLast.add(temp);
        }

        listN.addAll(listForLast);

        return listN;
    }
}

class Subset2Main{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        Subset2 subset2 = new Subset2();
        System.out.println(subset2.subsets(list));
    }
}
