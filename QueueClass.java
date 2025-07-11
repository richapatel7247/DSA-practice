import java.util.LinkedList;
import java.util.*;
import java.util.Stack;

public class QueueClass {

    // static class CirculerQueue {

    //     int rear;
    //     int front;
    //     int size;
    //     int arr[];

    //     CirculerQueue(int n) {
    //         size = n;
    //         rear = -1;
    //         front = -1;
    //         arr = new int[size];
    //     }

    //     public boolean isEmpty() {
    //         return (rear == -1 && front == -1);
    //     }

    //     public boolean isFull() {
    //         return ((rear + 1) % size) == front;
    //     }

    //     public void add(int data) {
    //         if(isFull()) {
    //             System.out.println("queue is full");
    //             return;
    //         }
    //         if(front == -1) {
    //             front = 0;
    //         }
    //         rear = (rear + 1) % size;
    //         arr[rear] = data;
    //     }

    //     public int remove() {
    //         if(isEmpty()) {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }

    //         int frontVal =  arr[front];

    //         if(rear == front) {
    //             rear = front = -1;
    //         } else {
    //             front = (front+1) % size;
    //         }
           
    //         return frontVal;
    //     }
        
    //     public int peek() {
    //         if(isEmpty()) {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return arr[front];
        
    //     }
    // }

    // static class Queue{

    //     static int arr[];
    //     static int size;
    //     static int rear;

    //     Queue(int n) {
    //         size = n;
    //         rear = -1;
    //         arr = new int[n];
    //     }

    //     public boolean isEmpty() {  // O(1)
    //         return rear == -1;
    //     }

    //     public void add(int data) { // O(1)
    //         if(rear == size-1) {
    //             System.out.println("queue is full");
    //             return;
    //         }

    //         rear++;
    //         arr[rear] = data;
    //     }

    //     public int remove() { // O(n)
    //         if(isEmpty()) {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }

    //         int front = arr[0];

    //         for(int i=0; i<rear; i++) {
    //             arr[i] = arr[i+1];
    //         }
    //         rear--;
    //         return front;
    //     }

    //     public int peek() {  // O(1)
    //         if(isEmpty()) {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return arr[0];
    //     }
    // }

    // static class Queuel {
    //   LinkedList<Integer> ll = new LinkedList<>();

    //   public boolean isEmpty() {
    //     return ll.isEmpty();
    //   }

    //   public void add(int data) {
    //     ll.addLast(data);
    //   }

    //   public int remove() {
    //     if(ll.isEmpty()) {
    //         System.out.println("queue is empty");
    //         return -1;
    //     }
    //     int front = ll.removeFirst();
    //     return front;
    //   }
      

    //   public int peek() {
    //     if(ll.isEmpty()) {
    //         System.out.println("queue is empty");
    //         return -1;
    //     }

    //     return ll.getFirst();
    //   }
        
    // }


    // static class QueueS {

    //     Stack<Integer> s1 = new Stack<>();
    //     Stack<Integer> s2 = new Stack<>();

    //     public boolean isEmpty() {
    //         return s1.isEmpty();
    //     }

    //     public void add(int data) {
    //         while(!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }

    //         s1.push(data);

    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }

    //     public int remove() {

    //         if(s1.isEmpty()) {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }

    //      public int peek() {

    //         if(s1.isEmpty()) {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }


    // static class Stack {
    //     Queue<Integer> q1 = new LinkedList<>();
    //     Queue<Integer> q2 = new LinkedList<>();


    //     boolean isEmpty() {
    //         return q1.isEmpty();
    //     }

    //     void push(int data) {

    //         while(!q1.isEmpty()){
    //             q2.add(q1.remove());
    //         }

    //         q1.add(data);

    //         while(!q2.isEmpty()) {
    //             q1.add(q2.remove());
    //         }
    //     }

    //     int pop() {
    //         if(q1.isEmpty()) {
    //             System.out.println("stack is empty");
    //             return -1;
    //         }

    //         return q1.remove();
    //     }

    //     int peek() {
    //         if(q1.isEmpty()) {
    //             System.out.println("stack is empty");
    //             return -1;
    //         }
             
    //         return q1.peek();
    //     }



    // }


    public static void interLeave(Queue<Integer> q) {

        Queue<Integer> firstHalf= new LinkedList<>();

        int size = q.size()/2;
        
        for(int i=0; i<size; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

     public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<k; i++) {
            s.push(q.remove());
        }
        
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
        
        int size = q.size()-k;
        for(int i=0; i<size; i++) {
            q.add(q.remove());
        }
        return q;
        
    }

    public static Queue<Integer> reverseQue(Queue<Integer> q) {

        Stack<Integer> s = new Stack<>();
        int size = q.size();

        for(int i=0; i<size; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;

        // reverseFirstK(q, k);

        reverseQue(q);

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // System.out.println(q.size()/2);
       
        // interLeave(q);
        while(! q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
           
        }
       



        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);

        //  while(! s.isEmpty()) {
        //     System.out.println(s.peek() + " ");
        //     s.pop();
        // }
        //  System.out.println(s.isEmpty());



        // QueueS qs = new QueueS();
        // qs.add(1);
        // qs.add(2);
        // qs.add(3);
        // qs.add(4);

        // while(! qs.isEmpty()) {
        //     System.out.print(qs.peek() + " ");
        //     qs.remove();
        // }
        // System.out.println(qs.isEmpty());



        // Queuel ql = new Queuel();
        // ql.add(2);
        // ql.add(3);
        // ql.add(4);
        // ql.add(5);

        // while(! ql.isEmpty()) {
        //     System.out.print(ql.peek() + " ");
        //     ql.remove();
        // }



        // CirculerQueue cq = new CirculerQueue(4);
        // cq.add(1);
        // cq.add(2);
        // cq.add(3);
        // cq.add(4);
        // cq.add(5);

        // while (!cq.isEmpty()) {
        //     System.out.print(cq.peek() + " ");
        //     cq.remove();
        // }

        // Queue q = new Queue(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);

        // while (!q.isEmpty()) {
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }

    }
}
