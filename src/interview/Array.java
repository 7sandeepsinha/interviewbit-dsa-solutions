package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 90 9 363 368 89
public class Array {
    public void concat(ArrayList<String> A) {
        Collections.sort(A, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;

                if (ab.compareTo(ba) > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }
}