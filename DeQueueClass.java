import java.util.Deque;
import java.util.LinkedList;
public class DeQueueClass {

    // static class Stack {
    
    //     Deque<Integer> dq = new LinkedList();

    //     boolean isEmpty() {
    //         return dq.isEmpty();
    //     }

    //     void push(int data) {
    //         dq.addLast(data);
    //     }

    //     int pop() {
    //         if(isEmpty()) {
    //             System.out.println("stack is empty");
    //             return -1;
    //         }

    //         return dq.removeLast();
    //     }

    //     int peek() {
    //          if(isEmpty()) {
    //             System.out.println("stack is empty");
    //             return -1;
    //         }

    //         return dq.getLast();
    //     }
        
    // }

    static class Queue {
    
        Deque<Integer> dq = new LinkedList<>();

        boolean isEmpty() {
            return dq.isEmpty();
        }

        void add(int data) {
            dq.addLast(data);
        }

        int remove() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return dq.removeFirst();
        }

        int peek(){
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return dq.getFirst();
        }
    }

    
    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

         while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }



        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        
    }
}
