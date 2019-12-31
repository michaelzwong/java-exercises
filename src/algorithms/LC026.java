package algorithms;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC026 {

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each
     * element appear only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying
     * the input array in-place with O(1) extra memory.
     *
     * @param nums - array to remove duplicates from
     * @return - length of array with unique numbers
     */
    public int removeDuplicates(int[] nums) {
        // The array up to index and not including index is unique
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // If number is unique, replace number at index with the unique number
            if (nums[i] != nums[i + 1]) {
                // Increment index, since our unique array has grow in size
                nums[index++] = nums[i + 1];
            }
            // Otherwise we keep looping until we find a unique number
        }
        // Array from 0 up to index and not including index is unique
        return index;
    }

}
