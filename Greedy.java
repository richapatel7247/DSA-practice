import java.util.*;
public class Greedy {

    private static void activitySelection(int start[], int end[]) {
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i=0; i<end.length; i++) {
            if(lastEnd <= start[i]) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        for(int i=0; i<ans.size(); i++) {
            System.out.println("A" + ans.get(i) + " ");
        }
    }

    public static int knapsack(int val[], int weight[], int capacity) {

        double ratio[][] = new double[val.length][2];

        for(int i=0; i<val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int ans = 0;

        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];

            if(capacity >= weight[idx]) {
                ans += val[idx];
                capacity -= weight[idx];
            } else {
                ans += capacity * ratio[i][1];
                capacity = 0;
                break;
            }
        }
        return ans;
    }

    private static int absoluteDifference(int A[], int B[]) {
        int sumOfMinDiff = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
           sumOfMinDiff += Math.abs(A[i] - B[i]);
        }

        return sumOfMinDiff;
    }

    private static int chainPair(int arr[][]) {
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
        int ans = 0;
        int lastEnd = 0;

        for(int i=0; i<arr.length; i++) {
            if(lastEnd <= arr[i][0]) {
                ans++;
                lastEnd = arr[i][1];
            }
        }

        return ans;
    }

    private static int indianCoins(Integer arr[], int amount) {
        Arrays.sort(arr, Collections.reverseOrder());
        ArrayList<Integer> coinsAns = new ArrayList<>();
        int ans = 0;

        for(int i=0; i<arr.length; i++) {
            while(amount >= arr[i]) {
                ans++;
                coinsAns.add(arr[i]);
                amount -= arr[i];
            }
        }

        for(int i=0; i<coinsAns.size(); i++) {
            System.out.print(coinsAns.get(i) + " ");
        }
        return ans;
    }
    public static void main(String args[]) {

        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        System.out.println(indianCoins(coins, 590));

        // int arr[][] = {
        //     {5, 24},
        //     {39, 60},
        //     {5, 28},
        //     {27, 40},
        //     {50, 90}
        // };

        // System.out.println(chainPair(arr));



        // int A[] = {4, 1, 8, 7};
        // int B[] = {2, 3, 6, 5};

        // System.out.println(absoluteDifference(A, B));



        // int val[] = {60, 100, 120};
        // int weight[] = {10, 20, 30};
        // int capacity = 50;

        // System.out.println( knapsack(val, weight, capacity));






        // int start[] = {10, 12, 20};
        // int end[] = {20, 25, 30};

        // activitySelection(start, end);
    }
}
