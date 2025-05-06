public class NQueens {

    public static boolean isSafe(char board[][], int row, int col) {

        // VERTICALLY UP
       for(int i=row-1; i>=0; i--) {
        if(board[i][col] == 'Q') {
            return false;
        }
       }

       // VERTICALLY LEFT DIAGONAL 
       for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
        if(board[i][j] == 'Q') {
            return false;
        }
       }

       // VERTICALLY RIGHT
       for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
        if(board[i][j] == 'Q') {
            return false;
        }
       }
       return true;
    }
    public static boolean nQueens(char board[][], int row) {
        if(row == board.length) {
            // printBoard(board);
            // count++;
            return true;
        }

        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(nQueens(board, row+1)) {
                    return true;
                }
                board[row][j] = 'X';
            }
        }
        return false;
    }

    static int count = 0;

    public static void printBoard(char board[][]) {
        int n = board.length;
        System.out.println("------------ chess board ---------");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = 'X';
            }
        }

        // nQueens(board, 0);
        
        if(nQueens(board, 0)) {
            System.out.println("solution is possible");
            printBoard(board);
        } else {
            System.out.println("solution is not possible");
        }
        // System.out.println("total no. of ways = " + count);
    }
}
