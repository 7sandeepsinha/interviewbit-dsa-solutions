package org.sandeep.hashing;

import java.util.HashMap;

public class LongestSubString {
    /*public int lengthOfLongestSubstring(String A) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(A.length() == 1)
            return 1;
        int i = 0;
        int j = 1;
        map.put(A.charAt(i), i);
        int max = Integer.MIN_VALUE;
        while(i<A.length() && j<A.length()){
            if(map.containsKey(A.charAt(j))){
                int d = j - map.get(A.charAt(j));
                max = Math.max(max,d);
                map.put(A.charAt(j),j);
                i++;
            }else{
                map.put(A.charAt(j),j);
            }
            j++;
        }

        return Math.max(max, (j - i));
    }*/

    public int lengthOfLongestSubstring(String A) {
        int count = 0;
        int max = 0;
        int n = A.length();
        HashMap < Character, Integer > hashMap = new HashMap < > ();
        char c;
        int prevIndex;
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            if (hashMap.containsKey(c)) {
                prevIndex = hashMap.get(c);
                count = Math.min(count + 1, i - prevIndex);
                hashMap.put(c, i);
            } else {
                count++;
                hashMap.put(c, i);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubString s = new LongestSubString();
        System.out.println(s.lengthOfLongestSubstring("abcdecfaghij"));
    }
}
