/**
 * LeetCode Easy.
 * 
 * @author michaelwong
 *
 */
public class LC021 {
	/**
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 * 
	 * @param l1 - LinkedList 1
	 * @param l2 - LinkedList 2
	 * @return ListNode - LinkedList representation of merged lists.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        if(l1 == null && l2 == null) {
            return null;
        }
        
        int firstValue = (l1.val <= l2.val) ? l1.val : l2.val;
        if(l1.val <= l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        ListNode list = new ListNode(firstValue);
        ListNode first = list;
        
        while(l1 != null || l2 != null) {
            
            if(l1 != null && l2 != null) {
                int value = (l1.val <= l2.val) ? l1.val : l2.val;
                if(l1.val <= l2.val) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
                list.next = new ListNode(value);
            } else if(l1 == null) {
                list.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if(l2 == null) {
                list.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            if(first == null) {
                first = list;
            }
            list = list.next;
        }
        return first;
        
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
