package org.sandeep.maths;

public class IntegerPalindrome {
    /**
     *https://leetcode.com/problems/palindrome-number/
     *
     * Solving the problem after reversing only half of the number 
     */
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x!=0)){
            return false;
        }else if(x == 0 ){
            return true;
        }
        int num = 0;
        while(x > num){
            int lastElement = x % 10;
            x = x/10;
            num = num * 10 + lastElement;
        }
        return x == num || x == num/10;


    }
}
