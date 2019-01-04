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
		
		// Empty string and pattern
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}
		
		if(s.length() == p.length() && s.equals(p)) {
			return true;
		}
		
		int i = 0;
		
		while(i < p.length()) {
			
			if(p.charAt(i) == s.charAt(i)) {
				continue;
			}
			
			if(p.charAt(i) == '*') {
				
			}
			
			if(p.charAt(i) == '.') {
				
			}
			
		}
		
		return false;
	}
}
