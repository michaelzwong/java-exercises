/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC011 {

	/**
	 * Given n non-negative integers a1, a2, ..., an , where each represents a point
	 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
	 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
	 * x-axis forms a container, such that the container contains the most water.
	 * 
	 * @param height - array of heights
	 * @return max area
	 */
	public int maxArea(int[] height) {
		if (height.length < 2)
			return 0;

		int maxArea = 0;
		// Iterate through all the combinations possible
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int curHeight = (height[i] < height[j]) ? height[i] : height[j];
				int curArea = curHeight * (j - i);
				if (curArea > maxArea) {
					maxArea = curArea;
				}
			}
		}
		return maxArea;
	}

	public int maxArea(int[] height, boolean simple) {
		if (height.length < 2)
			return 0;

		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int minHeight = height[left] < height[right] ? height[left] : height[right];
			int curArea = minHeight * (right - left);
			if (curArea > maxArea)
				maxArea = curArea;
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;

	}
}
