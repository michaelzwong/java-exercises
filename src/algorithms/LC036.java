package algorithms;

import java.util.Set;
import java.util.HashSet;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC036 {

    /**
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * @param board - Sudoku board.
     * @return boolean - validity.
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        // Rows
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<Character>();
            Set<Character> colSet = new HashSet<Character>();
            Set<Character> subboxSet = new HashSet<Character>();
            // Columns
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
                // Sub-box
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !subboxSet.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
//         List<Set<Character>> cols = new ArrayList<Set<Character>>();
//         List<Set<Character>> boxes = new ArrayList<Set<Character>>();

//         // Rows
//         for(int i = 0; i < board.length; i++) {
//             // Create a HashSet for each row
//             Set<Character> rowSet = new HashSet<Character>();
//             // Columns
//             for(int j = 0; j < board[0].length; j++) {
//                 Set<Character> colSet;
//                 Set<Character> boxSet;
//                 // Add a new HashSet for this column
//                 if(cols.size() == j) {
//                     colSet = new HashSet<Character>();
//                     cols.add(colSet);
//                 // HashSet for this column already exists
//                 } else {
//                     colSet = cols.get(j);
//                 }
//                 if(boxes.size() == (i/3)*3 + j/3) {
//                     boxSet = new HashSet<Character>();
//                     boxes.add(boxSet);
//                 } else {
//                     boxSet = boxes.get((i/3)*3 + j/3);
//                 }
//                 char num = board[i][j];
//                 if(num != '.') {
//                     if(colSet.contains(num) || rowSet.contains(num) || boxSet.contains(num)) {
//                         return false;
//                     } else {
//                         colSet.add(num);
//                         rowSet.add(num);
//                         boxSet.add(num);
//                     }
//                 }
//             }
//         }
//         return true;
    }

}
