package org.sandeep.recursion;

public class CheckSorted {
    boolean b = false;

    public boolean solve(int[] A){
        isSorted(A,1,A[0]);
        return b;
    }

    public void isSorted(int[] A, int i, int num){
        if(i==A.length){
            b = true;
            return;
        }

        if(A[i] < num) {
            b = false;
            return;
        }
        isSorted(A,i+1, A[i]);
    }

    public static void main(String[] args) {
        int[] A = {3,4,5,6,1};
        CheckSorted c  = new CheckSorted();
        System.out.println(c.solve(A));
    }

}
