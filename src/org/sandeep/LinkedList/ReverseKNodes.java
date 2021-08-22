package org.sandeep.LinkedList;

public class ReverseKNodes {
    public ListNode reverseList(ListNode A, int B) {
        ListNode prevF = null;
        ListNode head = null;
        ListNode prevS = A;
        ListNode curr = A;
        ListNode lastF = A;
        ListNode lastS = A;
        boolean flag = true;
        while(curr != null){
            int count = B;
            while(count > 1){
                curr = curr.next;
                count--;
            }

            lastF = curr;
            lastS = curr.next;

            ListNode[] reversed = reverse(prevS, lastF);

            if(flag){
                head = reversed[0];
                flag = false;
            }
            if(prevF != null){
                prevF.next = reversed[0];
            }

            reversed[1].next = lastS;

            prevF = reversed[1];
            prevS = lastS;
            curr = prevS;
        }
        return head;
    }


    public static ListNode[] reverse(ListNode start, ListNode end){
        if(start == null || start.next == null){
            return new ListNode[]{start,start};
        }

        ListNode head = start;
        ListNode tail = end;
        ListNode c = start;
        ListNode cN = c.next;
        ListNode cNN = c.next.next;

        while(c != end){
            if(cN != null)
                cN.next = c;

            c = cN;
            cN = cNN;
            if(cNN != null)
                cNN = cNN.next;
        }
        head.next = null;
        return new ListNode[]{c,head};
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

        ReverseKNodes r = new ReverseKNodes();
        System.out.println(r.reverseList(node,1).val);
    }
}
