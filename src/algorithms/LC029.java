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
		// Convert to long to accommodate overflow
		// Use absolute values to simplify addition in calculation
		long lDividend = Math.abs((long) dividend);
		long lDivisor = Math.abs((long) divisor);

		/* Integer division is guaranteed to be 0 */
		// a. dividend is 0
		// b. divisor > dividend
		if (lDividend == 0 || lDivisor > lDividend) {
			return 0;
		}

		long result = recursivelyDivide(lDividend, lDivisor);

		if (dividend > 0 && divisor < 0 || (dividend < 0 && divisor > 0)) {
			result = -result;
		}

		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return (int) result;
	}

	/**
	 * Recursively "divide" using addition.
	 * 
	 * 
	 * @param dividend
	 * @param divisor
	 * @return long
	 */
	private long recursivelyDivide(long dividend, long divisor) {
		// Base case
		if (dividend < divisor)
			return 0;

		// Find the largest multiple such that (sum + sum) <= dividend
		// Take increments by multiples of 1, 2, 4, 8, 16, ..., 2^n
		long sum = divisor;
		long multiple = 1;
		while ((sum + sum) <= dividend) {
			sum += sum;
			multiple += multiple;
		}

		// Find number of multiples from the remainder (dividend - sum) recursively
		return multiple + recursivelyDivide(dividend - sum, divisor);
	}

}
