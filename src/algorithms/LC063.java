package algorithms;
/**
 * LeetCode Medium.
 *
 * @author michaelwong
 *
 */
public class LC063 {

	/**
   * A robot is located at the top-left corner of a m x n grid
   * (marked 'Start' in the diagram below).
   * The robot can only move either down or right at any point in time.
   * The robot is trying to reach the bottom-right corner of the grid
   * (marked 'Finish' in the diagram below).
   * Now consider if some obstacles are added to the grids.
   * How many unique paths would there be?
   * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
   * Note: m and n will be at most 100.
	 *
	 * @param obstacleGrid - the grid we are calculating from
   * @return number of unique paths
	 */
   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if(obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rowLen = obstacleGrid.length, colLen = obstacleGrid[0].length;

        // One way to get to the cell(0,0)
        obstacleGrid[0][0] = 1;

        // first column
        for(int i = 1; i < rowLen; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1 || obstacleGrid[i-1][0] == 0) ? 0 : 1;
        }

        // first row
        for(int j = 1; j < colLen; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 1 || obstacleGrid[0][j-1] == 0) ? 0 : 1;
        }

        for(int i = 1; i < rowLen; i++) {
            for(int j = 1; j < colLen; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[rowLen-1][colLen-1];
    }
}
