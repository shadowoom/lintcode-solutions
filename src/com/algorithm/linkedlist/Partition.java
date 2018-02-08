package com.algorithm.linkedlist;

import java.util.ArrayList;

//question 2.4
public class Partition {
	
	public static void main(String[]args) {
		Node node1 = new Node(null, 2);
		Node node2 = new Node(node1, 3);
		Node node3 = new Node(node2, 4);
		Node node4 = new Node(node3, 1);
		Node node5 = new Node(node4, 6);
		Node head = new Node(node5, 2);
		System.out.println(head.getData() +"->" + node5.getData() 
		+"->" + node4.getData() +"->" + node3.getData() +"->" + node2.getData()
		+"->" + node1.getData());
		partition(head, 3);
		System.out.println(head.getData() +"->" + node5.getData() 
		+"->" + node4.getData() +"->" + node3.getData() +"->" + node2.getData()
		+"->" + node1.getData());
	}
	//method 1
	public static void partition(Node head, int x) {
      if(head == null || head.getLink() == null) {
			return;
		}
        Node temp = head;
		ArrayList<Integer> smallList = new ArrayList<Integer>();
		ArrayList<Integer> bigList = new ArrayList<Integer>();
		while(temp != null) {
			if(temp.getData() < x)
				smallList.add(temp.getData());
			else
				bigList.add(temp.getData());
			temp = temp.getLink();
		}
		temp = head;
		for(int i = 0; i < smallList.size(); i++) {
			temp.setData(smallList.get(i));
			temp = temp.getLink();
		}
		for(int i  = 0; i < bigList.size(); i++) {
			temp.setData(bigList.get(i));
			temp = temp.getLink();
		}
    }	   
}
