package com.algorithm.stacks;

import java.util.NoSuchElementException;
import java.util.Stack;

//Question 3.2
public class StackMin extends Stack<Integer>{
	Stack<Integer> s;
	
	public StackMin() {
		s = new Stack<Integer>();
	}
	
	public int min() {
		if(s.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return s.peek();
		}
	}
	
	public void push(int item) {
		if(item < this.min()) {
			s.push(item);
		}
		super.push(item);
	}
	
	public Integer pop() {
		if(super.isEmpty())
			throw new NoSuchElementException("stack underflow");
		Integer item = super.pop();
		if(item.intValue() == this.min()) {
			s.pop();
		}
		return item;
	}
	
}
