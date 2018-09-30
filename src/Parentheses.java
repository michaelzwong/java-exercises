import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class Parentheses {
	
	/**
	 * 
	 * Open brackets must be closed by the same type of brackets.
	 * Open brackets must be closed in the correct order.
	 * 
	 * @param s - Parentheses to check
	 * @return boolean - Whether or not parentheses are valid
	 */
	public boolean isValid(String s) {
        
		// Empty string
        if(s.length() == 0) {
            return true;
        }
        // Odd number of letters
        if(s.length() % 2 == 1) {
            return false;
        }
        
        // Create Map to store Parentheses pairings
        Map<Character,Character> mMap = new HashMap<Character,Character>();
        
        mMap.put('(',')');
        mMap.put('{','}');
        mMap.put('[',']');
        
        // Loop through each char
        int i = 0;
        String leftParens = "";
        boolean closed = false;
        while(i < s.length()) {
            // If (, {, or [.
            if(mMap.containsKey(s.charAt(i))) {
                // System.out.print("Added "  + s.charAt(i));
                leftParens += s.charAt(i);
                // System.out.println(" Now: " + leftParens);
                closed = false;
            }
            // If ), }, or ].
            if(mMap.containsValue(s.charAt(i))) {
                // System.out.println("s.charAt(i): "+s.charAt(i));
                if(leftParens=="") {
                    return false;
                }
                // Check if it closes the most recent left parentheses
                char lastParen = mMap.get(leftParens.charAt(leftParens.length() - 1));
                // System.out.println(lastParen);
                if(lastParen != s.charAt(i)) {
                    // System.out.println(lastParen + " != " + s.charAt(i));
                    return false;
                } else {
                    leftParens = leftParens.substring(0, leftParens.length()-1);
                    // System.out.println("leftParens = " + leftParens);
                }
                if(leftParens.equals("")) {
                    closed = true;
                }
            }
            i++;
            
            
            
            // String rightParens = "";
            // // If ), }, or ].
            // if(i < s.length() && mMap.containsValue(s.charAt(i))) {
            //     while(i < s.length() && mMap.containsValue(s.charAt(i))) {
            //         rightParens += s.charAt(i);
            //         i++;
            //     }
            //     String reverseParens = reverseParentheses(leftParens, mMap);
            //     leftParens = "";
            //     if(!rightParens.equals(reverseParens)) {
            //         System.out.println(rightParens + " != " + reverseParens);
            //         return false; 
            //     }
            //     closed = true;
            // }
        }
        return closed;
	}
    private String reverseParentheses(String seq, Map<Character,Character> mMap) {
        String reverse = "";
        for(int i = seq.length() - 1; i >= 0; i --) {
            reverse += mMap.get(seq.charAt(i));
        }
        return reverse;
    }
}
