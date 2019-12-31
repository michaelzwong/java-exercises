package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC029 {

    /**
     * Given two integers dividend and divisor, divide two integers without using
     * multiplication, division and mod operator.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * The integer division should truncate toward zero.
     *
     * @param dividend
     * @param divisor
     * @return int - Integer division result
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int result = 0;
        while (absDividend - absDivisor >= 0) {
            int x = 0;
            while (absDividend - (absDivisor << 1 << x) >= 0) {
                x++;
            }
            result += 1 << x;
            absDividend -= absDivisor << x;
        }

        if ((dividend >= 0) == (divisor >= 0)) {
            return result;
        } else {
            return -result;
        }
    }

}
