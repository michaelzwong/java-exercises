package algorithms;

import java.util.Arrays;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC016 {
    /**
     * Given an array nums of n integers and an integer target, find three integers
     * in nums such that the sum is closest to target. Return the sum of the three
     * integers. You may assume that each input would have exactly one solution.
     *
     * @param nums   - List of numbers
     * @param target - The numbers returned will have a sum closest to this target
     * @return int - The three numbers whose sum is closest to the target
     */
    public int threeSumClosest(int[] nums, int target) {

        // Sorting will simplify the algorithm
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        // Loop through the array nums.length times
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                int sum = cur + left + right;
                int diff = Math.abs(target - sum);
                if (diff == 0) {
                    return sum;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    minSum = sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }

        }

        return minSum;
    }

}
