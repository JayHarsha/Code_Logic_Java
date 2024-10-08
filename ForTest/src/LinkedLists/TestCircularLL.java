package LinkedLists;

public class TestCircularLL {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;
        //head = insertAtEnd(head, new Node(5));
        deleteAtK(head, 4);
        printCircularLL(head);
    }

    public static Node printCircularLL(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
            if(curr == head){
                break;
            }
        }
        return head;
    }
    public static Node insertAtBegin(Node head, Node begin){
//        Node curr = head;
//        while(curr.next != head){
//            curr = curr.next;
//        }
//        curr.next = begin;
//        begin.next = head;
//        return begin;
        begin.next= head.next;
        head.next=begin;
        int temp = head.data;
        head.data = begin.data;
        begin.data=temp;

        return head;
    }

    public static Node insertAtEnd(Node head, Node end){
//        Node curr = head;
//        while (curr.next != head){
//            curr=curr.next;
//        }
//        curr.next=end;
//        end.next=head;
        end.next=head.next;
        head.next=end;
        int temp = head.data;
        head.data = end.data;
        end.data=temp;
        return end;
    }

    public static void deleteHead(Node head){
        int temp = head.data;
        head.data=head.next.data;
        head.next.data = temp;
        head.next=head.next.next;
    }

    public static Node deleteAtK(Node head, int k) {
        Node curr = head;
        //10,20,30,40
        if(k==1){
            deleteHead(head);
            return head;
        }
        for(int i =0; i<k-2; i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}
