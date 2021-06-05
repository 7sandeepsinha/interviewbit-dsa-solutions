package org.sandeep.array;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
    /**
     * https://www.interviewbit.com/problems/max-non-negative-subarray/
     */

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : A) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}
