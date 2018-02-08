package com.algorithm.linkedlist;

public class FindCollisionPoint {
	public static Node findCollisionPoint(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(slow == fast)
				break;
		}
		if(fast == null || fast.getLink() == null) {
			return null;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.getLink();
			fast = fast.getLink();
		}
		return fast;
	}
}
