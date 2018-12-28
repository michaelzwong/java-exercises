/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC006 {

	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
	 * of rows like this: (you may want to display this pattern in a fixed font for
	 * better legibility)
	 * 
	 * P A H N A P L S I I G Y I R
	 * 
	 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a
	 * string and make this conversion given a number of rows
	 * 
	 * @param s       - String to convert
	 * @param numRows - number of rows for the zigzag conversion
	 * @return - converted String
	 */
	public String convert(String s, int numRows) {
		// P H
		// A SI
		// Y I R
		// P L I G
		// A N

		// Return the string, no ZigZag conversion
		if (numRows == 0 || numRows == 1) {
			return s;
		}

		// Divide the string up into numRows number of Strings and
		// Then fill the Strings up in a zig-zag pattern
		String[] stringArray = new String[numRows];

		for (int i = 0; i < numRows; i++) {
			stringArray[i] = "";
		}

		// Downward pattern
		int numZigs = numRows;
		// Upward pattern
		int numZags = Math.max(0, numRows - 2);

		int i = 0;

		int j = 0;

		while (i < s.length()) {
			// Zig (downward pattern)
			while (i < s.length() && j < numZigs) {
				stringArray[j] += String.valueOf(s.charAt(i));
				j++;
				i++;
			}
			j = numZags;
			// Zag (upward pattern)
			while (i < s.length() && j > 0) {
				stringArray[j] += String.valueOf(s.charAt(i));
				j--;
				i++;
			}
			j = 0;
		}

		String finalString = "";
		for (int k = 0; k < numRows; k++) {
			finalString += stringArray[k];
		}

		return finalString;
	}

}
