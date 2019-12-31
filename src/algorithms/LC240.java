package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC0240 {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     *
     * @param matrix - the matrix of numbers
     * @return target found
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[rowLen - 1][colLen - 1]) {
            return false;
        }
        // Rows
        int r = 0;
        int c = colLen - 1;
        while (r < rowLen && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            }
            if (target < matrix[r][c]) {
                c--;
            } else if (target > matrix[r][c]) {
                r++;
            }
        }
        return false;
    }
}
