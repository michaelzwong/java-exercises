/**
 * LeetCode Hard.
 * 
 * @author michaelwong
 *
 */
public class LC004 {
	/**
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * 
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * You may assume nums1 and nums2 cannot be both empty.
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;

		// Add spaces to length to accomdate for the case when median is in between
		// numbers
		// Odd indices represent a mean between two numbers
		int totalLength = length + length - 1;

		int medianIndex = totalLength / 2;
		
		return 0;

	}
}
