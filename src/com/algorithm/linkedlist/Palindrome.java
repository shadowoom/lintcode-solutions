package com.algorithm.linkedlist;

import java.util.Stack;

//question 2.6
public class Palindrome {
	//method 1 - reverse and compare
	public static boolean isPalindrome(Node head) {
		if(head == null)
			return false;
		Node reverseHead = reverseList(head);
		return isEqual(head, reverseHead);
	}
	public static Node reverseList(Node head) {
		if(head == null || head.getLink() == null)
			return head;
		Node last = null;
		while(head != null) {
			Node duplicate = new Node(head.getLink(), head.getData());
			duplicate.setLink(last);
			last = duplicate;
			head = head.getLink();
		}
		return last;
	}
	
	public static boolean isEqual(Node head, Node reverseHead) {
		while(head != null && reverseHead != null) {
			if(head.getData() != reverseHead.getData())
				return false;
			head = head.getLink();
			reverseHead = reverseHead.getLink();
		}		
		return head == null && reverseHead == null;
	}
	
	//method 2 - use a stack
	public static boolean isPalindrome1(Node head) {
		Node fast = head;
		Node slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.getLink() != null) {
			stack.push(slow.getData());
			slow = slow.getLink();
			fast = fast.getLink().getLink();
		}
		//take care of odd size, skip the middle item
		if(fast != null) {
			slow = slow.getLink();
		}
		
		while(slow != null) {
			int val = stack.pop();
			if(val != slow.getData())
				return false;
		}
		return true;
	}
	
	//method 3 - convert to string and use recursion
}
