public class DoublyLL {
    class Node {
        Node next;
        Node prev;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
public static Node head;
public static Node tail;
public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

    }


    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeFirst() {
        if(head == null) {
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if(head == null) {
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public static void printLL() {
        Node temp = head;
        if(head == null) {
            System.out.println("dll is empty");
        }
        System.out.print("null <-> ");
        while(temp != null) {
            System.out.print( temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseDLL() {
        if(head == null && head.next == null) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        // dll.addFirst(1);
        // dll.addFirst(2);

        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.printLL();
        // System.out.println(size);
        // dll.removeFirst();
        // dll.removeLast();

        dll.reverseDLL();
        dll.printLL();
        // System.out.println(size);

    }
}
