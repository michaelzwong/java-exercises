import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC017 {
	/**
	 * Given a string containing digits from 2-9 inclusive, return all possible
	 * letter combinations that the number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is given
	 * below. Note that 1 does not map to any letters.
	 * 
	 * This solution is iterative.
	 * 
	 * @param digits - The numbers that will be used to generate letter combinations
	 * @return List<String> - List of letter combinations
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();

		if (digits.length() == 0) {
			return result;
		}

		final Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(0, "");
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		
		Queue<String> combinations = new LinkedList<String>();
		
		// Get letters from the first digit
		String firstLetters = map.get(digits.charAt(0) - '0');
		
		// Add each letter from the first digit to the
		for(int i = 0; i < firstLetters.length(); i++) {
			combinations.offer(firstLetters.charAt(i) + "");
		}
		
		// Loop through the remaining digits
		for(int i = 1; i < digits.length(); i++) {
			// Get the letters for each digit
			String letters = map.get(digits.charAt(i) - '0'); 
			int size = combinations.size();
			// Loop through the queue of combinations
			for(int j = 0; j < size; j++) {
				// Dequeue an element from the queue
				String e = combinations.poll();
				// Loop through the number of letters for the i-th digit
				for(int k = 0; k < letters.length(); k++) {
					// For each letter, enqueue the element + letters for the i-th digit
					combinations.offer(e + letters.charAt(k));
				}
			}
		}
		
		// Transfer combinations from queue to a list
		while(!combinations.isEmpty()) {
			result.add(combinations.poll());
		}

		return result;

	}
	
	/**
	 * This solution is iterative.
	 * 
	 * @param digits - The numbers that will be used to generate letter combinations
	 * @return List<String> - List of letter combinations
	 */
	public List<String> letterCombinationsRecursive(String digits) {
		
		return null;
	}
}
