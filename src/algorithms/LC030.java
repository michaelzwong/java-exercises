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
 			 List<Integer> substrings = new ArrayList<Integer>();
 			 if(s.length()==0 || words.length==0) {
 					 return substrings;
 			 }
 			 int length = words.length * words[0].length();
 			 if(s.length() < length) {
 					 return substrings;
 			 }
 			 Map<String, Integer> wordMap = new HashMap<String, Integer>();
 			 for(String word : words) {
 					 if(wordMap.containsKey(word)) {
 							 wordMap.put(word, wordMap.get(word) + 1);
 					 } else {
 							 wordMap.put(word, 1);
 					 }
 			 }
 			 // Length of concatenation
 			 int i = 0;
 			 while(i < s.length() - length + 1) {
 					 if(isConcatenation(s.substring(i, i + length), wordMap, words[0].length(), words.length)) {
 							 substrings.add(i);
 					 }
 					 i++;
 			 }
 			 return substrings;
 	 }

 	 private boolean isConcatenation(String s, Map wordMap, int wordLength, int numWords) {
 			 int i = 0;
 			 Map<String, Integer> copy = new HashMap<String, Integer>();
 			 copy.putAll(wordMap);
 			 while(i < numWords) {
 					 String key = s.substring(i*wordLength, i*wordLength + wordLength);
 					 if(copy.containsKey(key)) {
 							 if(copy.get(key) > 1) {
 									 copy.put(key, copy.get(key) - 1);
 							 } else {
 									 copy.remove(key);
 							 }
 					 } else {
 							 return false;
 					 }
 					 i++;
 			 }
 			 return copy.isEmpty();
 	 }

}
