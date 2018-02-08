package com.algorithm.stacks;

import java.util.NoSuchElementException;

//Q3.3 Stack of Plates
public class StackForSetOfStacks {
	private int capacity;
	public Node top, bottom;
	public int size = 0;
	
	 // helper linked list class
	 private static class Node {
		 private int value;
	     private Node above;
	     private Node below;
	     public Node(int value){
	    	 this.value = value;
	     }
	 }
	 
	 public StackForSetOfStacks(int capacity) {
		 this.capacity = capacity;
	 }
	 
	 public boolean isFull() {
		 return capacity == size;
	 }
	 
	 public boolean isEmpty() {
		 return size == 0;
	 }
	 
	 public void join(Node above, Node below) {
		 if(below != null) below.above = above;
		 if(above != null) above.below = below;
	 }
	 
	 public boolean push(int v) {
		 if(this.size >= this.capacity) return false;
		 size++;
		 Node n = new Node(v);
		 if(size == 1) this.bottom = n;
		 join(n, top);
		 top = n;
		 return true;
	 }
	 
	 public int pop() {
		 if(this.isEmpty()) throw new NoSuchElementException("stack underflow");
		 Node t = top;
		 top = top.below;
		 size--;
		 return t.value;
	 }
	 
	 public int removeBotton() {
		 if(bottom == null) throw new NoSuchElementException("stack underflow");
		 Node b = bottom;
		 bottom = bottom.above;
		 if(bottom != null) bottom.below = null;
		 size--;
		 return b.value;
	 }
	 
}
