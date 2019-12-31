package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC022 {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations
     * of well-formed parentheses.
     *
     * @param n - The number of pairs of parentheses
     * @return List<String> - List of all the combinations.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recurse("", result, n, n);
        return result;
    }

    private void recurse(String substr, List<String> result, int left, int right) {
        if (left > right) {
            return;
        }
        if (left > 0) {
            recurse(substr + "(", result, left - 1, right);
        }
        if (right > 0) {
            recurse(substr + ")", result, left, right - 1);
        }
        if (left == 0 && right == 0) {
            result.add(substr);
            return;
        }
    }

}
