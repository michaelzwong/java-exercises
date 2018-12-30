import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode Medium
 * 
 * @author michaelwong
 *
 */
public class LC015 {
	/**
	 * Given an array nums of n integers, are there elements a, b, c in nums such
	 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * @param nums - the array of n integers
	 * @return - Triplets that add up to 0
	 */
public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        // ex. [-1, 0, 1, 2,-1,-4] =>
        //     [-4,-1,-1, 0, 1, 2]
        
        // ex. [ 3, 0,-2,-1, 1, 2] =>
        //     [-2,-1, 0, 1, 2, 3]
        
        // ex. [-1, 0, 1, 2,-1,-4] =>
        //     [-4,-1,-1, 0, 1, 2]
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        // Loop throught the array 
        for(int i = 0; i < nums.length - 2; i++) {
            
            // First number of the triplet
            int firstNum = nums[i];
            
            // Second and third numbers
            int left = i + 1;
            int right = nums.length - 1;
            
            // Find nums[left] and nums[right] that add up to -firstNum
            // (Implies that the 3 numbers add up to 0)
            while(left < right) {
                if(nums[left] + nums[right] == -firstNum) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(firstNum);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    // If triplet is unique
                    if(!set.contains(triplet)) {
                        list.add(triplet);
                        set.add(triplet);
                    }
                    left++;
                    right--;
                } else if(nums[left] + nums[right] > -firstNum){
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return list;
    }
}
