package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC075 {

    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
     * are adjacent, with the colors in the order red, white and blue.
     *
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     *
     * Note: You are not suppose to use the library's sort function for this problem.
     *
     * @param nums - Array of red, white and blue colors
     */
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length-1, index = 0;
        // Loop through the array
        while(index <= end) {
            if(nums[index] == 0) {
                // Found red color, swap
                nums[index++] = nums[start];
                nums[start++] = 0;
            } else if(nums[index] == 2) {
                // Found blue color, swap
                nums[index] = nums[end];
                nums[end--] = 2;
            } else {
                index++;
            }
        }
    }
}
