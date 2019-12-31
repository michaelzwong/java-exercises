package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class
LC001 {

    /**
     * Given an array of integers, return indices of the two numbers such that they
     * add up to a specific target. Assume that exactly one solution is possible and
     * the same element may not be used twice.
     *
     * @param nums   - Array of integers
     * @param target - Equal to sum of two integers in nums
     * @return int[] - Indices of the two numbers that add up to a specific target
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}