package org.sandeep.LinkedList;

public class ReverseLinkedList {
    public ListNode reverse(ListNode start, ListNode end){
        if(start == null || start.next == null){
            return start;
        }

        ListNode head = start;
        ListNode tail = end;
        ListNode c = start;
        ListNode cN = c.next;
        ListNode cNN = c.next.next;

        while(cN != end){
            if(cN != null)
                cN.next = c;

            c = cN;
            cN = cNN;
            if(cNN != null)
                cNN = cNN.next;
        }
        head.next = null;
        return c;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);

        ReverseLinkedList r  = new ReverseLinkedList();
        System.out.println(r.reverse(start,null).val);
    }
}
