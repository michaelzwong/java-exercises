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
		assertEquals(true, Palindrome.isPalindrome("tattarrattat"));
		
		// String testString ="babaddtattarrattatddetartrateedredividerb"; 
//		while(!testString.equals("")) {
//			System.out.println(testString);
//			// testString = testString.substring(1, testString.length()-1);
//		}
	}
	
	@Test
	void testLongestPalindrome() {
		assertEquals("hannah", Palindrome.longestPalindrome("himynameishannah"));
		assertEquals("anana", Palindrome.longestPalindrome("banana"));
		assertEquals("bananab", Palindrome.longestPalindrome("sdfbananabasdf"));
		// assertEquals("tattarrattat", Palindrome.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
	}

}
