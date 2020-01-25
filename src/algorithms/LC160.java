package algorithms;

/**
 * LeetCode Easy.
 *
 * @author michaelwong
 */
public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode iterA = headA;
        ListNode iterB = headB;
        // Count the length of list 1
        while(iterA != null) {
            iterA = iterA.next;
            lenA++;
        }
        // Count the length of list 2
        while(iterB != null) {
            iterB = iterB.next;
            lenB++;
        }
        // Find the longer list
        ListNode longerList = null, shorterList = null;
        int s = 0, l = 0;
        if(lenA >= lenB) {
            longerList = headA;
            shorterList = headB;
            s = lenB;
            l = lenA;
        } else {
            longerList = headB;
            shorterList = headA;
            s = lenA;
            l = lenB;
        }
        int i = 0;
        while(i < l - s) {
            longerList = longerList.next;
            i++;
        }

        while(longerList != null && shorterList != null) {
            if(longerList == shorterList) {
                return longerList;
            }
            longerList = longerList.next;
            shorterList = shorterList.next;
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
