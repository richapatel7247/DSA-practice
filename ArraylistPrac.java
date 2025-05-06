import java.util.ArrayList;
public class ArraylistPrac {

    public static boolean monotonic(ArrayList<Integer> list) {
        boolean inc = true;
        boolean dec = true;

        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                inc = false;
            } else{
                if(list.get(i) < list.get(i+1)) {
                    dec = false;
                }
            } 
        }

        return inc || dec;
    }

    public int mostFrequent(ArrayList<Integer>nums,int key) {
        int[]result = new int[1000];
        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i) == key) { 
                result[nums.get(i+1)-1]++;
            }
        }
        int max  =Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<1000; i++){
            if(result[i] > max){
                max = result[i];
                ans = i+1;
            }
        }
        return ans;
    }

   
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        System.out.println(monotonic(list));
    }
}
