/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * Assuming that exactly one solution is possible and the same element may not be used twice
 * @author michaelwong
 *
 */
public class ArrayTwoSum {
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // Assuming that exactly one solution is possible and the same element may not be used twice
    public int[] twoSum(int[] nums, int target) {
        // 0th item makes length - (1 + 0 comparisons)
        // 1st item makes length - (1 + 1 comparisons)
        // 2nd item makes length - (1 + 2 comparisons)
        // last item makes length - (1 + 3 comparisons) or 0 comparisons by *
        // Therefore, for every i-th item, you make length - (1 + i)  comparisons*, since i = length
        int n = nums.length - 1;
        int m = nums.length;
        // Loop through n sets of comparisons
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < m; j++) {
                int sum = nums[i] + nums[j];
                System.out.println("Sum of " 
                                   + Integer.toString(nums[i]) 
                                   + " + " 
                                   + Integer.toString(nums[j])
                                   + " = " 
                                   + Integer.toString(sum));
                if(sum==target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
        
    }
}