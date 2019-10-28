package algorithms;

/**
 * LeetCode Hard.
 *
 * @author michaelwong
 *
 */
public class LC032 {

	/**
   * Given a string containing just the characters '(' and ')', find the length
   * of the longest valid (well-formed) parentheses substring.
	 *
	 * @param s - The string of parentheses.
	 * @return int - Number of parentheses valid.
	 */
   public int longestValidParentheses(String s) {
      int left = 0;
      int right = 0;
      int longest = 0;
      for(char c : s.toCharArray()) {
          if(c=='(') {
              left++;
          } else {
              right ++;
          }
          if(left == right) {
              longest = Math.max(longest, right*2);
          } else if(left < right) {
              left = 0;
              right = 0;
          }
      }
      left = 0;
      right = 0;
      for(int i = s.length() - 1; i >= 0; i--) {
          if(s.charAt(i)==')') {
              right++;
          } else {
              left++;
          }
          if(right == left) {
              longest = Math.max(longest, left*2);
          } else if(right < left) {
              right = 0;
              left = 0;
          }
      }

      return longest;

  }

}
