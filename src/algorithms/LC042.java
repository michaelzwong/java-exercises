package algorithms;

/**
 * LeetCode Hard.
 *
 * @author michaelwong
 */
public class LC042 {

    /**
     * Given n non-negative integers representing an elevation map where the width
     * of each bar is 1, compute how much water it is able to trap after raining.
     *
     * @param height - Array of the height of each bar
     * @return Amount of water that can be trapped
     */
    public int trap(int[] height) {
        int totalAmount = 0;
        if (height == null || height.length == 0) {
            return totalAmount;
        }
        int[] leftHighest = new int[height.length + 1];
        leftHighest[0] = 0;
        for (int i = 0; i < height.length; i++) {
            leftHighest[i + 1] = Math.max(height[i], leftHighest[i]);
        }
        int rightHighest = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightHighest = Math.max(height[i], rightHighest);
            totalAmount += Math.min(rightHighest, leftHighest[i + 1]) - height[i] > 0 ? Math.min(rightHighest, leftHighest[i + 1]) - height[i] : 0;
        }
        return totalAmount;
    }
}
