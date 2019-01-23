package algorithms;
/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC013 {
	/**
	 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
	 * within the range from 1 to 3999.
	 * 
	 * @param s - Roman Number
	 * @return int - Integer representation of the number
	 */
	public int romanToInt(String s) {
		int i = 0; // for s
		int result = 0;

		// Loop through the characters
		while (i < s.length()) {
			switch (s.charAt(i)) {
			case 'I':
				result++;
				break;
			case 'V':
				result += 5;
				// Check if I is before V
				if (i > 0 && s.charAt(i - 1) == 'I')
					result -= 1 * 2;
				break;
			case 'X':
				result += 10;
				// Check if I is before X
				if (i > 0 && s.charAt(i - 1) == 'I')
					result -= 1 * 2;
				break;
			case 'L':
				result += 50;
				// Check if I is before X
				if (i > 0 && s.charAt(i - 1) == 'X')
					result -= 10 * 2;
				break;
			case 'C':
				result += 100;
				// Check if X is before L
				if (i > 0 && s.charAt(i - 1) == 'X')
					result -= 10 * 2;
				break;
			case 'D':
				result += 500;
				// Check if C is before D
				if (i > 0 && s.charAt(i - 1) == 'C')
					result -= 100 * 2;
				break;
			case 'M':
				result += 1000;
				// Check if C is before M
				if (i > 0 && s.charAt(i - 1) == 'C')
					result -= 100 * 2;
				break;
			default:
				break;
			}
			i++;
		}
		return result;
	}
}
