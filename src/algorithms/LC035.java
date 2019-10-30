package algorithms;
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
	 public int searchInsert(int[] nums, int target) {
			 if(nums.length == 0) {
					 return 0;
			 }
			 return recursiveBinarySearch(nums, target, 0, nums.length-1);
	 }

	 private int recursiveBinarySearch(int[] nums, int target, int left, int right) {
			 if(left == right) {
					 if(target <= nums[left]) {
							 return left;
					 } else if(target > nums[left]) {
							 return left + 1;
					 }
			 }
			 if(target < nums[left]) {
					 return left;
			 }
			 if(nums[right] < target) {
					 return right + 1;
			 }
			 int mid = right - (right-left)/2;

			 if(nums[mid] == target) {
					 return mid;
			 } else if(nums[mid] < target) {
					 return recursiveBinarySearch(nums, target, mid + 1, right);
			 } else {
					 return recursiveBinarySearch(nums, target, left, mid - 1);
			 }
	 }
}
