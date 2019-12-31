package algorithms;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC002 {
    /**
     * Given are two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a
     * single digit. Adds the two numbers and return it as a linked list. Assume the
     * two numbers do not contain any leading zero, except the number 0 itself.
     *
     * @param l1 - Number 1
     * @param l2 - Number 2
     * @return LinkedNode - LinkedList representation of sum.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = new ListNode(0);
        dummy.next = cur;
        ListNode next = new ListNode(0);
        while (l1 != null || l2 != null) {
            int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;
            int sum = cur.val + first + second;
            cur.val = sum > 9 ? sum % 10 : sum;
            if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || sum > 9) {
                next = sum > 9 ? new ListNode(1) : new ListNode(0);
                cur.next = next;
                cur = cur.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;

    }

    /**
     * Definition for singly-linked list.
     *
     * @author michaelwong
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}