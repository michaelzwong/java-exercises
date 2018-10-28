import java.util.ArrayList;

public class SmallestPositiveInteger {

	/**
	 * Given an array A of N integers, 
	 * returns the smallest positive integer (greater than 0) that does not occur in A.
	 * 
	 * @param A - Array of integers
	 * @return int - smallest integer not found
	 */
	public static int findSmallestPositiveInteger(int[] A) {
		ArrayList<Integer> mArrayList = new ArrayList<Integer>();
        
        // Place the integer into the ArrayList
        for(int i = 0; i < A.length; i++) {
            mArrayList.add(A[i]);
        }
        
        int curInt = 1;
        int smallest = -1;
        
        boolean notFound = true;
        while(notFound) {
            if(!mArrayList.contains(curInt)) {
                smallest = curInt;
                notFound = false;
            } else {
                curInt++;
            }
        }
        
        return smallest;
	}
}
