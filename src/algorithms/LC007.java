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
		int resultNumber = 0;
		for (int i = x; i != 0; i /= 10) {
			if (resultNumber > Integer.MAX_VALUE / 10 || (resultNumber == Integer.MAX_VALUE / 10 && (i % 10) > 7))
				return 0;
			if (resultNumber < Integer.MIN_VALUE / 10 || (resultNumber == Integer.MIN_VALUE / 10 && (i % 10) < -8))
				return 0;
			resultNumber = resultNumber * 10 + i % 10;
		}
		return resultNumber;

	}
}
