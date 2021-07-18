package org.sandeep.recursion;

import java.time.Duration;
import java.time.Instant;

public class Factorial {

    public long fact(long A){
        if(A==0)
            return 1;

        return A * fact(A-1);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        Factorial f = new Factorial();
        System.out.println(f.fact(10));
        Instant end = Instant.now();
        Duration d = Duration.between(start,end);
        System.out.println("Executed in : " + (d.toNanos()/1000) + "ms");
    }
}
