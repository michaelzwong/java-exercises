import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Easy + Medium.
 * 
 * @author michaelwong
 *
 */
public class Palindrome {
	/**
	 * Determine whether an integer is a palindrome. 
	 * An integer is a palindrome when it reads the same backward as forward.
	 * 
	 * @param x - Integer to check
	 * @return boolean - Palindrome or not
	 */
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        int palindrome = 0;
        for(int i = x; i != 0; i /= 10) {
            palindrome = palindrome*10 + i%10;
        }
        return palindrome == x;
    }
    
    public static String longestPalindrome(String s) {
    	
        if(s == null || s.length() == 1) {
        	return "";
        }
        
        
        // We will create an array to store the string
        // This will simplify the algorithm
        char[] charArray = new char[s.length()*2+1];
        
        int i = 0;
        
        // Insert a special character ('#') between each character in the string
        // as well as at the ends of the string
        // i.e. bob -> #b#o#b#
        while(i<charArray.length) {
        	charArray[i] = (i % 2 == 0) ? '#' : s.charAt((i-1)/2);
        	i++;
        }
        
        Map<Integer, Integer> centerLength = new HashMap<Integer,Integer>();
        for(int center = 0; center < charArray.length; center++) {
        	int j = 1;
        	int paliLength = 1;
        	while(center - j >= 0 && center + j < charArray.length) {
        		if(charArray[center - j] == charArray[center + j]) {
        			paliLength += 1;
        		} else {
        			// if()
        		}
        	}
        		
        }
//        
//        int[] intArray = new int[s.length()*2+1];
//        
//        // Loop through the string and find the longest palindrome containing center i
//        // and store the results in an int array
//        
//        int center = 0; // current center
//        int right = 0; // right limit
//        
//        for(i = 1; i < intArray.length; i++) {
//        	int mirror = center - (i - center);
//        	
//        	if(right > i) {
//        		intArray[i] = Math.min(right - i, intArray[mirror]);
//        	}
//        	
//        }
        
        return "";
    }
    
    /**
     * Helper method for longestPalindrome.
     * Checks if a string is a palindrome.
     * 
     * @param s - String to check
     * @return boolean - Palindrome or not
     */
    public static boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        int count = s.length() / 2;
        if(s.length() % 2 == 1) {
            count++;
        }
        for(int i = 0; i < count; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
