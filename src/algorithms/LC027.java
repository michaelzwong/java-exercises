package algorithms;
import java.util.ArrayList;

/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC027 {
	/**
	 * Given an array nums and a value val, remove all instances of that value
	 * in-place and return the new length. Do not allocate extra space for another
	 * array, you must do this by modifying the input array in-place with O(1) extra
	 * memory. The order of elements can be changed. It doesn't matter what you
	 * leave beyond the new length.
	 * 
	 * @param nums - array to remove instances of value from
	 * @param val  - value to remove
	 * @return - length of array without those value instances.
	 */
	public int removeElement(int[] nums, int val) {

		int i = 0;
		int length = 0;

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		while (i < nums.length) {
			if (nums[i] != val) {
				length++;
				arrayList.add(nums[i]);
			}
			i++;
		}

		int len = arrayList.size();

		i = 0;

		while (i < nums.length && i < len) {
			nums[i] = arrayList.get(i);
			i++;
		}

		return length;
	}
}
