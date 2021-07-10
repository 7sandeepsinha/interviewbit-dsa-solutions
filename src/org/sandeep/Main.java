package org.sandeep;

import org.sandeep.TwoPointers.Interval;
import org.sandeep.hashing.LRUCache;
import org.sandeep.sorting.LargestInteger;
import org.sandeep.sorting.MergeOverlappingIntervals;
import org.sandeep.sorting.MergeTwoSortedList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String arg[])
    {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(30,63));
        intervals.add(new Interval(4,100));
        intervals.add(new Interval(48,94));
        intervals.add(new Interval(16,21));
        intervals.add(new Interval(1,32));
        intervals.add(new Interval(1,17));
        intervals.add(new Interval(7,76));
        intervals.add(new Interval(12,24));

//        MergeOverlappingIntervals m = new MergeOverlappingIntervals();
//        ArrayList<Interval> list = m.merge(intervals);
//        for(Interval i : list){
//            System.out.println("[" + i.start + ", " + i.end + "]" );
//        }

        /**
        LRUCache lruCache = new org.sandeep.hashing.LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);

         **/

        /*ListNode a = new ListNode(5);
        ListNode b = new ListNode(4);
        a.next = new ListNode(8);
        a.next.next = new ListNode(20);

        b.next = new ListNode(11);
        b.next.next = new ListNode(15);

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        mergeTwoSortedList.mergeTwoLists(a,b);*/


      /*  int[] A ={472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"ABCD");
        Arrays.sort(A);
        String str = "ABCDEFGH";
        String[] strArr = str.split("");
        Arrays.sort(strArr);
        LargestInteger l = new LargestInteger();
        System.out.println(l.largestNumber(A));*/

        int a = 64;
        double result = Math.log(a)/Math.log(2);
        if((result%1) == 0 )
            System.out.println("True");
        else
            System.out.println("False");

    }
}

