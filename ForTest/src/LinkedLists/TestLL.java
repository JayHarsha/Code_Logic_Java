package LinkedLists;

public class TestLL {
    public static void main(String []args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
//        head.next.next.next.next = new Node(50);

//        Node head1 = new Node(2);
//        head1.next = new Node(3);
//        head1.next.next = new Node(4);
//        head = insertBegin(head,50);
//        Node newTail = insertEnding(head,100);
//        head = insertAtLocation(head,1, 70);
//        head = deleteBegin(head);
//        head = deleteEnd(head);
//        head = deleteAtPos(head,1);
//        head = mergeTwoSortedLL(head,head1);
//        head = insertInSortedLL(head, new Node(35));
        int n = returnNthNodeFromEndLL(head, 3);
        System.out.println("Nth node : " + n);
//        printList(head);
    }

    public static void printList(Node head){
        Node curr = head;
        while (curr!=null) {
            System.out.println(curr.data);
            curr=curr.next;
        }
    }

    public static void recursionPrint(Node head){
        if (head != null) {
            System.out.println(head.data);
            recursionPrint(head.next);
        }
    }

    public static Node insertBegin(Node head, int intHead){
        Node newHead = new Node(intHead);
        newHead.next = head;
        return newHead;
    }

    public static Node insertEnding(Node head, int intTail){
        Node newTailNode = new Node(intTail);
        Node curr = head;
        if(head == null){
            return newTailNode;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next=newTailNode;
        return curr;
    }

    public static Node insertAtLocation(Node head, int pos, int insertInt){
        Node curr = head;
        int count = 1;
        Node insertNode = new Node(insertInt);
        if(pos ==1){
            insertNode.next = head;
            return insertNode;
        }
        while(curr != null){
            count++;
            System.out.println("Count is : "+count);
            if(count == pos){
                System.out.println("Inside count == pos"+ count);
                insertNode.next = curr.next;
                curr.next = insertNode;
            }
            curr = curr.next;
        }
        return head;
    }

    public static Node deleteBegin(Node head){
        Node newNode = head.next;
        head.next = null;
        return newNode;
    }

    public static Node deleteEnd(Node head){
        Node curr = head;
        while(curr.next.next != null){
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }

    public static Node deleteAtPos(Node head, int pos){
        Node curr = head;
        int count = 2;
        if(pos ==1){
            head = deleteBegin(head);
            return head;
        }
        for(int i=1; i < pos-1 && curr.next.next != null; i++){
            curr=curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static int searchIndex(Node head, int x){
        Node curr = head;
        int count = 1;
        while (curr!=null){
            if(curr.data == x) break;
            curr = curr.next;
            count++;
        }
        return count;
    }

    public static int searchIndexRecursive(Node head, int x, int index){
        if(head == null){
            return -1;
        }
        if(head.data == x){
            return index;
        }
        else{
            return searchIndexRecursive(head.next, x, index+1);
        }
    }

    public static Node reverseLL(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        //2,6,3
        //5,6,4
        Node curr1 = l1;
        Node curr2 = l2;
        Node node1 = l1;
        Node node2 = l2;
        int carry = 0;
        int length1 = 0;
        int length2 = 0;
        while(node1 != null){
            length1++;
            node1=node1.next;
        }
        while (node2 != null){
            length2++;
            node2=node2.next;
        }

        if(length1 == length2){
            while(curr1 != null && curr2 != null){
                int sum = curr1.data+curr2.data;
                curr1.data = (sum)%10 + carry;
                carry = sum/10;
                if(Integer.toString(curr1.data).length()>1){
                    carry=curr1.data/10;
                    curr1.data = curr1.data%10;
                }
                if(curr1.next == null){
                    break;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            }
            if(carry != 0){
                curr1.next = new Node(carry);
            }
        }

        //9,9,9
        //9,9
        //8,9,0,1
        //System.out.println("10/10= "+10/10+"||"+10%10);
        if(length1 > length2){
            while(curr1 != null){
                if (curr2 == null) {
                    curr2 = new Node(0);
                }
                int sum = curr1.data+curr2.data;
                curr1.data = (sum)%10 + carry;
                System.out.println("Sum is: "+sum +" || Carry is: "+carry);
                carry = sum/10;
                if(Integer.toString(curr1.data).length()>1){
                    carry=curr1.data/10;
                    curr1.data = curr1.data%10;
                }
                System.out.println("l1+l2 = "+curr1.data);
                if(curr1.next == null){
                    break;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            }
            if(carry != 0){
                curr1.next = new Node(carry);
            }
        }

        //[5,2,8,1,8]
        //[4,4,7,8,1,5]
        //[9,6,5,0,0
        int i = 0;
        if(length1 < length2){
            while(curr2 != null){
                i++;
                if (curr1 == null){
                    curr1 = new Node(0);
                }
                int sum = curr1.data+curr2.data;
                curr2.data = (sum)%10 + carry;
                System.out.println("Sum is: "+sum +" || Carry is: "+carry);
                carry = sum/10;
                //[5,2,8,1,8]
                //[4,4,7,8,1,5]
                //[9,6,5,0,0
                if(Integer.toString(curr2.data).length()>1){
                    System.out.println("If more length curr2.data = "+ curr2.data);
                    carry=curr2.data/10;
                    curr2.data = curr2.data%10;
                }
                System.out.println("l1+l2 = "+curr2.data);
                if(curr2.next == null){
                    break;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            }
            if(carry != 0){
                curr2.next = new Node(carry);
            }
            return l2;
        }

        return l1;
    }

    public static Node mergeTwoSortedLL(Node head1, Node head2){
        Node curr = new Node(0);
        Node dummy = curr;
        //1,2,4 - curr1  //2,3,4 - 1
        //2,3,4 - curr2  //1,2,4 - 2
        //0,1,2,2,3,4,4
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                dummy.next=head1;
                head1=head1.next;
            }else{
                dummy.next=head2;
                head2=head2.next;
            }
            dummy=dummy.next;
            if(head1!=null){
                dummy.next=head1;
            }
            else if(head2 != null){
                dummy.next=head2;
            }
            System.out.println("head2 data: " + head2.data);
        }
        return curr.next;
    }

    public static Node insertInSortedLL(Node head, Node insert){
        Node curr = head;
        //Node curr1 =head;
        //10,20,30,40
        //25
        if(insert.data <= head.data){
            insert.next = head;
            return insert;
        }
        while (curr != null){
            if(curr.next==null){
                curr.next=insert;
                break;
            }
            else if(insert.data <= curr.next.data){
                insert.next = curr.next;
                curr.next = insert;
                break;
            }
            curr=curr.next;
        }
        return head;
    }

    public static Node returnMiddleLL(Node head){
        Node slow = head;
        Node fast = head;
        while (fast !=null && fast.next!=null){
            slow =slow.next;
            fast =fast.next.next;
        }
        return slow;
    }

    //5,15,20
    //1,10,15,20
    //13
    public static Node sortedInsertLL(Node head, int insertData){
        Node curr = head;
        Node newNode = new Node(insertData);
        if (curr.data > newNode.data ) {
            newNode.next = curr;
            return newNode;
        }
        while(curr.next !=null && curr.next.data < insertData){
            curr=curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    public static int returnNthNodeFromEndLL(Node head, int x){
        Node first = head;
        Node second = head;
        //1,2,3,4,5
        for(int i=0; i<x; i++){
            second = second.next;
        }
        while (second != null){
            first=first.next;
            second=second.next;
        }
        return first.data;
    }
}
