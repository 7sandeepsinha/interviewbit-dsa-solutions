package org.sandeep.example;

public class LinkedListImpl {

    public static Node addNodeToEnd(Node head, int data){
        if(head == null){
            Node newNode = new Node(data);
            return newNode;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        Node newNode = new Node(data);
        curr.next = newNode;
        return head;
    }

    public static void printList(Node head){
        if(head == null){
            System.out.println("Head is null");
        }

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node addNodeAtBeginning(Node head, int data){
        if(head == null){
            head = new Node(data);
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node addNodeAtK(Node head, int k, int data){
        if(head == null){
            if(k==1){
                 head = new Node(data);
                 return head;
            }else{
                return null;
            }
        }

        if(k==1){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node curr = head;
        while(curr != null && k>2){
            curr = curr.next;
            k--;
        }

        Node temp = curr.next;
        Node newNode = new Node(data);
        curr.next = newNode;
        newNode.next = temp;

        return head;
    }

    public static Node removeNodeAtEnd(Node head){
        if(head == null){
            return head;
        }

        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }

        curr.next = null;
        return head;
    }

    public static Node removeNodeFromStart(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    public static Node removeNodeFromK(Node head, int k){
        if(head == null){
            return head;
        }

        if(k==1){
            return removeNodeFromStart(head);
        }

        Node curr = head;
        while(curr != null && k>2){
            curr = curr.next;
            k--;
        }

        if(curr.next != null){
            curr.next = curr.next.next;
        }
        return head;
    }

    public static int getLength(Node head){
        int count =0;
        if(head == null){
            return 0;
        }

        Node curr = head;
        while(curr != null){
           count++;
           curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        printList(head);
        addNodeToEnd(head,2);
        addNodeToEnd(head,3);
        addNodeToEnd(head,4);
        printList(head);
        head = addNodeAtBeginning(head, 0);
        head = addNodeAtBeginning(head, -1);
        head = addNodeAtBeginning(head, -2);
        printList(head);
        System.out.println("Length " + getLength(head));
        head = addNodeAtK(head, 3,100);
        head = addNodeAtK(head, 1,999);
        head = addNodeAtK(head, 6,333);
        printList(head);
        removeNodeAtEnd(head);
        removeNodeAtEnd(head);
        printList(head);
        head = removeNodeFromStart(head);
        head = removeNodeFromStart(head);
        printList(head);
        head = removeNodeFromK(head, 3);
        printList(head);
        System.out.println("Length " + getLength(head));

    }
}
