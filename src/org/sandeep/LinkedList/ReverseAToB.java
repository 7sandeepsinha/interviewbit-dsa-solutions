package org.sandeep.LinkedList;

public class ReverseAToB {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int count = 1;
        ListNode curr = A;
        ListNode prev = null;
        while(curr != null && count < B){
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode start = curr;

        if(start.next == null){
            return A;
        }

        if(start.next.next == null){
            prev.next = start.next;
            prev.next.next = start;
            prev.next.next.next = null;
            return A;
        }

        ListNode c = start;
        ListNode cN = c.next;
        ListNode cNN = c.next.next;

        while(c != null && count < C){
            if(cN != null){
                cN.next = c;
            }

            c = cN;
            cN = cNN;

            if(cNN != null){
                cNN = cNN.next;
            }

            count++;
        }

        if(prev == null){
            A = c;
        }else{
            prev.next = c;
        }

        start.next = cN;
        return A;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next.next.next = new ListNode(9);

        ReverseAToB r = new ReverseAToB();
        System.out.println(r.reverseBetween(node,8,9).val);
    }


}
