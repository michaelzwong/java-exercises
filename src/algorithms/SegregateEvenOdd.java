package algorithms;
/**
 * Question from Thomson Reuters.
 * 
 * @author michaelwong
 *
 */
public class SegregateEvenOdd {

	/**
	 * Given an array of integers, put all even integers before odd integers using
	 * the minimum number of swaps.
	 * 
	 * @param arr - the array of integers
	 * @return int - number of swaps
	 */
	public static int segregate(int[] arr) {

		// Empty array
		if (arr.length == 0) {
			return 0;
		}

		// Left index
		int left = 0;

		// Right index
		int right = arr.length - 1;

		// Number of swaps to segregate even and odd numbers in the array
		int swaps = 0;

		while (left < right) {

			// Find the first even integer from the right
			while (arr[right] % 2 == 1 && left < right) {
				right--;
			}

			// Find the first odd integer from the left
			while (arr[left] % 2 == 0 && left < right) {
				left++;
			}

			// Swap
			if (left < right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				swaps++;
			}

		}
		return swaps;
	}
}
