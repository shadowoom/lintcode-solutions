package com.algorithm.linkedlist;

//Question 2.2

public class RunKthToLast {
	
	public static int counter = 0;
	
	//method 1 - recursion O(N) for both time and space complexity
//	public static Node runKthToLast(Node head, int k) {
//		return findKthNode(head, counter, k);
//	}
//	
//	public static Node findKthNode(Node head, int index, int k) {
//		if(head == null) {
//			return null;
//		}
//		Node node = findKthNode(head.getLink(), index, k);
//		index++;
//		if(index == k + 1) {
//			return head;
//		}
//		return node;
//	}
}
