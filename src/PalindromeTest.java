import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for LC5.
 * 
 * @author michaelwong
 *
 */
public class PalindromeTest {

	@Test
	void testIsPalindrome() {
		assertEquals(true, LC5.isPalindrome("hannah"));
		assertEquals(false, LC5.isPalindrome("banana"));
		assertEquals(true, LC5.isPalindrome("tattarrattat"));

		// String testString ="babaddtattarrattatddetartrateedredividerb";
//		while(!testString.equals("")) {
//			System.out.println(testString);
//			// testString = testString.substring(1, testString.length()-1);
//		}
	}

	@Test
	void testLongestPalindrome() {
		assertEquals("hannah", LC5.longestPalindrome("himynameishannah"));
		assertEquals("anana", LC5.longestPalindrome("banana"));
		assertEquals("bananab", LC5.longestPalindrome("sdfbananabasdf"));
		// assertEquals("tattarrattat",
		// Palindrome.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
	}

}
