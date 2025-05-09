public class CircularLL {
    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node last;
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(last == null) {
            last = newNode;
            last.next = newNode;
            return;
        }

        newNode.next = last.next;
        last.next = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(last == null) {
            last = newNode;
            last.next = newNode;
            return;
        }

        Node next = last.next;
        last.next = newNode;
        last = newNode;
        last.next = next;
    }
    public static void main(String args[]) {

    }
}
