public class Backtracking {
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
       System.out.println();
    }

    public static void changeArr(int arr[], int i, int val) {
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
    }
    
    public static void findSubSet(String str, String ans, int i) {
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            } else{
                System.out.println(ans);
            }
            return;
        }
        findSubSet(str, ans + str.charAt(i), i+1);
        findSubSet(str, ans, i+1);
    }

    public static void findPermutation(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+ch);   
        }
    }

    static int count = 0;
    public static int gridWays(int x, int y, int n, int m) {
 
        if(x == n-1 && y == m-1) {
            return 1;
        }
        if(x == n || y == m) {
            return 0;
        }
        int way1 = gridWays(x + 1, y, n, m);
        int way2 = gridWays(x, y + 1, n, m);
        return way1 + way2;
    }

    public static int factorial(int n) {

        if(n == 0 || n == 1) {
            return 1;
        }

        int fact = n * factorial(n-1);
        return fact;
    }

    public static int gridWays1(int n, int m) {
        int factnm1 = factorial(n-1);
        int factmm1 = factorial(m-1);
        int factnm1plusmm1 = factorial((n-1) + (m-1));

        return (factnm1plusmm1) / (factnm1 * factmm1);
    } 


    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
         
        // String str = "abc";
        // findSubSet(str, "", 0);
        // findPermutation(str, "");

        int n = 3;
        int m = 3;
       
        // System.out.println(gridWays(0, 0, n, m));
        System.out.println(gridWays1(n, m));

    }
}
