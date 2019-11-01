package algorithms;
/**
 * LeetCode Hard.
 *
 * @author michaelwong
 *
 */
public class LC037 {

	/**
   * Write a program to solve a Sudoku puzzle by filling the empty cells.
   * A sudoku solution must satisfy all of the following rules:
   * Each of the digits 1-9 must occur exactly once in each row.
   * Each of the digits 1-9 must occur exactly once in each column.
   * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
   * Empty cells are indicated by the character '.'.
	 *
	 * @param board - Sudoku board.
	 */
   public void solveSudoku(char[][] board) {
        recursivelySolve(board);
   }

   private boolean recursivelySolve(char[][] board) {
      for(int i = 0; i < board.length; i++) {
          for(int j = 0; j < board[0].length; j++) {
              if(board[i][j] != '.') {
                  continue;
              }
              for(char k = '1'; k <= '9'; k++) {
                  if(isValid(board, i, j, k)) {
                      board[i][j] = k;
                      if(recursivelySolve(board)) {
                          return true;
                      }
                      board[i][j] = '.';
                  }
              }
              return false;
          }
      }
      return true;
   }

   private boolean isValid(char[][] board, int row, int col, int k) {
      for(int i = 0; i<9; i++) {
          if(board[row][i] != '.' && board[row][i] == k) {
              return false;
          }
          if(board[i][col] != '.' && board[i][col] == k) {
              return false;
          }
          int rowIndex = 3*(row/3) + i/3;
          int colIndex = 3*(col/3) + i%3;
          if(board[rowIndex][colIndex] != '.' && board[rowIndex][colIndex] == k) {
              return false;
          }
      }
      return true;
   }
   
}
