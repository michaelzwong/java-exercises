public class LinkedLists {
	
	// Given are two non-empty linked lists representing two non-negative integers. 
	// The digits are stored in reverse order and each of their nodes contain a single digit. 
	// Adds the two numbers and return it as a linked list.
	// Assume the two numbers do not contain any leading zero, except the number 0 itself.
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	    // number to carry over in addition
	    int carry = 0;
	    
	    int sum = l1.val + l2.val;
	    
	    
	    // First Node
	    ListNode firstNode;
	    ListNode nextNode;
	    
	    if(sum >= 10) {
	        firstNode = new ListNode(sum - 10);
	        carry = 1;
	    } else {
	        firstNode = new ListNode(sum);
	    }
	    
	    nextNode = firstNode;
	    
	
	    l1 = l1.next;
	    l2 = l2.next;
	    
	    while(l1 != null || l2 != null) {
	        sum = l1.val + l2.val + carry;
	        if(sum >= 10) {
	            nextNode.next = new ListNode(sum - 10);
	            carry = 1;
	        } else {
	            nextNode.next = new ListNode(sum);
	            carry = 0;
	        }
	        nextNode = nextNode.next;
	        l1 = l1.next;
	        l2 = l2.next;
	    
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