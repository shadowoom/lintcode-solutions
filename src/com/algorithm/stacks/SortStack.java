package com.algorithm.stacks;

//Q3.5

public class SortStack {
	
	public void sort(java.util.Stack<Integer> s) {
		java.util.Stack<Integer> r = new java.util.Stack<Integer>();
		while(!s.isEmpty()) {
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		
		//copy back
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
	}
}
