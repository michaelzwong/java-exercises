package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC054 {

    /**
     * Given a matrix of m x n elements (m rows, n columns),
     * return all elements of the matrix in spiral order.
     *
     * @param matrix of m x n elements
     * @return List<Integer> - resulting spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // Keep track of visited positions
        boolean[][] visited = new boolean[m][n];
        // Direction helpers
        int[] rd = new int[] {0, 1, 0, -1};
        int[] cd = new int[] {1, 0, -1, 0};
        int r = 0, c = 0, d = 0;
        for(int i = 0; i < m * n; i++){
            result.add(matrix[r][c]);
            visited[r][c] = true;
            // Potential next row
            int nr = r + rd[d];
            // Potential next col
            int nc = c + cd[d];
            // Boundary check for new position (nr, nc)
            if(0 <= nr && nr < m && 0 <= nc && nc < n && !visited[nr][nc]) {
                r = nr;
                c = nc;
            } else {
                // Direction change
                d = (d + 1) % 4;
                // Row direction change
                r += rd[d];
                // Col direction change
                c += cd[d];
            }
        }
        return result;
    }
}
