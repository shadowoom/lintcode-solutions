package com.algorithm.linkedlist;

public class Node {
	
	private int data;
	private Node link;
	
	public Node(Node node, int data) {
		this.link = node;
		this.data = data;
	}
	
	public Node getLink () {
		return this.link;
	}
	
	public void setLink (Node node) {
		this.link = node;
	}
	
	public void setData (int data) {
		this.data = data;
	}
	
	public int getData () {
		return this.data;
	}
}
