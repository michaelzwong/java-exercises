package algorithms;

import java.util.Queue;
import java.util.LinkedList;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC064 {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numCols = grid[0].length;
        int numRows = grid.length;
        int numIslands = 0;
        // Rows
        for (int i = 0; i < grid.length; i++) {
            // Columns
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++numIslands;
                    grid[i][j] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(i * numCols + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / numCols;
                        int col = id % numCols;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * numCols + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < numRows && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * numCols + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * numCols + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < numCols && grid[row][col + 1] == '1') {
                            neighbors.add(row * numCols + col + 1);
                            grid[row][col + 1] = '0';
                        }

                    }
                }
            }
        }

        return numIslands;
    }
}
