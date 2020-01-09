package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC061 {

    /**
     * Given a linked list, rotate the list to the right by k places, where k is
     * non-negative.
     *
     * @param n - n! unique permutations
     * @param k - k-th permutation sequence
     * @return String - the k-th permutation sequence in String format
     */
    public ListNode rotateRight(ListNode head, int k) {
       if(head == null || head.next == null) return head;
       ListNode dummy = new ListNode(-1);
       dummy.next = head;
       ListNode n1 = dummy, n2 = dummy;

       int i;
       for(i = 0; n1.next != null; i++) {
           n1 = n1.next;
       }

       // Find out how many places to move to reach the rotation point
       int numPlaces = i - k % i;

       int j;
       for(j = 0; j < numPlaces; j++) {
           n2 = n2.next;
       }
       n1.next = dummy.next;
       dummy.next = n2.next;
       n2.next = null;

       return dummy.next;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
