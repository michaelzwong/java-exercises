package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC059 {

    /**
     * Given a positive integer n, generate a square matrix filled with elements 
     * from 1 to n2 in spiral order.
     *
     * @param n - generate matrix of size n*n
     * @return int[][] - result matrix
     */
    public int[][] generateMatrix(int n) {
       if(n <= 0) {
           return new int[0][];
       }
       boolean[][] visited = new boolean[n][n];
       int[][] result = new int[n][n];
       int[] rowDir = new int[]{0, 1, 0, -1};
       int[] colDir = new int[]{1, 0, -1, 0};
       int row = 0, col = 0, dir = 0, ele = 0;
       for(int i = 0; i < n*n; i++) {
           result[row][col] = ++ele;
           visited[row][col] = true;
           // Find next position
           int newRow = row + rowDir[dir];
           int newCol = col + colDir[dir];
           // Check boundaries and if new row and new col have been visited
           if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
               row = newRow;
               col = newCol;
           } else {
               dir = (dir + 1) % 4;
               row += rowDir[dir];
               col += colDir[dir];
           }
       }
       return result;
    }
}
