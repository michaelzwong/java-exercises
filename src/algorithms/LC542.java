package algorithms;

import java.util.Arrays;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC542 {

    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
     * The distance between two adjacent cells is 1.
     *
     * @param matrix - the matrix of 0s and 1s
     * @return updated matrix
     */
    public int[][] updateMatrix(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;

        int[][] result = new int[rowLen][colLen];
        for (int[] a : result) {
            Arrays.fill(a, 100000);
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    if (i > 0)
                        result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    if (j > 0)
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        for (int k = rowLen - 1; k >= 0; k--) {
            for (int l = colLen - 1; l >= 0; l--) {
                if (matrix[k][l] == 0) {
                    result[k][l] = 0;
                } else {
                    if (k < rowLen - 1)
                        result[k][l] = Math.min(result[k][l], result[k + 1][l] + 1);
                    if (l < colLen - 1)
                        result[k][l] = Math.min(result[k][l], result[k][l + 1] + 1);
                }
            }
        }
        return result;
    }
}
