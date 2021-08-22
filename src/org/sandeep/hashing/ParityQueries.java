package org.sandeep.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ParityQueries {
   /* public ArrayList<Integer> solve(ArrayList<Character> A, ArrayList<String> B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            String num = B.get(i);
            char opr = A.get(i);
            if (opr == '+') {
                int hash = hash(num);
                if (map.containsKey(hash)) {
                    map.put(hash, map.get(hash) + 1);
                } else {
                    map.put(hash, 1);
                }
            } else if (opr == '-') {
                int hash = hash(num);
                map.put(hash, map.get(hash) - 1);
            } else {
                int hash = reverseHash(num);
                if (map.containsKey(hash))
                    res.add(map.get(hash));
            }
        }

        return res;
    }

    public static int hash(String num) {
        int hash = 0;
        int i=0;
        while(i < num.length() && (int)(num.charAt(i)) % 2==0){
            i++;
        }

        for (int j=i;j<num.length();j++) {
            int x = num.charAt(j);
            if (x % 2 == 0)
                hash++;
            else
                hash += 2;
        }
        return hash;
    }

    public static int reverseHash(String pattern) {
        int hash = 0;
        int i = 0;
        while (i < pattern.length()  && pattern.charAt(i) == '0') {
            i++;
        }

        for (int j = i; j < pattern.length(); j++) {
            if (pattern.charAt(j) == '1')
                hash += 2;
            else
                hash++;
        }

        return hash;
    }*/

    public ArrayList<Integer> solve(ArrayList<Character> A, ArrayList<String> B) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            String num = B.get(i);
            char opr = A.get(i);
            if (opr == '+') {
                String hash = hash(num);
                if (map.containsKey(hash)) {
                    map.put(hash, map.get(hash) + 1);
                } else {
                    map.put(hash, 1);
                }
            } else if (opr == '-') {
                String hash = hash(num);
                map.put(hash, map.get(hash) - 1);
            } else {
                String hash = reverseHash(num);
                if (map.containsKey(hash))
                    res.add(map.get(hash));
                else
                    res.add(0);
            }
        }

        return res;
    }

    public static String hash(String num) {
        String hash = "";
        int i=0;

        for(int j=0;j<num.length();j++){
            if((int) num.charAt(j) % 2 == 0){
                hash = hash + "0";
            }else{
                hash = hash + "1";
            }
        }

        while (i < hash.length() && hash.charAt(i) == '0')
            i++;

        StringBuffer sb = new StringBuffer(hash);
        sb.replace(0, i, "");
        return (sb.length() == 0) ? "0" : sb.toString();
    }

    public static String reverseHash(String pattern) {
        int i = 0;
        while (i < pattern.length() && pattern.charAt(i) == '0')
            i++;

        StringBuffer sb = new StringBuffer(pattern);
        sb.replace(0, i, "");
        return (sb.length() == 0) ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        ParityQueries p = new ParityQueries();
        ArrayList<Character> A = new ArrayList<>(Arrays.asList('+', '+', '-', '?'));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("200", "200", "200", "0"));
        System.out.println(p.solve(A,B));
    }
}
