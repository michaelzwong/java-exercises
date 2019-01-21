import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode Hard.
 * 
 * @author michaelwong
 *
 */
public class LC023 {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 * 
	 * @param lists - The list of linked lists to be merged.
	 * @return ListNode - The head of the merged linked list.
	 */
	public ListNode mergeKLists(ListNode[] lists) {

		Queue<ListNode> pQueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		
		for(ListNode node : lists) {
			if(node != null)
				pQueue.add(node);
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while(!pQueue.isEmpty()) {
			// Remove the node containing the smallest integer
			tail.next = pQueue.poll();
			tail = tail.next;
			
			if(tail.next != null)
				pQueue.add(tail.next);
		}
		
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
