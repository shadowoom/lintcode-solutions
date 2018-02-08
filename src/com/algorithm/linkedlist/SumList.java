package com.algorithm.linkedlist;

import java.util.ArrayList;

//question 2.5
public class SumList {

	public static int carry = 0;
	
	//part 1
	public static Node sumList(Node A, Node B) {
		if(A == null && B == null && carry == 0)
			return null;
		int value = carry;
		Node newNode = new Node(null, 0);
		if(A != null) {
			value += A.getData();
		}
		if(B != null) {
			value += B.getData();
		}
		if(value > 10) {
			carry = 1;
		}
		else {
			carry = 0;
		}
		newNode.setData(value % 10);
		if(A != null || B != null) {
			Node more = sumList(A == null? null : A.getLink(), B == null? null : B.getLink());
			newNode.setLink(more);
		}
		return newNode;
	}
	
	//part 2
	public static Node sumListReverse(Node A, Node B) {
		String value1 = "";
		String value2 = "";
		while(A != null) {
			value1 += String.valueOf(A.getData());
			A = A.getLink();
		}
		while(B != null) {
			value2 += String.valueOf(B.getData());
			B = B.getLink();
		}
		int sum = Integer.valueOf(value1) + Integer.valueOf(value2);
		sum = reverse(sum);
		return setUpList(sum);
	}
	
	public static int reverse(int sum) {
		String sumStr = String.valueOf(sum);
		StringBuilder newStr = new StringBuilder();
		for(int i = sumStr.length() -1 ; i >= 0; i--) {
			newStr.append(sumStr.charAt(i));
		}
		return Integer.valueOf(newStr.toString());
	}
	
	public static Node setUpList(int sum) {
		if(sum < 1)
			return null;
		int value = sum - sum / 10 * 10;
		sum = sum / 10;
		Node newNode = new Node(null, value);
		newNode.setLink(setUpList(sum));
		return  newNode;
	}
	
	public static void main(String [] args) {
		Node node1 = new Node(null, 2);
		Node node2 = new Node(node1, 3);
		Node node3 = new Node(node2, 4);
		Node node4 = new Node(node3, 1);
		Node node5 = new Node(node4, 6);
		Node head = new Node(node5, 2);
		System.out.println(head.getData() +"->" + node5.getData() 
		+"->" + node4.getData() +"->" + node3.getData() +"->" + node2.getData()
		+"->" + node1.getData());
		head = sumListReverse(head, head);
	}
}
