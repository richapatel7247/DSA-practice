public class function {

    public static int fatorial(int n) {
        if(n == 1) {
            return 1;
        }

        int fact = n * fatorial(n - 1);
        return fact;
    }

    public static int binomialCoff(int n, int r) {

        int fact_n = fatorial(n);
        int fact_r = fatorial(r);
        int fact_nmr = fatorial(n - r);
        int n_c_r = (fact_n) / (fact_r * (fact_nmr));

        return n_c_r;
    }
    public static void main(String args[]) {
      System.out.println(binomialCoff(5, 2));
       
    }
}
