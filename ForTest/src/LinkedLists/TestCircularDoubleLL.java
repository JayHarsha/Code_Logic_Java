package LinkedLists;

public class TestCircularDoubleLL {
    public static void main(String[] args){
        DoubleNode head = new DoubleNode(10);
        DoubleNode temp1 = new DoubleNode(20);
        DoubleNode temp2 = new DoubleNode(30);
        DoubleNode temp3 = new DoubleNode(40);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        temp2.next=temp3;
        temp3.prev=temp2;
        temp3.next=head;
        head.prev=temp3;
    }
}
