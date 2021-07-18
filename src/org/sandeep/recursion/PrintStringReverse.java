package org.sandeep.recursion;

import java.time.Duration;
import java.time.Instant;

public class PrintStringReverse {

    public void printStringReverse(String str, int i){
        if(i<0){
            System.out.println();
            return;
        }

        System.out.print(str.charAt(i));
        printStringReverse(str, i -1);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        PrintStringReverse obj = new PrintStringReverse();
        obj.printStringReverse("ABCDEFGH" , 7);
        Instant end = Instant.now();
        Duration d = Duration.between(start,end);
        System.out.println("Executed in : " + (d.toNanos()/1000) + "ms");
    }


}
