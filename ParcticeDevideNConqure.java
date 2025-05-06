public class ParcticeDevideNConqure {
    public static void printArr(String str[]) {
        for(int i=0; i<str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

   public static String[] mergeSort(String arr[], int si, int ei) {
    if(si == ei) {
        String A[] = {arr[si]};
        return A;
    }
    int mid = si + (ei - si)/2;
    String arr1[] = mergeSort(arr, si, mid);
    String arr2[] = mergeSort(arr, mid+1, ei);
    String arr3[] = merge(arr1, arr2);
    return arr3;
   }

   public static String[] merge(String arr1[], String arr2[]) {
    int m = arr1.length;
    int n = arr2.length;
    String arr3[] = new String[m + n];

    int i = 0;
    int j = 0;
    int idx = 0;

    while (i < m && j < n) {
        if(isAlphabeticallySmaller(arr1[i], arr2[j])) {
            arr3[idx] = arr1[i];
            i++;
            idx++;
        } else {
            arr3[idx] = arr2[j];
            j++;
            idx++;
        }
    }

    while (i < m) {
        arr3[idx++] = arr1[i++];
    }

    while (j < n) {
        arr3[idx++] = arr2[j++];
    }
    return arr3;
   }

   public static boolean isAlphabeticallySmaller(String str1, String str2) {
    if(str1.compareTo(str2) < 0) {
     return true;
    } 
    return false;
  }

  public static int que3InvCountApp1(int arr[]) { //O(n2)
    int n = arr.length;
    int invCount = 0;

    for(int i=0; i<n-1; i++) {
        for(int j=i+1; j<n; j++) {
            if(arr[i] > arr[j]) {
                invCount++;
            }
        }
    }
    return invCount;
  }


  public static int mergeSort(int arr[], int left, int right) {
    int invCount = 0;

    if(right > left) {
        int mid = (left + right) / 2;
        invCount = mergeSort(arr, left, mid);
        invCount += mergeSort(arr, mid+1, right);
        invCount += merge(arr, left, right, mid+1);
    }
    return invCount;
  }

  public static int merge(int arr[], int left, int right, int mid) {
    int i = left;
    int j = mid;
    int k = 0;
    int invCount = 0;
    int temp[] = new int[(right - left + 1)];

    while ((i < mid) && (j <= right)) {
        if(arr[i] <= arr[j]) {
            temp[k] = arr[i];
            i++;
            k++;
        } else {
            temp[k] = arr[j];
            invCount += (mid-i);
            k++;
            j++;
        }
      
    }
    while (i<mid) {
        temp[k] = arr[i];
        i++;
        k++;
    }

    while (j<=right) {
        temp[k] = arr[j];
        j++;
        k++;
    }
    for(int l=left, m=0; l<=right; l++, m++) {
        arr[l] = temp[m];
    }
    return invCount;
  }

  public static int getInvent(int arr[]) {
    return mergeSort(arr, 0, arr.length-1);
  }
  
    public static void main(String[] args) {
        // String arr[] = {"sun", "earth", "mars", "mercury"};
        // String arr1[] = mergeSort(arr, 0, arr.length-1);
        // printArr(arr1);

        int arr[] = {2, 4, 1, 3, 5};
        // System.out.println(que3InvCountApp1(arr));
        System.out.println(getInvent(arr));
    }}
