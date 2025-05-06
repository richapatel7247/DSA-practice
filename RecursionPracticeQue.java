public class RecursionPracticeQue {

    public static void que1(int arr[], int i, int key) {
        if(i == arr.length) {
            return;
        }

        if(arr[i] == key) {
            System.out.print(i + " ");
        }
        que1(arr, i+1, key);
    }

    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six" ,"seven", "eight", "nine"};
    public static void que2(int n) {
        if(n==0) {
            return;
        }
        int lastDigit = n%10;
        que2(n/10);
        System.out.print(digits[lastDigit] + " ");
    }

    public static int que3(String str) {
        if(str.length() == 0) {
            return 0;
        }
        return que3(str.substring(1)) + 1; 
    }

    public static void towerOfHannoi(int n, char src, char helper, char dest) {
        if(n == 1) {
            System.out.println("transfer dist " +  n  + " from " + src + " to " + dest);
            return;
        }
        towerOfHannoi(n-1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        towerOfHannoi(n-1, helper, src, dest);
    }
   
    public static void main(String[] args) {
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // int key = 20;
        // que1(arr, 0, key);

        // int number = 2000;
        // que2(number);

        // String str = "richa";
        // System.out.println(que3(str));

        String str = "abcab";

        int n = 3;
        towerOfHannoi(n, 'A', 'B', 'C');
       
    }
}
