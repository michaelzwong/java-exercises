/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LongestCommonPrefix {
	/**
	 * 
	 * Finds the longest common prefix string amongst an array of strings.
	 * If there is no common prefix, return an empty string "".
	 * 
	 * @param strs - Array of strings
	 * @return String - Longest common prefix
	 */
	public String findLongestCommonPrefix(String[] strs) {
        int arrSize = strs.length; // Length of array
        if(strs.length == 0) return "";
        int minLength = strs[0].length(); // Shortest string in strs
        for(int i = 0; i < arrSize; i++) { // Find the shortest string
            if(strs[i].length() < minLength)
                minLength = strs[i].length();
        }
        String prefix =""; // Prefix
        String testPrefix = "";
        boolean matches = true; // Check for matching prefixes
        // Loop through the characters each string at most "minLength" times
        for(int i = 0; i < minLength; i++) {
            // Loop through each string in the array
            for(int j = 0; j < arrSize; j++) {
                // Test prefix for each string in the array
                testPrefix = strs[0].substring(0,i+1);
                // System.out.println("Test Prefix: " + testPrefix);
                // Check fo prefix matches
                if(!testPrefix.equals(strs[j].substring(0,i+1))) {
                    matches = false;
                    break;
                }
            }
            if(!matches) {
                prefix = strs[0].substring(0,i);
                break;
            }
        }
        if(matches) {
            prefix = strs[0].substring(0,minLength);
        }
        return prefix;
    }
}
