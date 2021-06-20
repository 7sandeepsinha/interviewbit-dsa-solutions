package org.sandeep.array;

public class MajorityElement {
    /**
     *
     * https://www.interviewbit.com/problems/majority-element/
     */
    public int majorityElement(final int[] A) {
        int element = A[0];
        int count = 1;
        for(int i=1;i<A.length;i++){
            if(count == 0){
                element = A[i];
                count = 1;
            }else{
                if(A[i] == element){
                    count++;
                }else{
                    count--;
                }
            }
        }

        if(count > 0){
            int majorityCount = 0;
            for(int i : A){
                if(i == element)
                    majorityCount++;
            }
            if(majorityCount > ((A.length/2)+1))
                return element;
            else
                return -1;
        }else{
            return -1;
        }
    }
}
