public class BacktrackingPracticeQue {

    public static void printSolution(int solution[][]) {
        for(int i=0; i<solution.length; i++) {
            for(int j=0; j<solution[0].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int i, int j){
       return (i>=0 && j>=0 && i<maze.length && j<maze.length && maze[i][j]==1);
    }

    public static boolean solveMaze(int maze[][]) {
       int n = maze.length;
       int solution[][] = new int[n][n];

       if(solveMazeUtil(maze, 0, 0, solution)) {
        System.out.println("solution exists");
        printSolution(solution);
        return true;
       }
       return false;
    }

    public static boolean solveMazeUtil(int maze[][], int i, int j, int solution[][]){
      if(i==maze.length-1 && j==maze.length-1 && maze[i][j]==1) {
        solution[i][j] = 1;
        return true;
      }

      if(isSafe(maze, i, j)) {
        if(solution[i][j] == 1) {
            return false;
        }
        solution[i][j] = 1;
        if(solveMazeUtil(maze, i+1, j, solution)) {
            return true;
        }

        if(solveMazeUtil(maze, i, j+1, solution)) {
            return true;
        }
        solution[i][j] = 0;
        return false;
      }
      return false;
    }

    // Practice que 2
    final static char[][] arr= { {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'} };

    public static void lettersCombinations(String str)  {
        int lengthArr = str.length();
        if(lengthArr == 0) {
            System.out.println("");
            return;
        }
        else {
            lettersCombinationsUtil(0, lengthArr, new StringBuilder(), str);
        }
       
    }


    public static void lettersCombinationsUtil(int pos, int lengthArr, StringBuilder newStr, String str) {
        if(pos == lengthArr) {
            System.out.println(newStr.toString() + ' ');
        }

        else {
            char letters[] = arr[Character.getNumericValue(str.charAt(pos))];
        for(int i=0; i<letters.length; i++) {
            lettersCombinationsUtil(pos+1, lengthArr, new StringBuilder(newStr).append(letters[i]), str);
        }
        }
        
    }
      public static void main(String[] args) {

        String digit = "23";
        lettersCombinations(digit);

        // int grid [][] = {{1, 0, 0, 0},
        //             {1, 1, 0, 1},
        //             {0, 1, 0, 0},
        //             {1, 1, 1, 1},
        //         };
        //         System.out.println(solveMaze(grid));
    }
}
