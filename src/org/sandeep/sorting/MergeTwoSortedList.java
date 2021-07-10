package org.sandeep.sorting;


import org.sandeep.ListNode;

import java.math.BigInteger;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        if(A == null)
            return B;

        if(B == null)
            return A;

        ListNode head = null;

        ListNode a = A;
        ListNode b = B;

        if(a.val <= b.val){
            head = a;
            a = a.next;
        }else{
            head = b;
            b = b.next;
        }
        ListNode temp = head;
        while(a != null && b != null){
            if(a.val <= b.val){
                temp.next = a;
                temp = temp.next;
                a = a.next;
            }else{
                temp.next = b;
                temp = temp.next;
                b = b.next;
            }
        }

        if(a == null){
            temp.next = b;
        }else{
            temp.next = a;
        }

        return head;
    }
}
