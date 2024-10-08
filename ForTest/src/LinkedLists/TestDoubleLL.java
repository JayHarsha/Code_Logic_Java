package LinkedLists;

public class TestDoubleLL {
    public static void main(String [] args){
        DoubleNode head = new DoubleNode(10);
        DoubleNode temp1 = new DoubleNode(20);
        DoubleNode temp2 = new DoubleNode(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.prev = temp1;
        temp1.prev = head;
        head= deleteTail(head);
        printAll(head);
    }

    public static void printAll(DoubleNode head){
        DoubleNode curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr= curr.next;
        }
    }

    public static DoubleNode insertBegin(DoubleNode head){
        DoubleNode newHead = new DoubleNode(5);
        newHead.next = head;
        head.prev = newHead;
        return  newHead;
    }
    public static DoubleNode insertEnd(DoubleNode head){
        DoubleNode newTail = new DoubleNode(40);
        DoubleNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newTail;
        newTail.prev = curr;
        return head;
    }

    public static DoubleNode reverseLL(DoubleNode head){
        DoubleNode curr = head;
        DoubleNode next = null;
        DoubleNode p = null;
        while (curr != null){
            p = curr.prev;
            curr.prev = curr.next;
            curr.next = p;
            curr = curr.prev;
        }
        System.out.println("Printing Data: " + p.prev);
        return p.prev;
    }

    public static DoubleNode deleteHead(DoubleNode head){
        DoubleNode curr = head.next;
        curr.prev = null;
        head.next = null;
        return curr;
    }

    public static DoubleNode deleteTail(DoubleNode head){
        DoubleNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.prev.next=null;
        //curr.prev=null;
        return head;
    }
}
