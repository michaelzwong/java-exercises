package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode Hard.
 * 
 * @author michaelwong
 *
 */
public class LC030 {

	/**
	 * You are given a string, s, and a list of words, words, that are all of the
	 * same length. Find all starting indices of substring(s) in s that is a
	 * concatenation of each word in words exactly once and without any intervening
	 * characters.
	 * 
	 * @param s - The string to search from.
	 * @param words - The target words.
	 * @return List<Integer> - List of starting indices of the substrings in s.
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		
		// Retrieve the length of a word
		int wordLength = words[0].length();
		
		// Keep track of the usage of each word
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i ++) {
			// If wordMap already contains the key, increment its value by 1 (number of times the word is in the HashMap)
			if(wordMap.containsKey(words[i])) {
				wordMap.put(words[i], wordMap.get(words[i]) + 1);
			} else {
				wordMap.put(words[i], 0);
			}
		}
		
		int j = 0;
		
		while(j + wordLength < s.length() && !wordMap.isEmpty()) {
			String word = s.substring(j, j + wordLength);
			if(wordMap.containsKey(word)) {
				wordMap.remove(word);
			}
		}
		return null;
	}

}
