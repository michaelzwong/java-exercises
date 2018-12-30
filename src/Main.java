import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
		
		 Set<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();

		    ArrayList<Integer> arr = new ArrayList<Integer>();

		    arr.add(1);
		    arr.add(2);
		    arr.add(3);
		    arr.add(4);

		    hs.add(arr);

		    ArrayList<Integer> arr1 = new ArrayList<Integer>();

		    arr1.add(1);
		    arr1.add(2);
		    arr1.add(3);
		    arr1.add(4);

		    hs.add(arr1);

		    System.out.println(hs.size());

	}
}
