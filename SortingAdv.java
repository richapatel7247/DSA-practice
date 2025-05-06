public class SortingAdv {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
}
public static void mergeSort(int arr[], int si, int ei) {
    if(si >= ei) {
        return;
    }
    int mid = si + (ei-si) / 2;
    mergeSort(arr, si, mid);
    mergeSort(arr, mid+1, ei);

    mergeArr(arr, si, mid, ei);
}

public static void mergeArr(int arr[], int si, int mid, int ei) {
    int temp[] = new int[ei - si + 1];
    int i = si;
    int j = mid+1;
    int k = 0;

    while (i <= mid && j <= ei) {
        if(arr[i] < arr[j]) {
            temp[k] = arr[i];
            i++;
        } else {
            temp[k] = arr[j];
            j++;
        }
        k++;
    }

    while (i<=mid) {
        temp[k++] = arr[i++];
    }

    while (j<=ei) {
        temp[k++] = arr[j++];
    }

    for(int p=0, q = si; p<temp.length; p++, q++) {
        arr[q] = temp[p];
    }
}

public static void quickSort(int arr[], int si, int ei) {
    if(si >= ei) {
        return;
    }

    int pivotIdx = partition(arr, si, ei);
    quickSort(arr, si, pivotIdx-1);
    quickSort(arr, pivotIdx+1, ei);
}

public static int partition(int arr[],int si, int ei) {
    int pivot = ei;
    int i = si-1; 

    for(int j=si; j<ei; j++) {
        if(arr[j] < arr[pivot]) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    i++;
    int temp = arr[pivot];
    arr[pivot] = arr[i];
    arr[i] = temp;
    return i;
}

public static int searchSortedRotatedArr(int arr[], int si, int ei, int target) {
    if(si > ei) {
        return -1;
    }
    int mid = si + (ei-si)/2;

    if(target == arr[mid]) {
        return mid;
    }

    if(arr[si] <= arr[mid]) {
       if(arr[si] <= target && target <= arr[mid]) {
         return searchSortedRotatedArr(arr, si, mid-1, target);
       } else {
        return searchSortedRotatedArr(arr, mid+1, ei, target);
       }
    } else {
        if(arr[mid] <= target && target <= arr[ei]) {
           return searchSortedRotatedArr(arr, mid+1, ei, target);
        } else {
           return searchSortedRotatedArr(arr, si, mid-1, target);
        }
    }
}



    public static void main(String[] args) {
        // int arr[] = {6, 3, 9, 5, 2, 8};
        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        // printArr(arr);

        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // System.out.println(searchSortedRotatedArr(arr, 0, arr.length-1, 7));
    }
}
