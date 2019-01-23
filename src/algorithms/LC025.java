package algorithms;
/**
 * LeetCode Hard.
 * 
 * @author michaelwong
 *
 */
public class LC025 {

	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * k is a positive integer and is less than or equal to the length of the linked
	 * list. If the number of nodes is not a multiple of k then left-out nodes in
	 * the end should remain as it is.
	 * 
	 * Only constant extra memory is allowed. You may not alter the values in the
	 * list's nodes, only nodes itself may be changed.
	 * 
	 * @param head - Head of linked list.
	 * @param k    - Reverse the linked list k at a time.
	 * @return ListNode - Head of altered linked list.
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		int count = getCount(head, k);

		int numIters = count / k;

		return reverseGroup(head, k, numIters);
	}

	private ListNode reverseGroup(ListNode node, int k, int numIters) {
		if (numIters == 0) {
			return node;
		}
		/* First node in the group */
		ListNode tail = null;
		/* Last node in the group */
		ListNode head = null;

		ListNode prev = null;
		ListNode cur = node;
		ListNode next = null;

		// Loop through the linked list k times
		for (int i = 0; i < k; i++) {
			next = cur.next;
			if (tail == null) {
				tail = cur;
			} else {
				cur.next = prev;
			}
			prev = cur;
			cur = next;
		}
		head = prev;

		tail.next = reverseGroup(cur, k, numIters - 1);

		return head;
	}

	private int getCount(ListNode head, int k) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
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
