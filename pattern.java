public class pattern {
    public static void main(String[] args) {
        int n = 5;

        // PALINDROMIC PATTERN

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int k=i; k>=1; k--) {
                System.out.print(k);
            }
            for(int l=2; l<=i; l++) {
                System.out.print(l);
            }
            System.out.println();
        }



        //     1
        //    2 2 
        //   3 3 3 
        //  4 4 4 4 
        // 5 5 5 5 5 

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int k=1; k<=i; k++) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }




        // DIAMOND PATTERN 

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n-i; j++) {
        //         System.out.print("  ");
        //     }
        //     for(int k=1; k<=(2*i)-1; k++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // for(int i=n; i>=1; i--) {
        //     for(int j=1; j<=n-i; j++) {
        //         System.out.print("  ");
        //     }
        //     for(int k=1; k<=(2*i)-1; k++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }




        // // HOLLOW RHOMBUS

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n-i; j++) {
        //         System.out.print("  ");
        //     }

        //     for(int k=1; k<=n; k++) {
        //         if(k == 1 || i == 1 || k == n || i == n) {
        //             System.out.print("* ");
        //         }
        //         else {
        //             System.out.print("  ");
        //         }
        //     }

        //     System.out.println();
        // }




        // SOLID RHOMBUS

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n-i; j++) {
        //         System.out.print("  ");
        //     }
        //     for(int k=1; k<=n; k++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }





        // BUTTERFLY  PATTERN

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     for(int k=1; k<=(n-i)*2; k++) {
        //         System.out.print("  ");
        //     }
        //     for(int l=1; l<=i; l++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // for(int i=n; i>=1; i--) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     for(int k=1; k<=(n-i)*2; k++) {
        //         System.out.print("  ");
        //     }
        //     for(int l=1; l<=i; l++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }





        // 1
        // 0 1
        // 1 0 1
        // 0 1 0 1
        // 1 0 1 0 1

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=i; j++) {
        //         if( (i + j) % 2 == 0) {
        //             System.out.print("1");
        //         } else {
        //             System.out.print("0");
        //         }
        //     }
        //     System.out.println();

        // }




        // 1 
        // 2 3
        // 4 5 6
        // 7 8 9 10
        // 11 12 13 14 15

        // int count = 1;

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=i; j++) {
        //        System.out.print(count + " ");
        //        count++;
        //     }
        //     System.out.println();
        // }


        // 1 2 3 4 5 
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n-i+1; j++) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }



        //         *
        //       * *
        //     * * *
        //   * * * *
        // * * * * *

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int k=1; k<=i; k++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }



        // * * * * * 
        // *       *
        // *       *
        // *       *
        // * * * * *

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n; j++) {
        //         if(j == 1 || i == 1 || j == n || i == n) {
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }




        // A
        // B C
        // D E F
        // G H I J
        // K L M N O
        // char ch = 'A';

        // for(int i=1; i<=n; i++) {
        //   for(int j=1; j<=i; j++) {
        //     System.out.print(ch + " ");
        //     ch++;
        //   }
        //   System.out.println();
        // }




        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5

        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }



        // * * * * *
        // * * * * 
        // * * * 
        // * * 
        // *

        // for(int i=1; i<=n; i++) {
        //     for(int j=n; j>=i; j--) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }



        // *
        // * * 
        // * * * 
        // * * * * 
        // * * * * *

        // for(int i=1; i<=n; i++) {
        //    for(int j=1; j<=i; j++) {
        //      System.out.print("* ");
        //    }
        //    System.out.println();
        // }



        // * * * * * 
        // * * * * * 
        // * * * * * 
        // * * * * * 
        // * * * * * 
        
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
    }
}
