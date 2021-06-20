package org.sandeep.array;

import java.util.ArrayList;

public class PascalTriangle {
    /**
     * https://www.interviewbit.com/problems/pascal-triangle/
     */
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> list  = new ArrayList<>(A);
        for(int i=0;i<A;i++){
            list.add(new ArrayList<Integer>(A));
        }
        if(A == 0)
            return list;

        list.get(0).add(0,1);
        if(A == 1)
            return list;

        list.get(1).add(0,1);
        list.get(1).add(1,1);

        if(A==2)
            return list;

        for(int i=2;i<=A-1;i++){
            list.get(i).add(0,1);
            for(int k=1;k<i;k++){
                list.get(i).add(list.get(i-1).get(k) + list.get(i-1).get(k-1));
            }
            list.get(i).add(1);
        }

        return list;
    }
}
