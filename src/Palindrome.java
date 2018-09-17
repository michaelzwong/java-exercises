/**
 * 
 * @author michaelwong
 *
 */
public class Palindrome {
	// Checks if an integer is a palindrome
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
}
