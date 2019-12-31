package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC017 {
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible
     * letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given
     * below. Note that 1 does not map to any letters.
     * <p>
     * This solution is iterative.
     *
     * @param digits - The numbers that will be used to generate letter combinations
     * @return List<String> - List of letter combinations
     */
    public List<String> letterCombinations(String digits) {

        // Stores the final results of all possible combinations of letters
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
        for (int i = 0; i < firstLetters.length(); i++) {
            combinations.offer(firstLetters.charAt(i) + "");
        }

        // Loop through the remaining digits
        for (int i = 1; i < digits.length(); i++) {
            // Get the letters for each digit
            String letters = map.get(digits.charAt(i) - '0');
            int size = combinations.size();
            // Loop through the queue of combinations
            for (int j = 0; j < size; j++) {
                // Dequeue an element from the queue
                String e = combinations.poll();
                // Loop through the number of letters for the i-th digit
                for (int k = 0; k < letters.length(); k++) {
                    // For each letter, enqueue the element + letters for the i-th digit
                    combinations.offer(e + letters.charAt(k));
                }
            }
        }

        // Transfer combinations from queue to a list
        while (!combinations.isEmpty()) {
            result.add(combinations.poll());
        }

        return result;

    }

    final Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

    /**
     * This solution is recursive.
     *
     * @param digits - The numbers that will be used to generate letter combinations
     * @return List<String> - List of letter combinations
     */
    public List<String> letterCombinationsRecursive(String digits) {

        // Stores the final results of all possible combinations of letters
        List<String> result = new ArrayList<String>();

        if (digits.length() == 0) {
            return result;
        }

        map.put(0, Arrays.asList(""));
        map.put(1, Arrays.asList(""));
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        // Used to store a single combination of letters
        List<String> list = new ArrayList<String>();

        // The current level of the recursion
        int level = 0;

        recurse(list, result, digits, level);

        return result;
    }

    /**
     * Recursive method to generate all combinations of letters from the digits.
     *
     * @param list   - Used to generate one complete combination of letters.
     * @param result - Final result containing all combinations of letters.
     * @param digits - The digits to convert to letter combinations.
     * @param level  - The current level of the recursion.
     */
    private void recurse(List<String> list, List<String> result, String digits, int level) {

        // Base case: list contains a complete combination of letters. Add it to the
        // result.
        if (list.size() == digits.length()) {
            String str = "";
            for (String s : list) {
                str += s;
            }
            result.add(str);
            return;
        }

        // Recursive step: get the letters corresponding to the digit. Add it to the
        // list.
        // Once recursive steps return, remove it from the list.
        List<String> letters = map.get(digits.charAt(level) - '0');
        for (String l : letters) {
            list.add(l);
            recurse(list, result, digits, level + 1);
            list.remove(list.size() - 1);
        }

    }
}
