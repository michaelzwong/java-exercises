public class LinkedLists {
	
	// Given are two non-empty linked lists representing two non-negative integers. 
	// The digits are stored in reverse order and each of their nodes contain a single digit. 
	// Adds the two numbers and return it as a linked list.
	// Assume the two numbers do not contain any leading zero, except the number 0 itself.
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
	
}


// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}