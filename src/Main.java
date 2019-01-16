import java.util.ArrayList;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;

/**
 * Test classes and methods from here.
 * 
 * @author michaelwong
 *
 */
public class Main {
	/**
	 * Main Function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] nums = new int[] { 3, 3, 4, 5, 6, 1, 3, 8, 9 };
//
//		System.out.println(SegregateEvenOdd.segregate(nums));
//		int[] nums1 = new int[] {3, 4, 5, 6, 8};
//		int[] nums2 = new int[] {5, 6, 8, 10};
//		int[] nums = new int[] {1};
		
//		double median = LC004.findMedianSortedArrays(nums, nums);
//		System.out.println(median);
		// LC022 test = new LC022();
		
		//System.out.println(test.letterCombinationsRecursive("23"));
		LC022 test = new LC022();
		ArrayList<String> al = (ArrayList<String>) test.generateParenthesis(3);
		for(String s : al) {
			System.out.println(s);
		}
		
	}	
}
