import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC003 {
	/**
	 * Given a string, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * @param s - The given string
	 * @return int - Longest substring
	 */
	public int lengthOfLongestSubstring(String s) {

		int i = 0; // Keeps track of current index for s
		int j = 0; // Count of longest
		int start = 0;
		int longest = 0;
		List<Character> charList = new ArrayList<Character>();

		while (i < s.length()) {
			// Record index of first character in substring

			// Get the current character
			char currChar = s.charAt(i);

			// If the current character is in the list
			if (charList.contains(currChar)) {
				i = start;
				charList.clear();
				j = 0;
			} else {
				if (charList.isEmpty()) {
					start = i;
				}
				charList.add(s.charAt(i));
				j++;
			}
			i++;
			if (j > longest)
				longest = j;
		}
		return longest;
	}
}
