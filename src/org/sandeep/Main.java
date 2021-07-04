package org.sandeep;

import org.sandeep.sorting.BubbleSort;
import org.sandeep.sorting.SelectionSort;

public class Main {

    public static void main(String arg[])
    {
        SelectionSort b = new SelectionSort();
        int[] A = {1,6,5,2,8,0,5,9,2};
        A = b.sort(A);
        for(int i : A)
            System.out.println(i);
    }
}

