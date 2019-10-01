package algorithms;
import java.util.Map;
import java.util.HashMap;

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

        int ans = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = -1, j = 0; j < length; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(j - i, ans);
            map.put(s.charAt(j), j);
        }
        return ans;
	}
}
