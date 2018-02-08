package com.algorithm.linkedlist;

//question 2.7
public class Intersection {
	public static Node getIntersection(Node A, Node B) {
		if(A == null || B == null)
			return null;
		//find out last node and the size of the list
		Result resultA = IterateThroughWholeList(A);
		Result resultB = IterateThroughWholeList(B);
		//if last node not same, return null
		if(resultA.listNode != resultB.listNode)
			return null;
		if(resultA.size > resultB.size) {
			int diff = resultA.size - resultB.size;
			return findIntersectionPoint(A, B, diff);
		}
		else if(resultA.size == resultB.size) {
			int diff = 0;
			return findIntersectionPoint(A, B, diff);
		}
		else {
			int diff = resultB.size - resultA.size;
			return findIntersectionPoint(B, A, diff);
		}
	}
	
	public static Result IterateThroughWholeList(Node node) {
		if(node == null)
			return null;
		int size = 0;
		while(node != null) {
			node = node.getLink();
			size++;
		}
		return new Result(node, size);
	}
	
	public static Node findIntersectionPoint(Node longNode, Node shortNode, int diff) {
		for(int i = 0; i < diff; i++) {
			longNode = longNode.getLink();
		}
		while(shortNode != longNode) {
			shortNode = shortNode.getLink();
			longNode = longNode.getLink();
		}
		return longNode;
	}
	
	public static class Result{
		public Node listNode;
		public int size;
		public Result(Node listNode, int size) {
			this.listNode = listNode;
			this.size = size;
		}
	}
	
	public static void main(String [] args) {
		Node node12 = new Node(null, 13);
		Node node11 = new Node(node12, 12);
		Node node10 = new Node(node11, 11);
		Node node9 = new Node(node10, 10);
		Node node8 = new Node(node9, 9);
		Node node7 = new Node(node8, 8);
		Node node6 = new Node(node7, 7);
		Node node5 = new Node(node6, 6);
		Node node4 = new Node(node5, 5);
		Node node3 = new Node(node4, 4);
		Node node2 = new Node(node3, 3);
		Node node1 = new Node(node2, 2);
		Node head = new Node(node1, 1);
		Node newNode = getIntersection(head, node5);
	}
}
