package org.sandeep.LinkedList;

public class LoopNodeInLL {
    public ListNode solve(ListNode a){
        if(a==null || a.next == null)
            return null;

        ListNode slow = a;
        ListNode fast = a.next.next;

        while (fast != null &&
                fast.next != null)
        {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow != fast)
            return null;

        slow = a;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = node.next.next;

        LoopNodeInLL loopNodeInLL = new LoopNodeInLL();
        System.out.println(loopNodeInLL.solve(node).val);
    }
}
