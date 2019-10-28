package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 *
 */
public class LC031 {

	/**
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 *
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 *
	 * The replacement must be in-place and use only constant extra memory.
	 *
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column.
	 *
	 * @param nums
	 */
	 public void nextPermutation(int[] nums) {
		 int i = nums.length - 2;
		 // Find the first decreasing number counting from the right
		 while(i >= 0 && nums[i] >= nums[i+1]) {
				 i--;
		 }

		 // If i >= 0, it means there exists a decreasing number counting from the right
		 if(i >= 0) {
				 int j = nums.length - 1;
				 // Find the smallest number greater than nums[i]
				 // We are guaranteed that this number exists because i >= 0
				 // We start from the right to check for duplicates
				 while(nums[j] <= nums[i]) {
						 j--;
				 }
				 swap(nums, i, j);
		 }
		 // i + 1 to end is in descending order
		 // Reverse to ascending order
		 reverse(nums, i + 1);
	 }

	 private void reverse(int[] nums, int start) {
			 int i = start;
			 int j = nums.length - 1;
			 while(i < j) {
					 swap(nums, i, j);
					 i++;
					 j--;
			 }
	 }

	 private void swap(int[] nums, int i, int j) {
			 int temp = nums[i];
			 nums[i] = nums[j];
			 nums[j] = temp;
	 }

}
