//package interview;
//
//import java.util.*;
//
//class Pair{
//    char c;
//    int ctr;
//
//    public Pair(char c, int ctr) {
//        this.c = c;
//        this.ctr = ctr;
//    }
//}
//
//public class Solution {
//    public static String reduced_String(int k, String s)
//    {
//        if(k == 1){
//            String res = "";
//            return res;
//        }
//
//        Stack<Pair> stack = new Stack<Pair>();
//
//        int l = s.length();
//        int ctr = 0;
//
//        for(int i=0;i<l;i++){
//            if(stack.size() == 0){
//                stack.add(new Pair(s.charAt(i), 1));
//                continue;
//            }
//
//            if(stack.peek().c == s.charAt(i)){
//                Pair p = stack.pop();
//                p.ctr += 1;
//                if(p.ctr == k){
//                    continue;
//                }else{
//                    stack.add(p);
//                }
//            }else{
//                stack.add(new Pair(s.charAt(i), 1));
//            }
//        }
//
//        String res = "";
//        while(stack.size() > 0 ){
//            Pair p = stack.pop();
//            char c = p.c;
//            int freq = p.ctr;
//            while(freq-- > 0){
//                res = res + c;
//            }
//        }
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        Solution.reduced_String(2, )
//    }
//}
