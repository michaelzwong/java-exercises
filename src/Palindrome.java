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
        if(isPalindrome(s)) {
            return s;
        }
        String divisionOne = longestPalindrome(s.substring(0,s.length()-1));
        String divisionTwo = longestPalindrome(s.substring(1,s.length()));                                   
        return (divisionOne.length() >= divisionTwo.length()) ? divisionOne : divisionTwo;
    }
    
    private static boolean isPalindrome(String s) {
        if(s.length() == 1 || s.length() == 0) {
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
