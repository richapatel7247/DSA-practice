public class Practice2 {

    public static int avg(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static boolean isPalindrom(int n) {
        int num = n;
        int palNum = 0;
        boolean isPalNum = true;
        while(n > 0) {
            int rem = n % 10;
            palNum = palNum  * 10 + rem;
            n = n / 10;
        }
        if(num != palNum) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int a = 1, b = 3, c = 5;
        // System.out.println(avg(a, b, c));
        System.out.println(isPalindrom(287482));
    }
}
