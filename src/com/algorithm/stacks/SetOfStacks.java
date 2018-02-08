package com.algorithm.stacks;

import java.util.ArrayList;
import java.util.NoSuchElementException;

//Q3.3 Stack of Plates

public class SetOfStacks {
	
	public ArrayList<StackForSetOfStacks> stacks = new ArrayList<StackForSetOfStacks>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	public StackForSetOfStacks getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}
		else {
			return stacks.get(stacks.size()-1);
		}
	}
	
	public boolean isEmpty() {
		StackForSetOfStacks last = this.getLastStack();
		return last==null || last.isEmpty();
	}
	
	public void push(int item) {
		StackForSetOfStacks last = this.getLastStack();
		if(last != null && !last.isFull()) {
			last.push(item);
		}
		else {
			StackForSetOfStacks stack = new StackForSetOfStacks(this.capacity);
			stack.push(item);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		StackForSetOfStacks last = this.getLastStack();
		if(last == null) throw new NoSuchElementException("There is no stack");
		int v = last.pop();
		if(last.isEmpty()) {
			this.stacks.remove(stacks.size() - 1);
		}
		return v;	
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		StackForSetOfStacks stack = this.stacks.get(index);
		int removed_item;
		if(removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBotton();
		if(stack.isEmpty()) {
			stacks.remove(index);
		}
		if(stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
	
}
