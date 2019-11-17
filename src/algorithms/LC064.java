package algorithms;
/**
 * LeetCode Medium.
 *
 * @author michaelwong
 *
 */
public class LC062 {

	/**
   * Given a m x n grid filled with non-negative numbers, find a path from top
   * left to bottom right which minimizes the sum of all numbers along its path.
   * Note: You can only move either down or right at any point in time.
	 * 
	 * @param grid - the grid we are calculating from
   * @return minimized path sum
	 */
   public int minPathSum(int[][] grid) {
       if(grid == null || grid.length == 0) {
           return -1;
       }
       if(grid[0] == null || grid[0].length == 0) {
           return -1;
       }

       int rowLen = grid.length, colLen = grid[0].length;

       for(int i = 1; i < rowLen; i++) {
           grid[i][0] += grid[i-1][0];
       }
       for(int j = 1; j < colLen; j++) {
           grid[0][j] += grid[0][j-1];
       }

       // Rows
       for(int i = 1; i < rowLen; i++) {
           // Cols
           for(int j = 1; j < colLen; j++) {
               grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
           }
       }

       return grid[rowLen-1][colLen-1];
   }
}
