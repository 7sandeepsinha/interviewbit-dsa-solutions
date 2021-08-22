package interview;

import java.util.HashSet;

public class FindSubArrayZero {
    public static void main(String[] args) {
        int[] arr = {0,1,4,3,2,1,4,5};
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            if(set.contains(sum)) {
                System.out.println(true);
                break;
            }else{
                set.add(sum);
            }
        }
    }
}

/*
 */