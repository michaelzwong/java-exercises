/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC14 {
	/**
	 * 
	 * Finds the longest common prefix string amongst an array of strings. If there
	 * is no common prefix, return an empty string "".
	 * 
	 * @param strs - Array of strings
	 * @return String - Longest common prefix
	 */
	public String findLongestCommonPrefix(String[] strs) {
		int arrSize = strs.length; // Length of array
		if (strs.length == 0)
			return "";
		int minLength = strs[0].length(); // Shortest string in strs
		for (int i = 0; i < arrSize; i++) { // Find the shortest string
			if (strs[i].length() < minLength)
				minLength = strs[i].length();
		}
		String testPrefix = "";
		// Loop through the characters each string at most "minLength" times
		for (int i = 0; i < minLength; i++) {
			// Loop through each string in the array
			for (int j = 0; j < arrSize; j++) {
				// Test prefix for each string in the array
				testPrefix = strs[0].substring(0, i + 1);
				// System.out.println("Test Prefix: " + testPrefix);
				// Check fo prefix matches
				if (!testPrefix.equals(strs[j].substring(0, i + 1))) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0].substring(0, minLength);
	}

	/**
	 * 
	 * Finds the longest common prefix string amongst an array of strings. If there
	 * is no common prefix, return an empty string "".
	 * 
	 * This is a more efficient solution.
	 * 
	 * @param strs
	 * @param efficient
	 * @return
	 */
	public String findLongestCommonPrefix(String[] strs, boolean efficient) {
		int arrSize = strs.length; // Length of array
		if (strs.length == 0)
			return "";
		String minString = "";
		int minLength = strs[0].length(); // Shortest string in strs
		for (int i = 0; i < arrSize; i++) { // Find the shortest string
			if (strs[i].length() <= minLength) {
				minLength = strs[i].length();
				minString = strs[i];
			}
		}
		for (int i = 0; i < arrSize; i++) {
			// If the string does not contain the minimum string
			while (!(strs[i].substring(0, minString.length()).equals(minString))) {
				System.out.println(minString);
				minString = minString.substring(0, minString.length() - 1);
			}

		}
		return minString;
	}
}
