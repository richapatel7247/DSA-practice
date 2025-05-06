import java.util.*;
public class AllPrimesInRange {

    public static boolean isPrime(int n) {
        if(n == 2) {
            return true;
        }
        for(int i=2; i<n; i++) {
            if(n % i == 0) {
               return false;
            }
        }
        return true;
    }

    public static void allPrimesInRange(int range) {
        for(int i=2; i<=range; i++) {
         if(isPrime(i)) {
            System.out.println(i);
         }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter range");
        int range = sc .nextInt();

         allPrimesInRange(range);
    }
}