public class ArraysPractice {

    public static int linearSearch( int arr[], int n) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public static int largest(int arr[]) {
        Integer largestNum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
          if(arr[i] > largestNum) {
            largestNum = arr[i];
          }
        }
        return largestNum;
    }

    public static int smallest(int arr[]) {
        Integer smallestNum = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < smallestNum) {
                smallestNum = arr[i];
            }
        }
        return smallestNum;
    }

    public static int binarySearch(int arr[], int n) {
        int start = 0;
        int end = arr.length;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == n) {
                return mid;
            } else if(n < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return  -1; 
    }

    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void pairsInArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print(" (" + arr[i] + ", " + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void printSubArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                System.out.print(" {");
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.print("} ");
            }
            System.out.println();
        }
    }

    public static int maxSubArraySum(int arr[]) {
        Integer maxSum = Integer.MIN_VALUE;
    
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                 for(int k=i; k<=j; k++) {
                    sum += arr[k];
                }
                if(maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int prifixSubArraySum(int arr []) {
        int maxSum = Integer.MIN_VALUE;
        int prefixArr [] = new int[arr.length];
        prefixArr[0] = arr[0];
        
        for(int i=1; i<arr.length; i++) {
           prefixArr[i] = prefixArr[i-1] + arr[i];
        }

        for(int i=0; i<arr.length; i++) {

            for(int j=i; j<arr.length; j++) {
                int currSum = i == 0 ? prefixArr[j] : prefixArr[j] - prefixArr[i - 1];
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static int kadanes(int arr[]) {
        int maxsum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<arr.length; i++) {
            currSum = currSum + arr[i];

            if(currSum < 0) {
                currSum = 0;
            }

            maxsum = Math.max(maxsum, currSum);
        }

        return maxsum;
    }


    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int num[] = {2, 4, 6, 8, 10};
        // int num[] = {1, -2, 6, -1, 3};

        // printSubArray(num);

        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("max sum is : " + kadanes(arr));

        // System.out.println("max sum = " + maxSubArraySum(num));

        // System.out.println("max sum = " +prifixSubArraySum(num));

        // pairsInArray(num);

        // reverseArray(num);
        // printArray(num);

        // System.out.println(binarySearch(num, 14));

        // System.out.println(smallest(num));

        // System.out.println(linearSearch(num, 40));

        // System.out.println(largest(num));
    }
}
