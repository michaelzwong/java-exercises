package algorithms;
/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC008 {
	/**
	 * Implement atoi which converts a string to an integer.
	 * 
	 * The function first discards as many whitespace characters as necessary until
	 * the first non-whitespace character is found. Then, starting from this
	 * character, takes an optional initial plus or minus sign followed by as many
	 * numerical digits as possible, and interprets them as a numerical value.
	 * 
	 * The string can contain additional characters after those that form the
	 * integral number, which are ignored and have no effect on the behavior of this
	 * function.
	 * 
	 * If the first sequence of non-whitespace characters in str is not a valid
	 * integral number, or if no such sequence exists because either str is empty or
	 * it contains only whitespace characters, no conversion is performed.
	 * 
	 * If no valid conversion could be performed, a zero value is returned.
	 * 
	 * @param str - the String to convert to int
	 * @return int - returned number
	 */
	public int myAtoi(String str) {

        public int myAtoi(String str) {
            // Remove all the white spaces
            str = str.trim();
            if(str.length() == 0) {
                return 0;
            }
            int answer = 0;        
            int sign = 1;
            // Iterator
            int i = 0;
            if(str.charAt(i) == '+') {
                i++;
            } else if(str.charAt(i) == '-') {
                sign = -sign;
                i++;
            }
            while(i < str.length() && Character.isDigit(str.charAt(i))) {
                int num = sign*Character.getNumericValue(str.charAt(i));
                if(overflows(answer, num)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                answer = answer*10 + num;
                i++;
            }
            return answer;
        }
        
        private boolean overflows(int answer, int num) {
            return (
                answer > Integer.MAX_VALUE/10
                || (answer == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE % 10)
                || answer < Integer.MIN_VALUE/10
                || (answer == Integer.MIN_VALUE/10 && num < Integer.MIN_VALUE % 10)
            );
        }
	}
}
