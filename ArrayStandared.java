import java.util.HashSet;

public class ArrayStandared {

    public static int trappingRainWater(int height[]) {

        // calculate left max boundary
        int leftMax [] = new int[height.length];
        leftMax[0] = height[0];

        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }


        // CALCULATE RIGHT MAX BOUNDARY
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];

        for(int i=height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // WATER LEVEL
        int trappedWater = 0;
        for(int i=0; i<height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }


        return trappedWater;
    }

    public static int buyAndSellStocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<price.length; i++) {
            if(buyPrice < price[i]) {
              int profit = price[i] - buyPrice;
              maxProfit = Math.max(maxProfit, profit);
            }else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }


    public static int arraysPracticeQ1(int prices[]) {
        int buy = Integer.MAX_VALUE;
        int maxProfit= Integer.MIN_VALUE;

        for(int i=0; i<prices.length; i++) {
            if(buy < prices[i]) {
                int  profit = prices[i] - buy;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buy = prices[i];
            }
        }

        if(maxProfit > 0) {
            return maxProfit;
        } 
        return 0;
    }


    public static int arraysPracticeQ2(int height[]) {
        
        int n = height.length;

        // calculate LEFT MAX BOUNDARY
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // CALCULATE RIGHT MAX BOUNDARY
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;

        for(int i=0; i<n; i++) {
            // CALCULATE WATER LEVEL
            int waterLevel = Math.min(leftMax[i], rightMax[i]) * 1;
            trappedWater += waterLevel- height[i];
        }
        return trappedWater;
    }

    public static boolean arraysPracticeQ3BrutforceApp(int nums[]) { // O(n2)
            for(int i=0; i<nums.length; i++) {
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[i] == nums[j]) {
                        return true;
                    }
                }

            }
            return false;
    }


    public static boolean arraysPracticeQ3(int nums[]) {  // O(n)
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }
    public static void main(String[] args) {   
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        // System.out.println(trappingRainWater(height));
        
        // int nums[] = {1, 2, 3, 1};   // true
        int nums[] = {1, 2, 3, 4};  // false
        // int nums[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        // System.out.println(arraysPracticeQ3BrutforceApp(nums));
           System.out.println(arraysPracticeQ3(nums));

        // int price[] = {7, 1, 5, 3, 6, 4};
        // int price[] = {7, 6, 4, 3, 1};
        // System.out.println("max profit is " + arraysPracticeQ1(price));


        // int height[] = {4, 2, 0, 3, 2, 5};
        // int height[] = {0 , 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println("traaped water " + arraysPracticeQ2(height));

        // int price[] = {7, 1, 5, 3, 6, 4};
        // System.out.println(buyAndSellStocks(price));
    }
}
