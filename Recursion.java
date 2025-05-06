public class Recursion {

    // PRINT NUMBERS N IN DECENDING ORDER
    public static void numInDecOrder(int n) {
        if(n == 1) {
            System.out.println(n);
            return; 
        }
        System.out.println(n);
        numInDecOrder(n-1);
    }

    // CALCULATE FACTORIAL OF N
    public static int fact(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }

        int factorial = n * fact(n-1);
        return factorial;
    }

    // CALCULATE SUM OF FIRST N NATURAL NO.
    public static int sum(int n) {
        if(n == 0) {
          return 0;
        }
        int sum = n + sum(n-1);
        return sum;
    }

    // PRINT NTH FIBONACCI NO.
    public static int fiboncciNo(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int fn = fiboncciNo(n-1) + fiboncciNo(n-2);
        return fn;
    }

    // CHECK IF A GIVEN ARRAY IS SORTED OR NOT
    public static boolean isSortedArray(int arr[], int i) {
        int n = arr.length-1;
        if(i == n) {
           return true;
        }
       if(arr[i] > arr[i+1]) {
        return false;
       }

        return isSortedArray(arr, i + 1);
    }

    // WAP TO FIND THE FIRST OCCURENCE OF AN ELEMENT IN AN ARRAY
    public static int firstOccurence(int arr[], int i, int key) {
       
        if(i == arr.length) {
            return -1;
        }

        if(arr[i] == key) {
            return i;
        } 
        return firstOccurence(arr, i+1, key);
    }

    // WAP TO FIND THE LAST OCCURENCE OF AN ELEMENT IN AN ARRAY
    public static int lastOccuence(int arr[], int key, int i) {
        if(i < 0) {
            return -1;
        }

        if(arr[i] == key) {
            return i;
        }
         
        return lastOccuence(arr, key, i-1);
    }

    // PRINT X TO THE POWER N
    public static int xToThePowerN(int x, int n) {
        if(n == 0) {
            return 1;
        }
         
       return x * xToThePowerN(x, n-1);
    }

     // PRINT X TO THE POWER N
     public static int optimixedPower(int x, int n) {
        if(n == 0) {
            return 1;
        }

        int halfPower = optimixedPower(x, n/2);
        int halfPowerSqr = halfPower * halfPower;

        if(n % 2 != 0) {
            halfPowerSqr = x * halfPowerSqr;
        }
        return halfPowerSqr;
     }

     // TILLING PROBLEM
     public static int tillingProblem(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        // place tile  vertically
        int nm1 = tillingProblem(n-1);

        // place tile horizontal
        int nm2 = tillingProblem(n-2);

        // total choice
        int totalWay = nm1 + nm2;
        return totalWay;
     }

     // REMOVE DUPLICATES IN  A STRING
     public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        
        char currChar = str.charAt(idx);
        if( map[currChar - 'a'] == true) {
            removeDuplicate(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
     }

     // FRIEND PAIRING PROBLEM
     public static int friendPairing(int n) {
        if(n==1 || n==2) {
            return n;
        }

        // for single
        int fnm1 = friendPairing(n-1);
        // for double
        int fnm2 = friendPairing(n-2);
        int pairsWay = (n-1) * fnm2;
        return fnm1 + pairsWay;
     }


     // BINARY STRING PROBLEM FOR CONSECUTIVE 1s
     public static void binaryStringProb1s(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }

        binaryStringProb1s(n-1, 0, str + '0');

        if(lastPlace == 0) {
            binaryStringProb1s(n-1, 1, str + '1');
        }
     }

     // BINARY STRING PROBLEM FOR CONSECUTIVE 0s
     public static void binaryStringProb0s(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }

        binaryStringProb0s(n-1, 1, str + '1');

        if(lastPlace == 1) {
            binaryStringProb0s(n-1, 0, str + '0');
        }
     }
    public static void main(String[] args) {
        // numInDecOrder(5);
        // System.out.println(fact(6));
        // System.out.println(sum(4));
        // System.out.println(fiboncciNo(5));
        // int arr[] = {1, 2, 3, 4};
        // System.out.println(isSortedArray(arr, 0));

        // int arr[] = {3, 3, 4, 5, 7, 5};
        // System.out.println(firstOccurence(arr, 0, 3));
        // System.out.println(lastOccuence(arr, 3, arr.length-1));

        // System.out.println(xToThePowerN(5, 3 ));
        // System.out.println(optimixedPower(2, 10));

        // System.out.println(tillingProblem(3));
        
        // String str = "appnacollege";
        // removeDuplicate(str, 0, new StringBuilder(),new boolean[26]);

        // System.out.println(friendPairing(5));

        binaryStringProb1s(2, 0, "");
        // binaryStringProb0s(2, 1, "");
    }
}
