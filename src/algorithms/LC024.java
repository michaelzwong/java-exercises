package algorithms;
/**
 * LeetCode Medium.
 * 
 * @author michaelwong
 *
 */
public class LC024 {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * @param head - the list to swap adjacent nodes
	 * @return ListNode - the list with swapped adjacent nodes
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode first = head;
		ListNode second = head.next;
		ListNode prev = null;

		boolean updateHead = false;

		// Loop through two adjacent nodes at a time
		while (first != null && second != null) {

			ListNode temp = new ListNode(first.val); // Temporary node for swapping

			// Swap two nodes
			first = second;
			second = temp;
			second.next = first.next;
			first.next = second;

			// Update head if not updated already
			if (!updateHead) {
				head = first;
				updateHead = true;
			}

			// Link newly swapped nodes with the nodes before
			if (prev != null) {
				prev.next = first;
			}
			prev = second;

			// Proceed to the next two nodes
			first = second.next;
			if (first != null && second.next != null)
				second = second.next.next;

		}
		return head;

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
