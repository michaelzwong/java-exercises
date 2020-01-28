package algorithms;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC733 {

    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
     * The distance between two adjacent cells is 1.
     *
     * @param image - matrix of colors
     * @param sr - row coordinate
     * @param sc - col coordinate
     * @param newColor - color to change to
     * @return int[][] - updated matrix
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Error checking
        if(image.length == 0 || image[0].length == 0) {
            return image;
        }
        if(image[sr][sc] != newColor) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int ogColor) {
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && ogColor == image[sr][sc]) {
            image[sr][sc] = newColor;
            dfs(image, sr, sc-1, newColor, ogColor);
            dfs(image, sr, sc+1, newColor, ogColor);
            dfs(image, sr-1, sc, newColor, ogColor);
            dfs(image, sr+1, sc, newColor, ogColor);
        }
    }
}
