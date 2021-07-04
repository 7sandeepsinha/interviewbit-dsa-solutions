package org.sandeep.Searching;

public class SmallestGoodBaseProper {
    long play(long n, int d) {
        double t = n;
        long r = (long)(Math.pow(t, 1.0 / d) + 1);
        long l = 1;
        while(l <= r) {
            long m = l + (r - l) / 2;
            long sum = 1, cur = 1;
            for(int i = 1; i <= d; i++) {
                cur *= m;   sum += cur;
            }
            if(sum == n)    return m;
            if(sum > n)     r = m - 1;
            else    l = m + 1;
        }
        return 0;
    }

    public String solve(String A) {
        long n = Long.parseLong(A);
        long x = 1;
        for(int i = 62; i >= 1; i--) {
            if((x << i) < n) {
                long cur = play(n, i);
                if(cur != 0) {
                    return (cur +"");
                }
            }
        }
        return (n-1 +"");
    }
}
