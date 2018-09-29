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
        boolean closed = true;
        while(i < s.length()) {
            // If (, {, or [.
            if(mMap.containsKey(s.charAt(i))) {
                closed = false;
                // System.out.println("Contains Key "  + s.charAt(i));
                leftParens += s.charAt(i);
                i++;
                
            }
            String rightParens = "";
            // If ), }, or ].
            if(i < s.length() && mMap.containsValue(s.charAt(i))) {
                while(i < s.length() && mMap.containsValue(s.charAt(i))) {
                    rightParens += s.charAt(i);
                    i++;
                }
                String reverseParens = reverseParentheses(leftParens, mMap);
                leftParens = "";
                if(!rightParens.equals(reverseParens)) {
                    System.out.println(rightParens + " != " + reverseParens);
                    return false; 
                }
                closed = true;
            }
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
