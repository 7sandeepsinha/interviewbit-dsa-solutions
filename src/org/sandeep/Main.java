package org.sandeep;

import org.sandeep.array.NextPermutation;

public class Main {

    public static void main(String[] args) {
        int[] A = {251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        NextPermutation n = new NextPermutation();
        n.nextPermutation(A);
    }
}
