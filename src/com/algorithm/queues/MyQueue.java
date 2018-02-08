package com.algorithm.queues;

import java.util.Stack;

//Q3.4

public class MyQueue{
	
	Stack<Integer> stackNew, stackOld;
	
	public MyQueue() {
		stackNew = new Stack<Integer>();
		stackOld = new Stack<Integer>();
	}
	
	public int size() {
		return stackNew.size() + stackOld.size();
	}
	
	public void push(int value) {
		stackNew.push(value);
	}
	
	public void shiftStacks() {
		if(stackOld.isEmpty()) {
			while(!stackNew.isEmpty()) {
				stackOld.push(stackNew.pop());
			}
		}
	}
	
	public int pop() {
		shiftStacks();
		return stackOld.pop();
	}
	
	public int peek() {
		shiftStacks();
		return stackOld.peek();
	}
	
}
