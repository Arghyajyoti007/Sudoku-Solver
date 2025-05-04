// https://leetcode.com/problems/sudoku-solver/
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length < 9) return;

        solve(board);
    }
    boolean solve(char[][] board){
        int n = board.length;
        int row=-1, col = -1;
        boolean emptyLeft=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            if(!emptyLeft) 
                break;
        }
        if (emptyLeft){
            return true;
            // Solved
        }

        for (char i = '1'; i <= '9'; i++) {

            if (isSafe(board,row,col,i)){
                board[row][col]=i;

                if(solve(board)) 
                    return true;

                else 
                    board[row][col]='.';
            }
        }

        return false;
    }

    boolean isSafe(char[][] board, int row, int col, int num){
        // Check for the row
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==num){
                return false;
            }
        }
        // Check for the column
        for(char[] nums:board){
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
    private static void display(char[][] board) {
        for(char[] row:board){
            for(int element:row){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
