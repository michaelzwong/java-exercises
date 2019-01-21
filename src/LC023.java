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
				if (l1.val < l2.val) {
					return -1;
				} else if (l1.val == l2.val) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		
		for(ListNode node : lists) {
			if(node != null)
				pQueue.add(node);
			
		}
		
		return null;
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
