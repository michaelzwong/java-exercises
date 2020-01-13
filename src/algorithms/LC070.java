package algorithms;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC070 {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways
     * can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     *
     * @param n - number of steps
     * @return int - number of ways to climb to the top
     */
    public int climbStairs(int n) {
       if(n <= 0) {
           return 1;
       }
       int stepZero = 1;
       int stepOne = 1;
       int current = 1;
       for(int i = 2; i <= n; i++) {
           current = stepZero + stepOne;
           stepZero = stepOne;
           stepOne = current;
       }
       return current;
    }
}
