public class LinklistAdvance {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode tail;
    public static ListNode head;
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
             return true;
            }
       }
       return false;
    }

    public static void removeCycle() {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while( fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {
                  isCycle = true;
                  break;
                }
        }

        if(isCycle == false) {
            return;
        }

        slow = head;
        ListNode prev = null;
        while(slow != fast) {
         prev = fast;
         slow = slow.next;
         fast = fast.next;
        }
        prev.next = null;   
    }

    public static ListNode removeCycle2(int pos) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while( fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {
                  isCycle = true;
                  break;
                }
        }

        if(isCycle) {
            slow = head;
            while(slow != fast) {
             slow = slow.next;
             fast = fast.next;
            }
            return fast;
        }
        return null;
       
    }
    public static ListNode buildLl(int arr[], int pos) {
        head = new ListNode(arr[0]);
        ListNode curr = head;
         
        for(int i=1; i<arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        int i = 0;
        ListNode temp = head;
        while(i < pos) {
            temp = temp.next;
            i++;
        }
        curr.next = temp;
        return head;
    }

    public static void main(String[] args) {
      int arr[] = {3,2,0,-4};
      int  pos = 1;
      ListNode head = buildLl(arr, pos);
    //   System.out.println("tails connects to node index " + removeCycle2(pos));
    }
    
}
