package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC020 {

    /**
     * Open brackets must be closed by the same type of brackets. Open brackets must
     * be closed in the correct order.
     *
     * @param s - Parentheses to check
     * @return boolean - Whether or not parentheses are valid
     */
    public boolean isValidStack(String s) {

        Map<Character, Character> mMap = new HashMap<Character, Character>();

        mMap.put(')', '(');
        mMap.put('}', '{');
        mMap.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mMap.containsKey(c)) {
                char topElement = stack.empty() ? '$' : stack.pop();

                if (topElement != mMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }
}
