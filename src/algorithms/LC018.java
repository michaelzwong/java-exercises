package algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC018 {
	/**
	 * Given an array nums of n integers and an integer target, are there elements
	 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
	 * quadruplets in the array which gives the sum of target.
	 * 
	 * The solution set must not contain duplicate quadruplets.
	 * 
	 * @param nums   - The array of numbers to find the quadruplets from.
	 * @param target - The target that a, b, c and d add up to.
	 * @return List<List<Integer>> - List of unique possible quadruplets.
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length < 4) {
			return result;
		}

		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 3; i++) {
			// if the first number equals the previous number
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < nums.length - 2; j++) {
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int l = j + 1;
				int r = nums.length - 1;
				while(l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if(sum == target) {
						List<Integer> qr = new ArrayList<Integer>();
						qr.add(nums[i]);
						qr.add(nums[j]);
						qr.add(nums[l]);
						qr.add(nums[r]);
						result.add(qr);
						l++;
						r--;
						
						// Find a new left, right combination
						while (l < r && nums[l] == nums[l - 1]) {
							l++;
						}
						while (l < r && nums[r] == nums[r + 1]) {
							r--;
						}
					} else if(sum > target) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		
		return result;
	}
}
