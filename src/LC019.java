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
	 * @param n - The n-th node from the end of the list to remove
	 * @return ListNode - Linked list with n-th node from end removed
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Dummy before the start of the linked list
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// Use two pointers to traverse the linked list
		ListNode ptrOne = dummy;
		ListNode ptrTwo = dummy;

		// Keep the pointers n + 1 nodes apart.
		// Ex. n = 2, then if ptrOne = length - 3 and ptrTwo = length
		// Once ptrTwo hits the end of the list, ptrOne will
		// be at the node before the Nth node
		for (int i = 1; i <= n + 1; i++) {
			ptrTwo = ptrTwo.next;
		}

		while (ptrTwo != null) {
			ptrOne = ptrOne.next;
			ptrTwo = ptrTwo.next;
		}

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
