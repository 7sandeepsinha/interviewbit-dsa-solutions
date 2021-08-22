package org.sandeep.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {

    public int isValidSudoku(final List<String> A) {
        HashSet<String> seen = new HashSet<>();
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                System.out.print(A.get(i).charAt(j) + " ");
                if(A.get(i).charAt(j) != '.'){
                    char curr = A.get(i).charAt(j);
                    if( !seen.add(curr + "ROW" + i) || !seen.add(curr + "COL" + j) || !seen.add(curr + "BOX" + i/3 + "-" +  j/3))
                        return 0;
                }
            }
            System.out.println();
        }

        return 1;
    }

    public static void main(String[] args) {

        String[] arr = {"..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", "........."};
        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku(Arrays.asList(arr.clone())));
    }
}
