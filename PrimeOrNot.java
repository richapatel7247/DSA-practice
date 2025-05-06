
import java.util.*;
public class PrimeOrNot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number ");
        int n = sc.nextInt();
        boolean isPrime = true;

        if(n == 2) {
          isPrime = true;
        }

        for(int i=2; i<n; i++) {
            if(n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            System.out.println("number is prime ");
        } else {
            System.out.println("number is not a prime number");
        }
    }
}


