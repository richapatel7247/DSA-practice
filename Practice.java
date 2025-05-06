import java.util.*;
public class Practice {

    public static boolean checkPalindrom(String str) {
        int n = str.length();
        for(int i=0; i<n/2; i++) {
          if(str.charAt(i) != str.charAt(n-1-i)) {
            return false;
          }
        }

        return true;
    }

    public static double shortestPath(String path) {
      int x = 0, y = 0;
        for(int i=0; i<path.length(); i++) {

          char dir = path.charAt(i);

          if(dir == 'W') {
            x--;
          } else if(dir == 'E') {
            x++;
          } else if(dir == 'N') {
            y++;
          } else if(dir == 'S') {
            y--;
          }
        }
        int X = x * x;
        int Y = y * y;
      return Math.sqrt(X + Y);
    }

    public static String fstLtrWToUpperCase(String str) {
      StringBuilder sb = new StringBuilder();
      char ch = Character.toUpperCase(str.charAt(0));
      sb.append(ch);
        for(int i=1; i<=str.length()-1; i++) {
         char ch1 = str.charAt(i);
         if(ch1 == ' ' && i < str.length()-1) {
          sb.append(ch1);
          i++;
          sb.append(Character.toUpperCase(str.charAt(i)));
         } else {
          sb.append(ch1);
         }
        }

        return sb.toString();
    }

    public static String compresion(String str) {
      String sb = "";
      for(int i=0; i<str.length(); i++) {
        Integer count = 0;
        char ch = str.charAt(i);
        count++;
        while (i < str.length()-1 && ch == str.charAt(i + 1)) {
          count++;
          i++;
        }
        sb = sb + ch;

        if(count > 1) {
          sb = sb + count.toString();
        }
      }
      return sb;
    }

    public static String compresionBySB(String str) {
      StringBuilder sb = new StringBuilder();

      for(int i=0; i<str.length(); i++) {
        Integer count = 0;
        char ch = str.charAt(i);
        count++;
        while(i < str.length()-1 && ch == str.charAt(i + 1)) {
          count++;
          i++;
        }
        sb.append(ch);
        if(count > 1) {
           sb.append(count.toString());
        }
      }
      return sb.toString();
    }

    public static boolean anagramStr(String str1, String str2) {
      if(str1.length() != str2.length()) {
        return false;
      }

      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();

      char str1Array[] = str1.toCharArray();
      char str2Array[] = str2.toCharArray();
      Arrays.sort(str1Array);
      Arrays.sort(str2Array);

      if(Arrays.equals(str1Array, str2Array)) {
        return true;
      }

      return false;
    }

    public static int lowerCaseVowels(String str) {
      int count = 0;
      for(int i=0; i<str.length(); i++) {
        char ch = str.charAt(i);
        if(ch == 'a') {
         count++;
        } else if(ch == 'e') {
          count++;
        } else if(ch == 'i') {
          count++;
        } else if(ch == 'o') {
          count++;
        } else if(ch == 'u') {
          count++;
        }
      }
      return count;
    }

    public static int largestOfThree(int a, int b, int c) {

      if(a >= b && a >= c) {
        return a;
      } else if(b >= c) {
        return b;
      } 
      return c;
    }


    public static int reverseNumber(int n) {
      int res = 0;
      
      while(n > 0) {
      int rem = n % 10;
      res = (res * 10) + rem;
      n = n / 10;
      }
      return res;
    }

    public static void sumOfOddOrEven() {
      int n, choice;
      int evenSum = 0;
      int oddSum = 0;

      do {
        System.out.println("enter number ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n % 2 == 0) {
          evenSum += n;
        } else {
          oddSum += n;
        }
        System.out.println("do you want to break if yes type 1:");
        choice = sc.nextInt();
        if(choice == 1) {
          break;
        }
      } while(true);
      System.out.println("sum of even numbers = " + evenSum);
      System.out.println("sum of odd numbers = " + oddSum);

    }

    public static int factorial(int n) {

      int fact = 1;
      for(int i=1; i<=n; i++) {
        fact *= i;
      }
      // if(n == 1) {
      //   return 1;
      // } 
      // fact = n * factorial(n - 1);
      return fact;
    }
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      // System.out.println(factorial(7));

      int n = 15;

      // sumOfOddOrEven();

      for(int i=1; i<=10; i++) {
        System.out.println(n * i);
      }
     
      // do{
      //   n = sc.nextInt();
      //   if(n % 10 == 0) {
      //     continue;
      //   }
      //   System.out.println("your number was " + n);
      // } while(true);


      // do {
      //   n = sc.nextInt();
      //   if( n % 10 != 0) {
      //     break;
      //   }

      // } while(true);



      // int n = 10899;
      // System.out.println("reverse of a number " + n +  " is = " + reverseNumber(n));

      // System.out.println(largestOfThree(400, 400, 40));

      // System.out.println("enter str : ");
      // String str = sc.next();
      // System.out.println(lowerCaseVowels(str));

      // String str = "raceecar";
      // System.out.println(checkPalindrom(str));

      // String path = "WNEENESENNN";
      // System.out.println(shortestPath(path));

      // String str1 = "hi, i am richa  ";
      // System.out.println(fstLtrWToUpperCase(str1));
   
      // String str2 = "abeeebbbcceecccdd";
      // System.out.println(compresion(str2));
      // System.out.println(compresionBySB(str2));

      // String str1 =  "race"; //"earth";
      // String str2 = "care";    // "heart";
      // System.out.println(anagramStr(str1, str2));

      // String str = "ShradhaDidi";
      // String str1 = "ApnaCollege";
      // String str2 = "ShradhaDidi";
      // System.out.println(str.equals(str1) + " " + str.equals(str2));

      // String str = "ApnaCollege".replace("l", "");
      // System.out.println(str);
    }
}
