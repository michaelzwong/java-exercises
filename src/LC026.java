/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC026 {

	/**
	 * Given a sorted array nums, remove the duplicates in-place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this by modifying
	 * the input array in-place with O(1) extra memory.
	 * 
	 * @param nums - array to remove duplicates from
	 * @return - length of array with unique numbers
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int n = -1;
		if (nums[0] == -1) {
			n = -2;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			// init num
			if (nums[i] != n) {
				nums[j] = nums[i];
				n = nums[i];
				j += 1;
			}
		}
		return j;
	}

}
