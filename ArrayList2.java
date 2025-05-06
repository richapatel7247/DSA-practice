import java.util.ArrayList;

public class ArrayList2 {

    public static int mostWaterContainerBruteForce(ArrayList<Integer> height) { // O(n2)
        int length = height.size();
        int maxWater = Integer.MIN_VALUE;

        for(int i=0; i<length-1; i++) {
            for(int j=i+1; j<length; j++) {
                int heightWater = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int water = heightWater * width;
                maxWater = Math.max(maxWater, water);
            }
        }
        return maxWater;
    }

    public static int mostWaterContainer(ArrayList<Integer> height) {  // O(n)

        int lp = 0;
        int rp = height.size()-1;
        int maxWater = 0;

        while(lp < rp) {
            int waterHeight = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = waterHeight * width;
            maxWater = Math.max(maxWater, currWater);
            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static boolean pairSumBruteForce(ArrayList<Integer> list, int target) {  // O(n2)
        for(int i=0; i<list.size()-1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                int sum = list.get(i) + list.get(j);

                if(sum == target) {
                    System.out.println(list.get(i) + " " + list.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum(ArrayList<Integer> list, int target) {  // O(n)
        int lp = 0;
        int rp = list.size()-1;

        while (lp < rp) {
            int sum = list.get(lp) + list.get(rp);
            if(sum == target) {
                System.out.println(list.get(lp) + " " + list.get(rp));
                return true;
            } else if(sum < target) {
                lp++;
            } else {
                rp--;
            }

        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {   // O(n)

        int n = list.size();
        int pivot = -1;
        for(int i=0; i<n-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                pivot = i;
                break;
            }
        }

        int lp = pivot+1;
        int rp = pivot;

        while (lp != rp) {
         if(target == list.get(lp) + list.get(rp)) {
            return true;
         } else if(target < list.get(lp) + list.get(rp)) {
            rp = (n + rp - 1) % n;
         } else {
            lp = (lp + 1) % n;
         }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 160;


        System.out.println(pairSum2(list, target));






        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);

        // int target = 5;

        // System.out.println(pairSum(list, target));




        // ArrayList<Integer> height = new ArrayList<>();

        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
      
        // System.out.println(mostWaterContainer(height));
    }
    
}
