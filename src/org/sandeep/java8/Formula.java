package org.sandeep.java8;

public interface Formula {
    int calculate(int x);
    default  int sq(int x){
        return x * x;
    }
}
