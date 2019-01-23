package algorithms;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC020 {

	/**
	 * Open brackets must be closed by the same type of brackets. Open brackets must
	 * be closed in the correct order.
	 * 
	 * @param s - Parentheses to check
	 * @return boolean - Whether or not parentheses are valid
	 */
	public boolean isValid(String s) {

		// Empty string
		if (s.length() == 0) {
			return true;
		}
		// Odd number of letters
		if (s.length() % 2 == 1) {
			return false;
		}

		// Create Map to store Parentheses pairings
		Map<Character, Character> mMap = new HashMap<Character, Character>();

		mMap.put('(', ')');
		mMap.put('{', '}');
		mMap.put('[', ']');

		// Loop through each char
		int i = 0;
		String leftParens = "";
		boolean closed = false;
		while (i < s.length()) {
			// If (, {, or [.
			if (mMap.containsKey(s.charAt(i))) {
				// System.out.print("Added " + s.charAt(i));
				leftParens += s.charAt(i);
				// System.out.println(" Now: " + leftParens);
				closed = false;
			}
			// If ), }, or ].
			if (mMap.containsValue(s.charAt(i))) {
				// System.out.println("s.charAt(i): "+s.charAt(i));
				if (leftParens == "") {
					return false;
				}
				// Check if it closes the most recent left parentheses
				char lastParen = mMap.get(leftParens.charAt(leftParens.length() - 1));
				// System.out.println(lastParen);
				if (lastParen != s.charAt(i)) {
					// System.out.println(lastParen + " != " + s.charAt(i));
					return false;
				} else {
					// Subtract the last parentheses from leftParens
					leftParens = leftParens.substring(0, leftParens.length() - 1);
					// System.out.println("leftParens = " + leftParens);
				}
				if (leftParens.equals("")) {
					closed = true;
				}
			}
			i++;

		}
		return closed;
	}

	/**
	 * Stack Implementation
	 * 
	 * @param s - Parentheses to check
	 * @return boolean - Whether or not parentheses are valid
	 */
	public static boolean isValidStack(String s) {

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
