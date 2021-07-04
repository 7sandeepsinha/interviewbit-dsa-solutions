package org.sandeep.TwoPointers;

public class SmallestSubSequenceWithGivenPrime {

    public int[] solve(int A, int B, int C, int D) {
        int[] resultArr = new int[D];
        int i = 0;
        int Ai = -1;
        int Bi = -1;
        int Ci = -1;
        while (i < D) {
            int valA = 0, valB = 0, valC = 0;
            if (Ai == -1)
                valA = A * 1;
            else
                valA = A * resultArr[Ai];

            if (Bi == -1)
                valB = B * 1;
            else
                valB = B * resultArr[Bi];

            if (Ci == -1)
                valC = C * 1;
            else
                valC = C * resultArr[Ci];

            if (valA <= valB) {
                if (valA <= valC) {
                    if(resultArr[i-1] != valA){
                        resultArr[i] = valA;
                        i++;
                    }
                    Ai++;
                } else {
                    if(resultArr[i-1] != valC){
                        resultArr[i] = valC;
                        i++;
                    }
                    Ci++;
                }
            } else {
                if (valB <= valC) {
                    if(resultArr[i-1] != valB){
                        resultArr[i] = valB;
                        i++;
                    }
                    Bi++;
                } else {
                    if(resultArr[i-1] != valC){
                        resultArr[i] = valC;
                        i++;
                    }
                    Ci++;
                }
            }
        }
        return resultArr;

    }

}
