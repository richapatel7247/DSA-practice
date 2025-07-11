import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;
public class QueuePrac {

    public static int decToBin(int n) {
       int binNo = 0;
       int pow = 0;

       while(n > 0) {
        int rem = n % 2;

        binNo = binNo + (int) (rem * Math.pow(10,pow));
        n = n / 2;
        pow++;

       }
       return binNo;
    }

    public static void que1(int n) {
        Queue<Integer> q = new LinkedList();

        for(int i=1; i<=n; i++) {
            q.add(decToBin(i));
        }

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }


    public static int  connectNRopes(int arr[]) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int rope : arr) {
            q.add(rope);
        }

        int cost = 0;

        while(q.size() > 1) {

            int first = q.remove();
            int sec = q.remove();

            int sum = first + sec;
            q.add(sum);
            cost += sum;
        }
        return cost;
    }


    static class Job {
        char jobId;
        int deadline;
        int prof;

        Job(char jobId, int deadline, int prof) {
            this.jobId = jobId;
            this.deadline = deadline; 
            this.prof = prof;
        }

    }

    public static void jobSequencingProb(Job jobs[]) {

        // jobs.sort((a, b) -> b.profit - a.profit);

        // int maxD = 0;
        // for(Job job : jobs) {
        //     if(maxD < job.deadline) {
        //         maxD = job.deadline;
        //     }
        // }

        // char schedule[] = new char[maxD+1];
        // boolean isFilled[] = new boolean[maxD + 1];

        // int totalProfit = 0;
        // int jobCount = 0;

        // for(Job job : jobs) {
        //     for(int t=job.deadline; t>0; t--) {
        //         if(!isFilled[t]) {
        //             isFilled[t] = true;
        //             schedule[t] = job.jobId;
        //             totalProfit += job.prof;
        //             jobCount++;
        //             break;
        //         }
        //     }
        // }

        // System.out.println("total jobs used " + jobCount);
        // System.out.println("total profit " + totalProfit);

        // for(char job: schedule) {
        //     System.out.println(job + " ");
        // }
    }

    public static void reverseQkEle(int Q[], int k) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        for(int ele: Q) {
            q.add(ele);
        }

        int size = q.size();

        for(int i=0; i<k; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        for(int i=0; i<size-k; i++) {
            q.add(q.remove());
        }


        while (!q.isEmpty()) {
          System.out.print(q.remove() + " ");
        }
    }


    public static void maxInSubarray(int arr[], int k) {

        int max[] = new int[arr.length-k+1];
        for(int i=0; i<=arr.length-k; i++) {
            int maxEle = arr[i];
            for(int j=i;j< i + k; j++) {
                maxEle = Math.max(maxEle, arr[j]);
            } 
            max[i] = maxEle;
        }

        for(int ele: max) {
            System.out.print(ele + " ");
        }
    }
    public static void main(String[] args) {
    // int Q[] = {10, 20, 30, 40, 50, 60, 70,80, 90, 100};
    // int k = 5;

    // reverseQkEle(Q, k);




    
    int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    int k = 3;
    maxInSubarray(arr, k);



    //     Job jobs[] = {new Job('a', 4, 20),
    //     new Job('b', 1, 10),
    //     new Job('c', 1, 40),
    //     new Job('d', 1, 30)
    // };

    // jobSequencingProb(jobs);


    //     int arr[] = {1 ,2, 3};

    //    System.out.println(connectNRopes(arr));
        // int n = 2;
        // que1(n);  
    }
}

