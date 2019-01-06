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
		
		// Handle cases where pattern could be an expression for an empty string
		// ex. a*, a*p*, a*p*p*, etc...
		for(int i = 1; i < matches[0].length; i++) {
			if(p.charAt(i - 1) == '*') {
				matches[0][i] = matches[0][i - 2];
			}
		}
		
		
		
		// Loop through the string and pattern
		for(int i = 1; i < matches.length; i++) {
			for(int j = 1; j < matches[0].length; j++) {
				// Case 1: match or '.'
				if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
					// Value is equal to substring up to and not including
					// characters at index i and j
					matches[i][j] = matches[i - 1][j - 1];
				}
				// Case 2: '*'
				else if(p.charAt(j - 1) == '*') {
					// When * means 0 of the preceding character
					matches[i][j] = matches[i][j - 2];
					// Check the character before * and its preceding character
					if(p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
						matches[i][j] = matches[i][j]|matches[i - 1][j];
					}
				}
				// Case 3: no match
				else {
					matches[i][j] = false;
				}
			}
		}
		
		return matches[s.length()][p.length()];
	}
}
