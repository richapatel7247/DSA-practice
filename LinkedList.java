public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail =  newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    public static void print() {
       Node temp = head;

       if(head == null) {
        System.out.println("linked list is empty");
       }

       while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
       }
       System.out.println("null");
      
    }

    public static void addMiddle(int idx, int data) {
        Node newNode = new Node(data);

        if(idx == 0) {
            addFirst(data);
            return;
        }
        size++;

        int prev = 0;
        Node temp = head;

        while (prev < idx-1) {
            temp = temp.next;
            prev++;
        }

        newNode.next = temp.next;
        temp.next = newNode; 
    }

    public static void removeFirst() {
        if(size == 0) {
            System.out.println("linked list is empty");
            return;
        }

        if(size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        size--;
        head = head.next;
    }

    public static void removeLast() {
        if(size == 0) {
            System.out.println("linked list is empty");
            return;
        }

        if(size == 1) {
            size = 0;
            head = tail = null;
            return;
        }
        Node temp = head;
        // int i=0;

        // while(i < size-2) {
        //    temp = temp.next;
        //    i++;
        // }
        for(int i=0; i<size-2; i++) {
            temp = temp.next;
        }

        size--;
        temp.next = null;
        tail = temp;
    }

    public static int linearSearch(int key) {
        Node temp = head;
        int  i = 0;

        while (i < size) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int recursiveSearch(int key, Node node) {
        if(node == null) {
            return -1;
        }

        if(node.data == key) {
            return 0;
        }
        return  recursiveSearch(key, node.next) + 1;
    }

    public static void reverseLl() {

        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void removeNthNode(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        Node prev = head;
        while (i < sz - n) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return;
    }


    public static Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrom() {
        if(head == null || head.next == null) {
            return true;
        }

       // step-1 find mid node
        Node mid = findMidNode(head);

        // step-2 reverse list
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;   //head of reverse ll

        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean detectCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }


    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node mid = findMidNode(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);
    }

    public Node merge(Node leftHead, Node rightHead) {
        Node mergeLl = new Node(-1);
        Node temp = mergeLl;

        while (leftHead != null && rightHead != null) {
            if(leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergeLl.next;
    }

    public Node zigZagLL() {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node prev = null;
        Node curr = mid.next;
        Node next;
        mid.next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node leftHead  = head;
        Node rightHead = prev;
        Node leftNext;
        Node rightNext;

        while(leftHead != null && rightHead != null) {
            leftNext = leftHead.next;
            leftHead.next = rightHead;
            rightNext = rightHead.next;
            rightHead.next = leftNext;
            leftHead = leftNext;
            rightHead = rightNext;
        }
        return head;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(1);

        // head = new Node(1);
        // head.next = new Node(4);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(2);
        // head.next.next.next.next = new Node(5);

    //    System.out.println(ll.detectCycle());
        // ll.addLast(4);

        // ll.addMiddle(0, 10);

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head = ll.zigZagLL();
        // ll.head = ll.mergeSort(ll.head);
        ll.print();

        // System.out.println(ll.checkPalindrom());
        // ll.removeNthNode(3);
        // ll.reverseLl();
        // ll.print();
        // System.out.println("index = " + ll.linearSearch(5));
        // System.out.println("index = " + ll.recursiveSearch(3, head));
      
        // System.out.println(ll.size);
        // ll.removeFirst();

        // ll.removeLast();
        // System.out.println(ll.size);
        // ll.print();

    }
}
