package algorithms;

// import java.util.Stack;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC034 {

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     *
     * @param nums   - Array of numbers.
     * @param target - Target to find.
     * @return int - Index of number in array or -1.
     */
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[]{-1, -1};
        if (nums.length == 0) {
            return answer;
        }
        recursiveBinarySearch(nums, target, 0, nums.length - 1, answer);
        return answer;
    }

    private void recursiveBinarySearch(int[] nums, int target, int left, int right, int[] answer) {
        if (left == right || nums[left] == nums[right]) {
            if (nums[left] == target && answer[0] == -1 && answer[1] == -1) {
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                answer[0] = left;
                answer[1] = right;
            }
            return;
        }
        if (target >= nums[left] && target <= nums[right]) {
            if (target == nums[left]) {
                recursiveBinarySearch(nums, target, left, left, answer);
                return;
            }
            if (target == nums[right]) {
                recursiveBinarySearch(nums, target, right, right, answer);
                return;
            }
            int middle = right - (right - left) / 2;
            recursiveBinarySearch(nums, target, left, middle - 1, answer);
            recursiveBinarySearch(nums, target, middle, right, answer);
        }
    }

}
