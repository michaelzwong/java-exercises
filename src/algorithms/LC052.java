package algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 * LeetCode Hard.
 *
 * @author michaelwong
 */
public class LC052 {

     private int numWays = 0;
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n
     * chessboard such that no two queens attack each other.
     *
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     *
     * @param n - n-queens on nxn board
     * @return int - number of distinct solutions
     */
     public int totalNQueens(int n) {
         if(n <= 0) {
             return 0;
         }
         int[][] chessboard = new int[n][n];
         findQueens(chessboard, 0);
         return numWays;
     }

     private void findQueens(int[][] chessboard, int row) {
         if(row == chessboard.length) {
             numWays++;
             return;
         }
         for(int c = 0; c < chessboard[0].length; c++) {
             if(isValid(chessboard, row, c)) {
                 // Mark as visited
                 chessboard[row][c] = 1;
                 findQueens(chessboard, row + 1);
                 // Backtrack
                 chessboard[row][c] = 0;
             }
         }
     }

     private boolean isValid(int[][] chessboard, int row, int col) {
         for(int i = 0; i < row; i++) {
             for(int j = 0; j < chessboard[0].length; j++) {
                 if(chessboard[i][j] == 1 && (col == j || row - i == col - j || row + col == j + i)) {
                     return false;
                 }
             }
         }
         return true;
     }
}
