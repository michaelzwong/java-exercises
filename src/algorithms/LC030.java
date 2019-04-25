package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		Set<String> wordSet = new HashSet<String>();
		for(int i = 0; i < words.length; i ++) {
			wordSet.add(words[i]);
		}
		
		for(int i = 0; i < s.length(); i ++) {
			
		}
		return null;
	}

}
