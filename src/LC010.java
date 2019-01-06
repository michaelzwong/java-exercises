/**
 * LeetCode Hard.
 * 
 * @author michaelwong
 *
 */
public class LC010 {
	/**
	 * Given an input string (s) and a pattern (p), implement regular expression
	 * matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character.
	 * '*' Matches zero or more of the preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * @param s - String sequence
	 * @param p - Pattern sequence
	 * @return boolean - Whether the matches the string
	 */
	public boolean isMatch(String s, String p) {
		
		// Use length + 1 so that index 0 can accommodate empty strings
		
		// Use a 2D array to dynamically store if the character at index i of
		// s string matches the character at index j of p pattern
		boolean matches[][] = new boolean[s.length() + 1][p.length() + 1];
		
		// Empty strings
		matches[0][0] = true;
		
		// Loop through the string and pattern
		for(int i = 0; i < matches.length; i++) {
			for(int j = 0; j < matches[0].length; j++) {
				// Case 1: match or '.'
				if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					// Value is equal to substring up to and not including
					// characters at index i and j
					matches[i + 1][j + 1] = matches[i][j];
				}
				// Case 2: '*'
				else if(p.charAt(j) == '*') {
					// Check whether the substrin
					matches[i + 1][j + 1] = matches[i + 1][j - 1];
					if(pattern[])
					
				}
				// Case 3: no match
				else {
					
				}
			}
		}
		
		return false;
	}
}
