import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC010Test {
	
	private LC010 test = new LC010();
	
	void init() {
		
	}

	@Test
	void testEmptyStrings() {		
		assertTrue(test.isMatch("", ""));
	}
	
	@Test
	void testSameStrings() {
		assertTrue(test.isMatch("apple", "apple"));
	}
	
	@Test
	void testDifferentStrings() {
		assertFalse(test.isMatch("aapl", "apple"));
	}
	
	@Test
	void testWithStar() {
		
	}

}
