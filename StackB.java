import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class StackB {
    // static class Stack {
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     public static boolean isEmpty() {
    //         return list.size() == 0;
    //     }

    //     public static void push(int data) {
    //         list.add(data);
    //     }

    //     public static int pop() {
    //         if(isEmpty()) {
    //             return -1;
    //         } 

    //         // int top = list.get(list.size()-1);
    //          int top = list.getLast();
    //         // list.remove(list.size()-1);
    //         list.removeLast();
    //         return top;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             return -1;
    //         }

    //         return list.getLast();
    //         // return list.get(list.size()-1);
    //     }
    // }


    // static class Stack {
    //     static LinkedList<Integer> list = new LinkedList<>();
        
    //     public static boolean isEmpty() {
    //         return list.size() == 0;
    //     }

    //     public static void push(int data) {
    //         list.addFirst(data);
    //     }

    //     public static int pop() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         int top = list.getFirst();
    //         list.removeFirst();
    //         return top;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         return list.getFirst();
    //     }
    // }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {

         Stack<Character> s = new Stack<>();
         for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            s.push(ch); 
        }

        String newStr = "";
        while (!s.isEmpty()) {
            char ch = s.pop();
            newStr = newStr + ch;
        }
        return newStr;
    }


    public static void helperReverseStack(Stack<Integer> s, int data) {

        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        helperReverseStack(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
       
        int top = s.pop();
        reverseStack(s);
        helperReverseStack(s, top); 
    }


    public static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);

        for(int i=1; i<stock.length; i++) {
            int currPrice = stock[i];
            while(!s.isEmpty() &&  currPrice >= stock[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            } 
            s.push(i);
        }

    }


    public static int[] nextGreater(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[i] > arr[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return nextGreater;
    }


    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {

                if(s.isEmpty()) {
                    return false;
                }

                if( (s.peek() == '(' &&  ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']') ) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        }
        return false;

    }

    public static boolean duplicateParantheses(String str) {
      Stack<Character> s = new Stack<>();

      for(int i=0; i<str.length(); i++) {
        char ch = str.charAt(i);

        if(ch == ')') {
          int count = 0;
          while(s.peek() != '(') {
            count++;
            s.pop();
          }

          if(count < 1) {
            return true;
          }
          s.pop();
        } else {
          s.push(ch);
        }
      }
      return false;
    }

    public static int maxAreaInHistogram(int height[]) {
        int n = height.length;
        int maxArea = 0;
        int nsl[] = new int[n];  // next smmaller left
        int nsr[] = new int[n];  // next smaller right

        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && height[s.peek()] > height[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        for(int i=0; i<n; i++) {
             while(!s.isEmpty() && height[s.peek()] > height[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            
            int currArea = height[i] * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {

        // int height[] = {2, 1, 5, 6, 2, 3};
        int height[] = {1, 4};
        System.out.println(maxAreaInHistogram(height));


    //   String str = "(a + b)";
    //   System.out.println(duplicateParantheses(str));

        // String str = "()[)";
        // System.out.println(isValid(str));


        // int arr[] = {6, 8, 0, 1, 3};
        // int nextGreater[] = new int[arr.length];
        // nextGreater(arr, nextGreater);

        // for(int i=0; i<nextGreater.length; i++) {
        //     System.out.print(nextGreater[i] + " ");
        // }
        

        // int stock[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stock.length];
        // stockSpan(stock, span);

        // for(int i=0; i<span.length; i++) {
        //     System.out.print(span[i] + " ");
        // }
        // System.out.println();



        // Stack s = new Stack();
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);

        // reverseStack(s);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String str = "abcde";
        // System.out.println(str);
        // System.out.println(reverseString(str));   
    }
}
