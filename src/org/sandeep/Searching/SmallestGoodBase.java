package org.sandeep.Searching;

import java.math.BigInteger;

public class SmallestGoodBase {
    public String solve(String A) {
        BigInteger n = new BigInteger(A);
        BigInteger result = new BigInteger("0");

        for(int i = 61; i>= 2; i--){
            result = verifyBase(i, n);
            if(result.compareTo(BigInteger.valueOf(0)) > 0){
                break;
            }
        }
        return String.valueOf(result);

    }

    public BigInteger verifyBase(int i, BigInteger n){
        BigInteger low = BigInteger.valueOf(2);
        BigInteger high = n.subtract(BigInteger.valueOf(1));

        while(low.compareTo(high) == 0 || low.compareTo(high) < 0){
            BigInteger  mid = low.add(high);
            mid = mid.divide(BigInteger.valueOf(2));
            BigInteger temp  = mid.pow(i);
            temp = temp.subtract(BigInteger.valueOf(1)).divide((mid.subtract(BigInteger.valueOf(1))));
            if(temp.compareTo(n)==0){
                return mid;
            }else if(temp.compareTo(n) > 0){
                high = mid.subtract(BigInteger.valueOf(1));
            }else{
                low = mid.add(BigInteger.valueOf(1));
            }
        }

        return BigInteger.valueOf(-1);
    }
}
