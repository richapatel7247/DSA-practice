import java.util.*;
public class Binary_Decimal {

    public static int binaryToDecimal(int n) {
        int dec = 0;
        int pow = 0;
        while(n > 0) {
            int rem = n % 10;
            dec = dec + rem *(int) (Math.pow(2, pow));
            pow++;
            n = n / 10;
        }
        return dec;
    }

    public static int decToBin(int n) {
        int bin = 0;
        int pow = 0;
        while(n > 0) {
            int rem = n % 2;
            bin = bin + rem * (int)Math.pow(10, pow);
            pow++;
            n = n / 2;
        }
        return bin;
    }
    public static void main(String[] args) {
        // System.out.println(binaryToDecimal(101));
        System.out.println(decToBin(15));
    }
}
