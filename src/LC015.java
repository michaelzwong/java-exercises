import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode Medium
 * 
 * @author michaelwong
 *
 */
public class LC015 {
	/**
	 * Given an array nums of n integers, are there elements a, b, c in nums such
	 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * @param nums - the array of n integers
	 * @return - Triplets that add up to 0
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		if (nums.length < 3) {
			return new ArrayList<>();
		}

		Arrays.sort(nums);

		// ex. [-1, 0, 1, 2,-1,-4] =>
		// [-4,-1,-1, 0, 1, 2]

		// ex. [ 3, 0,-2,-1, 1, 2] =>
		// [-2,-1, 0, 1, 2, 3]

		// ex. [-1, 0, 1, 2,-1,-4] =>
		// [-4,-1,-1, 0, 1, 2]

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		// Loop throught the array
		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// Index of first number
			int first = i;

			// Indices of second and third numbers
			int left = i + 1;
			int right = nums.length - 1;

			// Find nums[left] and nums[right] that add up to -firstNum
			// (Implies that the 3 numbers add up to 0)
			while (left < right) {
				int leftNum = nums[left];
				int rightNum = nums[right];
				int firstNumComplement = -nums[first];
				if (nums[left] + nums[right] == firstNumComplement) {
					List<Integer> triplet = new ArrayList<Integer>(3);
					triplet.add(nums[first]);
					triplet.add(nums[left]);
					triplet.add(nums[right]);
					list.add(triplet);
					left++;
					right--;
					while (left < right && nums[left] == leftNum) {
						left++;
					}
					while (left < right && nums[right] == rightNum) {
						right--;
					}
				} else if (nums[left] + nums[right] > firstNumComplement) {
					right--;
				} else {
					left++;
				}
			}
		}

		return list;
	}
}
