package algorithms;
/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC007 {
	/**
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 * 
	 * @param x - Number to reverse
	 * @return int - Reversed number
	 */
	public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        int answer = 0;
        while(x != 0) {
            if(answer > Integer.MAX_VALUE / 10 
               || answer < Integer.MIN_VALUE / 10
               || (answer == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)
               || (answer == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            answer = answer * 10 + x % 10;
            x /= 10;
        }
        return answer;
	}
}
