package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC060 {

    /**
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     *
     * By listing and labeling all of the permutations in order, we get the
     * following sequence for n = 3:
     *
     * Given n and k, return the kth permutation sequence.
     *
     * @param n - n! unique permutations
     * @param k - k-th permutation sequence
     * @return String - the k-th permutation sequence in String format
     */
    public String getPermutation(int n, int k) {
       // Use a HashMap for O(1) removal
       ArrayList<Integer> nums = new ArrayList<Integer>();
       int i = 1;
       while(i <= n) {
           nums.add(i);
           i++;
       }
       // Convert to index numbering because indices starts from 0
       k--;
       StringBuilder sb = new StringBuilder();
       i = 1;
       while(i <= n){
           // Use k to find which subset of numsMap the permutation is in
           int index = k/factorial(n-i);
           // Use the index to get the subset in numsMap
           sb.append(nums.remove(index));
           // Update k since subsets have been removed
           k -= index * factorial(n-i);
           i++;
       }
       return sb.toString();
    }
    // Returns a factorial number
    private int factorial(int n) {
       if(n == 0) {
           return 1;
       } else {
           return n * factorial(--n);
       }
    }
}
