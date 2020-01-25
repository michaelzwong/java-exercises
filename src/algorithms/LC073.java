package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC073 {

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     *
     * @param int[][] - matrix the m x n matrix
     */
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }
        int R = matrix.length;
        int C = matrix[0].length;
        boolean col = false;

        // Loop over every cell in the matrix
        for(int r = 0; r < R; r++) {
            // If the 0-th column is 0, set boolean col to be true
            if(matrix[r][0] == 0) {
                col = true;
            }
            for(int c = 1; c < C; c++) {
                if(matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for(int r = 1; r < R; r++) {
            for(int c = 1; c < C; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int c = 0; c < C; c++) {
                matrix[0][c] = 0;
            }
        }
        if(col) {
            for(int r = 0; r < R; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
