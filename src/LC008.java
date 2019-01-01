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

		if (str.length() == 0) {
			return 0;
		}

		// Counter
		int i = 0;

		// Add the numbers in str to numString
		String numString = "";

		boolean isNegative = false;

		// Skip all the initial white spaces
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}

		// Check for negative sign
		if (i < str.length() && str.charAt(i) == '-') {
			isNegative = true;
			i++;
		}
		// Check for positive sign
		else if (i < str.length() && str.charAt(i) == '+') {
			isNegative = false;
			i++;
		}
		// Check if immediate (sign + 1) character is a digit
		if (i >= str.length() || !Character.isDigit(str.charAt(i))) {
			return 0;
		}
		// Remove leading 0s
		while (i < str.length() && Character.isDigit(str.charAt(i)) && str.charAt(i) == '0') {
			i++;
		}
		// Add the subsequent digits to numString
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			numString += str.charAt(i);
			i++;
		}
		// If no subsequent non-zero digits, return 0
		if (numString.equals("")) {
			return 0;
		}

		// Get the maximum possible number of digits
		int maxNumberOfDigits = String.valueOf(Integer.MAX_VALUE).length();

		if (numString.length() > maxNumberOfDigits) {
			if (isNegative) {
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
		}
		if (numString.length() < maxNumberOfDigits) {
			if (isNegative) {
				return -Integer.parseInt(numString);
			}
			System.out.println(numString);
			return Integer.parseInt(numString);
		}

		if (numString.length() == maxNumberOfDigits) {
			i = 0;
			String maxString;
			if (isNegative) {
				maxString = String.valueOf(Integer.MIN_VALUE); // -2147483648
				maxString = maxString.substring(1);
			} else {
				maxString = String.valueOf(Integer.MAX_VALUE); // 2147483647
			}
			while (i < numString.length()) {
				if (numString.charAt(i) > maxString.charAt(i)) {
					break;
				}
				if (numString.charAt(i) < maxString.charAt(i)) {
					if (isNegative) {
						return -Integer.parseInt(numString);
					}
					return Integer.parseInt(numString);
				}
				i++;
			}

			if (isNegative) {
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
		}

		return 0;
	}
}
