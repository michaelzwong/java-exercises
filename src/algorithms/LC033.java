package algorithms;

// import java.util.Stack;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC033 {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * @param nums   - Array of numbers.
     * @param target - Target to find.
     * @return int - Index of number in array or -1.
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return recursiveBinarySearch(nums, target, 0, nums.length - 1);
    }

    private int recursiveBinarySearch(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int middle = right - (right - left) / 2;
        if (nums[left] < nums[right] && nums[left] <= target && nums[right] >= target) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            return Math.max(recursiveBinarySearch(nums, target, left, middle - 1)
                    , recursiveBinarySearch(nums, target, middle, right));
        } else if (nums[left] < nums[right]) {
            return -1;
        } else {
            return Math.max(recursiveBinarySearch(nums, target, left, middle - 1)
                    , recursiveBinarySearch(nums, target, middle, right));
        }
    }

}
