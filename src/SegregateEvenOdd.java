/**
 * 
 * @author michaelwong
 *
 */
public class SegregateEvenOdd {
	
	/**
	 * Given an array of integers, put all even integers before odd integers using the minimum number of swaps.
	 * 
	 * @param arr - the array of integers
	 * @return int - number of swaps
	 */
	public static int segregate(int[] arr) {
		
		if(arr.length == 0) {
			return 0;
		}
		
		int left = 0;
		
		int right = arr.length - 1;
		
		int swaps = 0;
		
		while(left < right) {
			
			// Find the first even integer from the right
			while(arr[right] % 2 == 1 && left < right) {
				right --;
			}
			
			// Find the first odd integer from the left
			while(arr[left] % 2 == 0 && left < right) {
				left ++;
			}
			
			// Swap
			if(left < right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				swaps++;
			}
			
			
		}
		return swaps;
	}
}
