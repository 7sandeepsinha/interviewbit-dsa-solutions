package org.sandeep.sorting;

import java.math.BigInteger;

public class LargestInteger {
    public String largestNumber(final int[] A) {
        String result = String.valueOf(A[0]);

        if(A.length == 1)
            return result;

        for(int i=1;i<A.length;i++){
            result = compare(result, String.valueOf(A[i]));
        }

        return result;
    }

    public String compare(String num1, String num2){
        String x  = num1 + num2;
        String y = num2 + num1;

        BigInteger xBig = new BigInteger(x);
        BigInteger yBig = new BigInteger(y);

        if(xBig.compareTo(yBig) >= 0){
            return x;
        }else{
            return y;
        }
    }
}
