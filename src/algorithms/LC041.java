package algorithms;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC039 {

	/**
     * Given an unsorted integer array, find the smallest missing positive integer.
     * 
	 * @param nums - Array of numbers
	 * @return first missing positive number
	 */
    public int firstMissingPositive(int[] nums) {
        int numNonPos = moveNonPositivesToFront(nums);
        for(int i = numNonPos; i < nums.length; i++) {
            int index = Math.abs(nums[i]) + numNonPos - 1;
            if(index < nums.length && index >= 0) {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for(int i = numNonPos; i < nums.length; i++) {
            if(nums[i] > 0) {
                return i - numNonPos + 1;
            }
        }
        return nums.length - numNonPos + 1;
    }
    
    private int moveNonPositivesToFront(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return j;
    }
}