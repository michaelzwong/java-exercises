package algorithms;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC819 {

    /**
     * Given a paragraph and a list of banned words, return the most frequent word
     * that is not in the list of banned words.  It is guaranteed there is at
     * least one word that isn't banned, and that the answer is unique.
     * Words in the list of banned words are given in lowercase, and free of
     * punctuation.  Words in the paragraph are not case sensitive.
     * The answer is in lowercase.
     * <p>
     * Return the number of good subarrays of A.
     *
     * @param String   paragraph - paragraph we are counting from
     * @param String[] banned - banned words we don't count
     * @return String - Most common word that is not banned
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord);
        }
        Map<String, Integer> count = new HashMap<String, Integer>();
        String[] words = paragraph.split("[!?',;. ]+");
        int maxCount = 0;
        String maxString = "";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (bannedSet.contains(words[i])) {
                continue;
            }
            count.put(words[i], count.getOrDefault(words[i], 0) + 1);
            if (count.get(words[i]) > maxCount) {
                maxCount = count.get(words[i]);
                maxString = words[i];
            }
        }
        return maxString;
    }
}
