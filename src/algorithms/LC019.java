package algorithms;
/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC019 {
	/**
	 * Given a linked list, remove the n-th node from the end of list and return its
	 * head.
	 * 
	 * @param head - The head of the linked list
	 * @param n    - The n-th node from the end of the list to remove
	 * @return ListNode - Linked list with n-th node from end removed
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Dummy before the start of the linked list
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode ptrOne = dummy;
		ListNode ptrTwo = dummy;

		// Advance ptrTwo so that the there are n + 1 nodes in between the two pointers
		for(int i = 0; i <= n; i++) {
			ptrTwo = ptrTwo.next;
		}
		
		while(ptrTwo != null) {
			ptrOne = ptrOne.next;
			ptrTwo = ptrTwo.next;
		}
		
		// At this point, ptrTwo is at the end (null)
		ptrOne.next = ptrOne.next.next;

		return dummy.next;
	}

	/**
	 * Definition for singly-linked list.
	 * 
	 * @author michaelwong
	 *
	 */
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
