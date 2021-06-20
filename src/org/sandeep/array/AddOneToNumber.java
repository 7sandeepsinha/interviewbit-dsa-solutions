package org.sandeep.array;

import java.util.ArrayList;
import java.util.Collections;

public class AddOneToNumber {
    /**
     * https://www.interviewbit.com/problems/add-one-to-number/
     */
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = A.size();
        int sum = A.get(n-1) + 1;
        int carry = 0;
        if(sum > 9){
            list.add(0);
            carry = 1;
        }else{
            list.add(sum);
        }
        for(int i=n-2;i>=0;i--){
            sum = A.get(i) + carry;
            if(sum>9){
                list.add(0);
            }else{
                list.add(sum);
                carry = 0;
            }
        }

        if(carry == 1){
            list.add(carry);
        }

        for(int i=list.size()-1;i>=0;i++){
            if(list.get(i) == 0){
                list.remove(i);
            }else{
                break;
            }
        }

        Collections.reverse(list);

        return list;
    }
}
