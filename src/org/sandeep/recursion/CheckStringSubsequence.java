package org.sandeep.recursion;

import java.time.Duration;
import java.time.Instant;

public class CheckStringSubsequence {
    public boolean solve(String main, String seq, int i, int j){
        if(j==seq.length())
            return true;

        if(i==main.length())
            return false;

        for(int q = i;q<main.length();q++){
            if(main.charAt(q) == seq.charAt(j)){
                return solve(main,seq,q+1,j+1 );
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        CheckStringSubsequence obj = new CheckStringSubsequence();
        System.out.println(obj.solve("cathartic", "hace" ,0, 0));
        Instant end = Instant.now();
        Duration d = Duration.between(start,end);
        System.out.println("Executed in : " + (d.toNanos()/1000) + "ms");
    }


}
