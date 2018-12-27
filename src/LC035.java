/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 * 
 */
public class LC035 {
	/**
	 * Given a sorted array and a target value, return the index if the target is
	 * found. If not, return the index where it would be if it were inserted in
	 * order. You may assume no duplicates in the array.
	 * 
	 * @param nums   - array of integers
	 * @param target - target integer
	 * @return index
	 */
	public static int searchInsert(int[] nums, int target) {
		int i = 0;
		int len = nums.length;
		int index = 0;
		if (len == 0) {
			return index;
		}

		while (i < nums.length) {
			if (target == nums[i])
				return i;

			if (i > 0 && i + 1 < nums.length) {
				if (nums[i] < target && nums[i + 1] > target) {
					return i + 1;
				}
			}

			if (target < nums[i]) {
				return i;
			}

			i++;
		}

		if (i == nums.length)
			return nums.length;

		return -1;
	}
}
