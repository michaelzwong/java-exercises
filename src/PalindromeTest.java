import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author michaelwong
 *
 */
public class PalindromeTest {

	@Test
	void testIsPalindrome() {
		assertEquals(true, Palindrome.isPalindrome("hannah"));
		assertEquals(false, Palindrome.isPalindrome("banana"));
	}
	
	@Test
	void testLongestPalindrome() {
		assertEquals("hannah", Palindrome.longestPalindrome("himynameishannah"));
		assertEquals("anana", Palindrome.longestPalindrome("banana"));
	}

}
