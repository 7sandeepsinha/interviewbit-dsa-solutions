package org.sandeep.array;

import java.util.ArrayList;
import java.util.Collections;

public class FindMissingInteger {
    /**
     * https://www.interviewbit.com/problems/first-missing-integer/
     */
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();

        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0 && A.get(i) <= n) {
                int pos = A.get(i) - 1;
                if (A.get(pos) != A.get(i)) {
                    Collections.swap(A, pos, i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (A.get(i) != i + 1)
                return (i + 1);
        }
        return n + 1;
    }
}
