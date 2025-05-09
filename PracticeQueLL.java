import java.util.LinkedList;
public class PracticeQueLL {
    public static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node tail;
    public static Node head;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    public static void deletnNodeAfterMNode(int n, int m, Node head) {
        Node curr = head, temp;
        while(curr != null) {
            for(int i=1; i<m && curr !=null; i++) {
                curr = curr.next;
            }
            if(curr == null) {
               return;
            }
            temp = curr.next;

            for(int i=1; i<=n && temp != null; i++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }

    public static void printList( Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
}

    public static Node getIntersection(Node head1, Node head2) {

        while (head1 != null) {
            Node tempHead2  = head2;
            while(tempHead2  != null) {
                if(head1 == tempHead2) {
                    return head1;
                }
                tempHead2 = tempHead2.next;
            }
            head1 = head1.next;
        }
        return null;
    }

    public static void swappingNodes(Node head, int x, int y) {
        if(x == y) {
            return;
        }

        Node prevX = null;
        Node currX = head;

        while(currX.data != x && currX != null) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;

        while (currY.data != y && currY != null ) {
            prevY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null) {
            return;
        }

        if(prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if(prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        int x = 2;
        int y = 4;
        printList(head);
        swappingNodes(head, x, y);
        printList(head);
        



        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);
        // head.next.next.next.next.next.next = new Node(7);
        // head.next.next.next.next.next.next.next = new Node(8);
        // head.next.next.next.next.next.next.next.next = new Node(9);
        // head.next.next.next.next.next.next.next.next.next = new Node(10);

        // int m = 3;
        // int n = 2;

        // printList(head);
        // deletnNodeAfterMNode(n, m, head);
        // printList(head);

        // Node head1 = new Node(1);
        // Node head2 = new Node(4);

        // head1.next = new Node(2);
        // head1.next.next = new Node(3);

        // head2.next = new Node(5);

        // Node newNode = new Node(6);
        // head1.next.next.next = newNode;
        // head2.next.next = newNode;

        // newNode = new Node(7);
        // head1.next.next.next.next = newNode;
        // head2.next.next.next = newNode;

        // Node point = getIntersection(head1, head2);
        // if(point == null) {
        //     System.out.println("no intersection poin");
        // } else {
        //     System.out.println("intersection poin is " + point.data);
        // }
    }
}
