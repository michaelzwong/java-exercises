package algorithms;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
/**
 * LeetCode Hard.
 *
 * @author michaelwong
 *
 */
public class LC062 {

	/**
   * Given an array A of positive integers, call a
   * (contiguous, not necessarily distinct) subarray of A good if the number of
   * different integers in that subarray is exactly K.
   * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
   *
   * Return the number of good subarrays of A.
	 *
	 * @param A - array of numbers
   * @param K - distinct numbers
	 * @return int - number of good subarrays of A
	 */
   public int subarraysWithKDistinct(int[] A, int K) {
         int result = 0, i = 0, j = 0, n = A.length, minEnd = -1;
         Map<Integer, Queue<Integer>> map = new HashMap<Integer, Queue<Integer>>();

         // Loop through the array once
         while(i < n) {

             // Loop through K unique numbers and set j to be the index of the first K+1 number
             while(j < n) {
                 // Unique number found
                 if(!map.containsKey(A[j])) {
                     // We already have K unique numbers, we need to break from the loop
                     if(map.size() == K) {
                         break;
                     }
                     // Found the Kth unique number, set minEnd, which represents the minimum subarray possible so far
                     if(map.size() == K - 1) {
                         minEnd = j;
                     }
                     map.put(A[j], new LinkedList<Integer>());
                 }
                 map.get(A[j]).offer(j);
                 j++;
             }
             // Not possible for more subarrays
             if(j == n && map.size() < K) {
                 break;
             }
             // Calculate the number of subarrays based on i, j index
             while (i < j) {
                 int cur = A[i++];
                 result += j - minEnd;
                 // Remove that index from our map
                 map.get(cur).poll();
                 // We have less than K unique numbers
                 if (map.get(cur).isEmpty()) {
                     // Remove the unique number and recalculate j
                     map.remove(cur);
                     break;
                 }
                 minEnd = Math.max(minEnd, map.get(cur).peek());
             }

         }
         return result;

     }
}
