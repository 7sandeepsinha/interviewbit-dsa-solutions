package org.sandeep.recursion;

import java.time.Duration;
import java.time.Instant;

public class CheckStringPalindrome {
    public boolean checkStringPalindrome(String str, int i , int j){
        if(j < i)
            return true;

        if(str.charAt(i) == str.charAt(j)){
           return checkStringPalindrome(str, i+1, j-1);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        CheckStringPalindrome obj = new CheckStringPalindrome();
        System.out.println(obj.checkStringPalindrome("MADAM", 0, 4));
        Instant end = Instant.now();
        Duration d = Duration.between(start,end);
        System.out.println("Executed in : " + (d.toNanos()/1000) + "ms");
    }

}
