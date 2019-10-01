package algorithms;
/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC001 {

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
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int [] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

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