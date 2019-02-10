package algorithms;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC029 {

	/**
	 * Given two integers dividend and divisor, divide two integers without using
	 * multiplication, division and mod operator.
	 * 
	 * Return the quotient after dividing dividend by divisor.
	 * 
	 * The integer division should truncate toward zero.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return int - Integer division result
	 */
	public int divide(int dividend, int divisor) {
		if(dividend == 0) {
            return 0;
        }
        long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
        long result = 0;
		
		while(a - b >= 0) {
			a -= b;
            result++;
		}
		
		if(dividend > 0 && divisor < 0 || (dividend < 0 && divisor > 0)) {
			result = -result;
		}
		
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
		return (int) result;
	}

}
