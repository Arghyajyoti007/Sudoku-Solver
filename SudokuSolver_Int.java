public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(solve(board)){
            display(board);
        }
        else {
            System.out.println("Not possible");
        }
    }

    static boolean solve(int[][] board){
        int n = board.length;
        int row=-1, col = -1;
        boolean emptyLeft=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            if(!emptyLeft) break;
        }
        if (emptyLeft){
            return true;
            // Solved
        }

        for (int i = 1; i <=9; i++) {
            if (isSafe(board,row,col,i)){
                board[row][col]=i;
                if(solve(board)) return true;
                else board[row][col]=0;
            }
        }

        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        // Check for the row
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==num){
                return false;
            }
        }
        // Check for the column
        for(int[] nums:board){
            if(nums[col]==num){
                return false;
            }
        }
        // Check for the Grid
        int squareRoot=(int)(Math.sqrt(board.length));
        int rowStart = row - (row%squareRoot);
        int colStart = col - (col%squareRoot);

        for (int i = rowStart; i < rowStart+squareRoot; i++) {
            for (int j = colStart; j < colStart+squareRoot; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    private static void display(int[][] board) {
        for(int[] row:board){
            for(int element:row){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
