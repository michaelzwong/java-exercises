/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC1 {

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
		// 0th item makes length - (1 + 0 comparisons)
		// 1st item makes length - (1 + 1 comparisons)
		// 2nd item makes length - (1 + 2 comparisons)
		// last item makes length - (1 + 3 comparisons) or 0 comparisons by (*)
		// Therefore, for every i-th item, you make length - (1 + i) comparisons (*),
		// since i = length
		int n = nums.length - 1;
		int m = nums.length;
		// Loop through n sets of comparisons
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < m; j++) {
				int sum = nums[i] + nums[j];
				print_sum(i, j, sum);
				if (sum == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;

	}

	/**
	 * Prints out information about the sum.
	 * 
	 * @param i   - number 1
	 * @param j   - number 2
	 * @param sum - sum of two numbers
	 */
	private void print_sum(int i, int j, int sum) {
		System.out
				.println("Sum of " + Integer.toString(i) + " + " + Integer.toString(j) + " = " + Integer.toString(sum));
	}
}