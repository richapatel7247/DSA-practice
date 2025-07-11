
import java.util.Stack;
public class StackPractice {

    public static class Node {
    
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrom(Node head) {
        Stack<Character> s = new Stack<>();

        Node temp = head;
        while(temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        while (head != null) {
        if (head.data != s.pop()) {
            return false;
        }
            head= head.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('C');
        head.next.next.next.next = new Node('B');
        head.next.next.next.next.next = new Node('A');

        System.out.println(isPalindrom(head));
    }
}
