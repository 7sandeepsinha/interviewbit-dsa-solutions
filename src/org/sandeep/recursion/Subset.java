package org.sandeep.recursion;

import java.util.ArrayList;

public class Subset {

    ArrayList<ArrayList<Integer>>  result = new ArrayList<>();

    public void solve(int[] A){

        subsetHelper(A, 0, new ArrayList<>(), true);
         System.out.println(result);
    }

    public void subsetHelper(int[] A, int i, ArrayList<Integer> aux, boolean flag){
        if(flag)
            result.add(new ArrayList<>(aux));
        if(i==A.length){
           return ;
        }
        aux.add(A[i]);
        subsetHelper(A, i+1, aux, true);
        aux.remove(aux.size()-1);
        subsetHelper(A, i+1, aux , false);

    }

    public static void main(String[] args) {
        int[] A = {1,2};
        Subset s = new Subset();
        s.solve(A);
    }
}


