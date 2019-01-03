import java.util.Arrays;

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
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		// Conduct binary search on the smaller of the two arrays
		if(nums2.length < nums1.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		// Smaller array
		int x = nums1.length;
		// Larger array
		int y = nums2.length;
		
		int left = 0;
		int right = x;
		
		while(left <= right) {
			
			// Partition of x array
			int partitionX = (left + right)/2;
			// Partition of y array
			int partitionY = (x + y + 1)/2 - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((x + y) % 2 == 0) {
					return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)))/2;
				} else {
					return (double) (Math.max(maxLeftX, maxLeftY));
				}
			} else if (maxLeftX > minRightY) {
				right = partitionX - 1;
			} else {
				left = partitionX + 1;
			}
		}
		
		throw new IllegalArgumentException();

	}
}
