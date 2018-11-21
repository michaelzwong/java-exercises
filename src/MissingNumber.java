/**
 * Missing Number Question.
 * 
 * @author michaelwong
 *
 */
public class MissingNumber {

	/**
	 * Given a list of n - 1 integers in the range from (1 to n) or (0 to n), there
	 * is an integer missing. Find the missing number and return it.
	 * 
	 * [1, 2, 3, 5] would return 4
	 * 
	 * [0, 1, 2, 3, 5] would return 4
	 * 
	 * [1] would return 2
	 * 
	 * @param nums
	 * @return
	 */
	public static int getMissingNumber(int[] nums) {

		int n = nums.length + 1;

		int i = 0;

		if (nums[0] == 0) {
			n--;
			i++;
		}

		int total = (n + 1) * n / 2;

		while (i < nums.length) {
			total -= nums[i];
			i++;
		}
		return total;
	}
}
