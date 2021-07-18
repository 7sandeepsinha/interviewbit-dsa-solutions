package org.sandeep.recursion;

import java.time.Duration;
import java.time.Instant;

public class SumOfNNumbers {
    public int sum(int A){
        if(A==1)
            return 1;

        return A + sum(A-1);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        SumOfNNumbers obj = new SumOfNNumbers();
        System.out.println(obj.sum(10000));
        Instant end = Instant.now();
        Duration d = Duration.between(start,end);
        System.out.println("Executed in : " + (d.toNanos()/1000) + "ms");
    }
}
