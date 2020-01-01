package algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 * LeetCode Hard.
 *
 * @author michaelwong
 */
public class LC051 {

    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n
     * chessboard such that no two queens attack each other.
     *
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * Each solution contains a distinct board configuration of the n-queens'
     * placement, where 'Q' and '.' both indicate a queen and an empty space
     * respectively.
     *
     * @param n - n-queens on n x n board
     * @return List<List<String>> - result
     */
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> result = new ArrayList<List<String>>();
       if(n <= 0) {
           return result;
       }
       char[][] chessboard = new char[n][n];
       for(int i = 0; i < chessboard.length; i++) {
           for(int j = 0; j < chessboard[0].length; j++) {
               chessboard[i][j] = '.';
           }
       }

       int leftToAdd = n;

       findQueens(result, chessboard, leftToAdd, 0, n);

       return result;
    }
    // Recursively adds queens to the chessboard
    private void findQueens(List<List<String>> result, char[][] chessboard, int leftToAdd, int r, int n) {
       if(leftToAdd == 0) {
           List<String> validCombination = constructValidCombination(chessboard);
           result.add(validCombination);
           return;
       }
       // Check all the columns of this row
       for(int c = 0; c < n; c++) {
           if(isValid(chessboard, r, c)) {
               // Mark as visited
               chessboard[r][c] = 'Q';
               // Recursively find queens
               findQueens(result, chessboard, leftToAdd - 1, r + 1, n);
               // Back track
               chessboard[r][c] = '.';
           }
       }
    }
    // Check if spot is valid
    private boolean isValid(char[][] chessboard, int r, int c) {
       // Only need to check the rows we have passed
       for(int i = 0; i < r; i++) {
           // Check the columns
           for(int j = 0; j < chessboard[0].length; j++) {
               // If (i,j) has a queen and it is attacking col c or ascending diagonal of (r,c) or descending diagonal of (r,c)
               if(chessboard[i][j] == 'Q' && (j == c || i - j == r - c || i + j == r + c )) {
                   return false;
               }
           }
       }
       return true;
    }
    // Get a valid combination from chessboard configuration
    private List<String> constructValidCombination(char [][] chessboard) {
       List<String> combination = new ArrayList<String>();
       for(char[] row : chessboard) {
           combination.add(new String(row));
       }
       return combination;
    }
}
