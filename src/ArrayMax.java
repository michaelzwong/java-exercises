/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class ArrayMax {
	
	/**
	 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
	 * which has the largest sum and return its sum.
	 * 
	 * @param nums - the array
	 * @return int - max sum
	 */
	public int maxSubArray(int[] nums) {
        // an empty array of 0 elements has sum 0
        if(nums.length == 0) {
            return 0;
        }
        
        // keeps track of the global maximum sum for a subarray in nums
        // intially, set it as the first element
        int maxSoFar = nums[0];
        
        // records the max sum up to the current index i 
        int maxEndingHere = 0;
        
        // loop through elements in the array
        for(int i = 0; i < nums.length; i++) {
            // keep track of the sum of a subarray that is non-negative
            maxEndingHere += nums[i];
            
            // if the sum of a subarray is greater than the current sum, record a new max
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            
            // if the result is negative, we reset the subarray at sum 0
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
