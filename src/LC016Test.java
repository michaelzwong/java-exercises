import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC016Test {

	@Test
	void test() {
		LC016 test = new LC016();
		int[] nums = new int[]{1,2,3};
		assertEquals(test.threeSumClosest(nums, 3), 6);
		int[] nums2 = new int[] {-1,2,1,-4};
		assertEquals(test.threeSumClosest(nums2, 1), 2);
	}

}
