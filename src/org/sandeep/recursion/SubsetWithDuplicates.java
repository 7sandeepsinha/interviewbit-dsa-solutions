package org.sandeep.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SubsetWithDuplicates {
    public ArrayList<ArrayList<Integer>> result;
    HashMap<Integer,Integer> map;
    ArrayList<Integer> numbers;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        result = new ArrayList<>();
        Collections.sort(A);
        numbers = new ArrayList<>();
        map = new HashMap<>();

        for(int i : A){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i,1);
                numbers.add(i);
            }
        }

        subsetsHelper(numbers,0,new ArrayList<>());

        return result;
    }

    public void subsetsHelper(ArrayList<Integer> arr, int i, ArrayList<Integer> aux){
        if(i == arr.size()){
            result.add(new ArrayList<>(aux));
            return;
        }

        for(int q=0; q<map.get(i);q++){
            aux.add(arr.get(i));
            subsetsHelper(arr, i, aux);
        }

        for(int q=0;q<map.get(i);q++){
            aux.remove(aux.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetWithDuplicates s = new SubsetWithDuplicates();
        s.subsetsWithDup(new ArrayList<>(Arrays.asList(1,1,1,2,3,2,5,4,5)));
    }
}
