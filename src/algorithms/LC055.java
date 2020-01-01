package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC055 {

    /**
     * Given an array of non-negative integers, you are initially positioned at
     * the first index of the array. Each element in the array represents your
     * maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * @param nums - jump array
     * @return boolean - possible to reach the last index?
     */
    public boolean canJump(int[] nums) {
       if(nums.length == 0 || nums.length == 1) {
           return true;
       }
       // The distance needed to jump from index nums.length - 2 to nums.length - 1
       int jumpLengthNeeded = 1;
       // We start from the back and check if there is enough jump length to reacth the end
       // 1. If there isn't, increment jump needed by 1 and check current index - 1
       // 2. If there is, set jump length needed back to 1 and continue
       for(int i = nums.length-2; i >= 0; i--) {
           if(nums[i] < jumpLengthNeeded) {
               jumpLengthNeeded++;
           } else {
               jumpLengthNeeded = 1;
           }
       }
       return jumpLengthNeeded == 1;
    }
}
