package com.algorithm.linkedlist;

import java.util.HashSet;

//Question 2.1
public class RemoveDuplicates {
	
	//method 1 buffer allowed, take up O(N)
//	public static void removeDuplicate(Node startNode) {
//		HashSet<Integer> hash = new HashSet<Integer>();
//		Node previous = null;
//		while(startNode != null) {
//			if(hash.contains(startNode.getData())) {
//				previous.setLink(startNode.getLink());
//			}
//			else {
//				previous = startNode;
//				hash.add(startNode.getData());
//			}
//			startNode = startNode.getLink();
//		}
//	}
	
	//method 2 buffer is not allowed, take up O(N square time)
	public static void removeDuplicate(Node startNode) {
		Node currentNode = startNode;
		while(currentNode != null) {
			Node pointerNode = currentNode;
			while(pointerNode.getLink() != null) {
				if(pointerNode.getLink().getData() == currentNode.getData()) {
					pointerNode.setLink(pointerNode.getLink().getLink());
				}
				else {
					pointerNode = pointerNode.getLink();
				}
			}
			currentNode = currentNode.getLink();
		}
	}
}
