package algorithms;
/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC005 {

	/**
	 * Given a string s, find the longest palindromic substring in s. You may assume
	 * that the maximum length of s is 1000.
	 * 
	 * @param s - String to look through
	 * @return String - The longest palindrome found
	 */
    public String longestPalindrome(String s) {
        // s can be null or have length of 0
        if(s == null || s.length() == 0) {
            return "";
        }
        // Keep track of the longest palindrome so far
        String maxPalindrome = "";
        // Loop through each char in s
        for(int i = 0; i < s.length(); i++) {
            // Find length of palindrome centered at each char c
            // Case 1: palindrome is centered at i
            int len1 = getPalindromeLength(s, i, i);
            // Case 2: palindrome is centered between i and i + 1
            int len2 = getPalindromeLength(s, i, i + 1);
            // Find which length is longer
            int len = Math.max(len1, len2);
           
            if(len > maxPalindrome.length()) {
                String palindrome;
                if(len % 2 == 0) {
                    palindrome = s.substring(i - len/2 + 1, i + len/2 + 1);
                } else {
                    palindrome = s.substring(i - len/2, i + len/2 + 1);
                }
                maxPalindrome = len > maxPalindrome.length() ? palindrome : maxPalindrome;
            }
            
        }
        return maxPalindrome;
    }
    // Get the longest palindrome 
    private int getPalindromeLength(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
