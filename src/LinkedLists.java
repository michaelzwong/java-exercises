/**
 * LeetCode Medium + Easy.
 * 
 * @author michaelwong
 *
 */
public class LinkedLists {
	
	/**
	 * Given are two non-empty linked lists representing two non-negative integers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit.
	 * Adds the two numbers and return it as a linked list.
	 * Assume the two numbers do not contain any leading zero, except the number 0 itself.
	 * 
	 * @param l1 - Number 1
	 * @param l2 - Number 2
	 * @return LinkedNode - LinkedList representation of sum.
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // int to carry over
        int carry = 0;
        
        int sum = 0;
                
        // Keeps track of the first node
        ListNode firstNode = null;
        // Keeps track of the next node
        ListNode nextNode = null;
        
        // Addition is finished when we get to the end of both LinkedLists
        while(l1 != null | l2 !=null) {
            sum = carry;
            if(l1 == null) {
                sum += l2.val;
            } else if (l2 == null) {
                sum += l1.val;
            } else {
                sum = sum + l1.val + l2.val;
            }
            
            if(sum >= 10 && firstNode == null) {
                firstNode = new ListNode(sum - 10);
                carry = 1;
                System.out.println("1 gets called.");

            } else if(firstNode == null) {
                firstNode = new ListNode(sum);
                carry = 0;
                System.out.println("2 gets called.");
            } else if(sum >= 10 && nextNode == null) {
                nextNode = new ListNode(sum - 10);
                firstNode.next = nextNode;
                carry = 1;
                System.out.println("3 gets called.");
            } else if(nextNode == null) {
                nextNode = new ListNode(sum);
                firstNode.next = nextNode;
                carry = 0;
                System.out.println("4 gets called.");
            } else if(sum >= 10) {
                nextNode.next = new ListNode(sum - 10);
                nextNode = nextNode.next;
                carry = 1;
                System.out.println("5 gets called.");
            } else {
                nextNode.next = new ListNode(sum);
                nextNode = nextNode.next;
                carry = 0;
                System.out.println("6 gets called.");
            }
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
 
        }
        
        if(carry == 1 && nextNode == null) {
            firstNode.next = new ListNode(carry);
        } else if (carry == 1){
            nextNode.next = new ListNode(carry);
        }

        return firstNode;  
        
    }
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
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * @param head - the list to swap adjacent nodes
	 * @return ListNode - the list with swapped adjacent nodes
	 */
	public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null;
        
        boolean updateHead = false;
        
        // Loop through two adjacent nodes at a time
        while(first != null && second != null) {
        	
            ListNode temp = new ListNode(first.val); // Temporary node for swapping
            
            // Swap two nodes
            first = second;
            second = temp;
            second.next = first.next;
            first.next = second;
            
            // Update head if not updated already
            if(!updateHead) {
                head = first; 
                updateHead = true;
            }
            
            // Link newly swapped nodes with the nodes before
            if(prev != null) {
                prev.next = first;
            }
            prev = second;
            
            // Proceed to the next two nodes
            first = second.next;
            if(first != null && second.next != null) second = second.next.next;
            

        }
        return head;
        
    }
	
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
	ListNode(int x) { val = x; }
}