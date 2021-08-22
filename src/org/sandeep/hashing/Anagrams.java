package org.sandeep.hashing;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0;i<A.size();i++){
            String str = sortString(A.get(i));
            if(map.containsKey(str)){
                map.get(str).add(i+1);
            }else{
                map.put(str,new ArrayList<Integer>(Arrays.asList(i+1)));
            }
        }

        for(Map.Entry<String, ArrayList<Integer>> e : map.entrySet()){
            res.add(e.getValue());
        }

        return res;

    }

    public static String sortString(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
