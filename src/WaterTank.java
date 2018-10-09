/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class WaterTank {
	
	/**
	 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 * 
	 */
	public int maxArea(int[] height) {
        if(height.length < 2) return 0;
        
        int maxArea = 0;
        // Iterate through all the combinations possible
        for(int i = 0; i < height.length; i ++) {
            for(int j = i + 1; j < height.length; j ++) {
                int curHeight = (height[i] < height[j]) ? height[i] : height[j];
                int curArea = curHeight * (j - i);
                if(curArea > maxArea) {
                    maxArea = curArea;
                }
            }
        }
        return maxArea;
    }
}
