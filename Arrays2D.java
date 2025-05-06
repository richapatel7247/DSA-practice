public class Arrays2D {

    public static void spiralMatrix(int arr[][]) {
       int startRow = 0;
       int startCol = 0;
       int endRow = arr.length-1;
       int endCol = arr[0].length-1;

       while(startRow <= endRow && startCol <= endCol) {
        // TOP
        for(int i=startRow; i<=endCol; i++) {
            System.out.print(arr[startRow][i] + " ");
        }

        // right
        for(int i=startRow+1; i<=endRow; i++) {
           System.out.print(arr[i][endCol] + " ");
        }

        // BOTTOM
        for(int i=endCol-1; i>=startCol; i--) {
            if(startRow == endRow) {
                break;
            }
            System.out.print(arr[endRow][i] + " ");
        } 
 
        // LEFT
        for(int i=endRow-1; i>=startRow+1; i--) {
            if(startCol == endCol) {
                break;
            }
            System.out.print(arr[i][startCol] + " ");
        }
        startRow++;
        startCol++;
        endRow--;
        endCol--;
       }
    }

    public static int diagonalSum(int arr[][]) { // O(n2)
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                // FOR PRIMARY DIAGONAL
                if(arr[i] == arr[j]) {
                    sum += arr[i][j];
                } // FOR SECONDARY DIAGONAL
                else if( i + j == arr.length-1) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int diagonalSumEffSol(int arr[][]) {  // O(n)
        int sum = 0;
        int n = arr.length-1;

        for(int i=0; i<=n; i++) {
            sum += arr[i][i];
            sum += arr[i][n - i];
        }
        return sum;
    }

    public static boolean searchInSortedArr(int matrix[][], int key) {
        int row = 0; 
        int col = matrix.length-1;

        while (row <= matrix.length-1 && col >=0) {
            if(key == matrix[row][col]) {
                System.out.println(row + " , " + col);
                return true;
            }
            else if(key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static int practiceQ1(int arr[][], int num) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length;j++) {
                if(num == arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int practiceQ2(int arr[][], int row) {
        int sum = 0;
           for(int i=0; i<arr.length; i++) {
            sum += arr[row-1][i];
           }

        return sum;   
    }


    public static void transposeMatrix(String matrix[][]) {
        String transArr[][] = new String[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
               transArr[j][i] = matrix[i][j];
            }
        }

        for(int i=0; i<transArr.length; i++) {
            for(int j=0; j<transArr[0].length; j++) {
               System.out.print(transArr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
           String matrix[][] = {
            {"a11", "a12", "a13"},
            {"a21", "a22", "a23"}
           };
           transposeMatrix(matrix);


        // int[][] nums = { {1,4,9},
        //         {11,4,3},
        //         {2,2,3}
        //     };   
        //     int row = 3;  
        //     System.out.println("sum of the " + row  + " row is " + practiceQ2(nums, row));


        // int arr[][] ={
        //     {4, 7, 8},
        //     {8, 8, 7}
        // };
        // System.out.println(practiceQ1(arr, 7));


        // int matrix[][] = {
        //     {10, 20, 30, 40},
        //     {15, 25, 35, 45},
        //     {27, 29, 37, 48},
        //     {32, 33, 39, 50}
        // };
        // int key = 33;

        // System.out.println(searchInSortedArr(matrix, key));



        // int arr[][] = {
        //     {1, 2, 3, 4},
        //     {5, 6, 7, 8},
        //     {9, 10, 11, 12},
        //     {13, 14, 15, 16}
        // };

        // System.out.println("diagonal sum = " + diagonalSum(arr));
        // System.out.println("diagonal sum = " + diagonalSumEffSol(arr));

        // int arr[][] = {
        //     {1, 2, 3, 4},
        //     {5, 6, 7, 8},
        //     {9, 10, 11, 12},
        //     {13, 14, 15, 16}
        // };

        // spiralMatrix(arr);

    }
}
