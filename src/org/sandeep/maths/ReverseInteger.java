package org.sandeep.maths;

public class ReverseInteger {
    public int reverse(int x) {
        String str = "" ;
        while(x != 0){
            str = str + (x % 10);
            x = x/10;
        }
        int result = Integer.parseInt(str);
        return result;

    }
}
