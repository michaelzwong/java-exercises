/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC9 {
	/**
	 * Determine whether an integer is a palindrome. An integer is a palindrome when
	 * it reads the same backward as forward.
	 * 
	 * @param x - Integer to check
	 * @return boolean - Palindrome or not
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int palindrome = 0;
		for (int i = x; i != 0; i /= 10) {
			palindrome = palindrome * 10 + i % 10;
		}
		return palindrome == x;
	}
}
