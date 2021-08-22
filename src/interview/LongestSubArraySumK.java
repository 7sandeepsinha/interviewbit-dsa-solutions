package interview;

import java.util.HashMap;

public class LongestSubArraySumK {
    public int solve(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = -1;
        map.put(k,0);
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            if(map.containsKey(sum - k )){
                max = Math.max(max, i - map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        if(max == 0){
            return 1;
        }else{
            return max;
        }
    }

    public static void main(String[] args) {
        LongestSubArraySumK l = new LongestSubArraySumK();
        int[] arr = {1,4,10,-3,2,1,4,5};
        System.out.println(l.solve(arr,4));
    }
}

/*
                1   3   -1  0   1   4   5   -2  -1  2   1   0   5
                1   4   3   3   4   8   13  11  10  12  13  13  18
 */