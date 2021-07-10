package org.sandeep.sorting;

import org.sandeep.TwoPointers.Interval;

import java.util.ArrayList;

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        int count = 1;
        Interval prev = intervals.get(0);
        Interval curr = null;
        for(int i=1;i<intervals.size();i++){
            curr = intervals.get(i);
            if(curr.start <= prev.end){
                if(curr.start <= prev.start){
                    int end = Math.max(curr.end, prev.end);
                    Interval x = new Interval(curr.start, end);
                    result.set(count-1,x);
                    prev = x;
                }
                else if(curr.end > prev.end){
                    Interval x = new Interval(prev.start,curr.end);
                    if(count == 0){
                        result.add(x);
                    }else{
                        result.set(count-1,x);
                    }
                    prev = x;
                }
            }else{
                result.add(curr);
                count++;
                prev = curr;
            }
        }
        return result;
    }
}
