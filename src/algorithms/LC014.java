package algorithms;
/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC014 {
	/**
	 * 
	 * Finds the longest common prefix string amongst an array of strings. If there
	 * is no common prefix, return an empty string "".
	 * 
	 * @param strs - Array of strings
	 * @return String - Longest common prefix
	 */
	public String findLongestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        String answer = "";
        int j = 0;
        while(j < minLength) {
            char c = strs[0].charAt(j);
            for(int i = 1; i < strs.length; i++) {
                if(strs[i].charAt(j) != c) {
                    return answer;
                }
            }
            answer += c;
            j++;
        }
        return answer;
	}
}
