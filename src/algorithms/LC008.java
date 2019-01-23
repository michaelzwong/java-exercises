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

		int index = 0, sign = 1, total = 0;
        // Empty string
        if(str.length() == 0) return 0;

        // Remove Spaces
        while(index < str.length() && str.charAt(index) == ' ')
            index ++;
        
        // String has no digits
        if(index >= str.length()) {
            return 0;
        }

        // Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        
        // Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            // Check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        
        return total * sign;
	}
}
