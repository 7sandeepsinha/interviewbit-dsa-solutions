package org.sandeep.array;

import java.util.List;

public class MajorityElementN3 {
    /**
     * https://leetcode.com/problems/majority-element-ii/
     */
    public int repeatedNumber(final List<Integer> a) {
        int element1 = a.get(0);
        int count1 = 1;
        int element2 = Integer.MIN_VALUE;
        int count2 = 0;

        for(int i=1;i<a.size();i++){
            if(a.get(i) == element1){
                count1++;
            }else if(a.get(i) == element2 ){
                count2++;
            }else if(count1 == 0){
                element1 = a.get(i);
                count1++;
            }else if(count2 == 0){
                element2 = a.get(i);
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        if(count1 > 0){
            int tempCount1 = 0;
            for(int i : a){
                if(i == element1)
                    tempCount1++;
            }
            if(tempCount1 >= ((a.size()/3)+1))
                return element1;
        }
        if (count2 > 0){
            int tempCount2 = 0;
            for(int i : a){
                if(i == element2)
                    tempCount2++;
            }
            if(tempCount2 >= ((a.size()/3)+1))
                return element2;
        }
        return -1;
    }

}
