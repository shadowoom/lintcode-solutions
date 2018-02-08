package com.algorithm.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackUseLinkedList implements Iterable<Integer> {
	
	 private int n;          // size of the stack
	 private Node first;     // top of stack

	 // helper linked list class
	 private static class Node {
		 private int item;
	     private Node next;
	 }
	 /**
	  * Initializes an empty stack.
	  */
	 public StackUseLinkedList() {
	     first = null;
	     n = 0;
	 }
	   

	 /**
	  * Returns true if this stack is empty.
	  *
	  * @return true if this stack is empty; false otherwise
	  */
	 public boolean isEmpty() {
	     return first == null;
	 }	    

	 /**
	  * Returns the number of items in this stack.
	  *
	  * @return the number of items in this stack
	  */
	 public int size() {
	     return n;
	 }

	    /**
	     * Adds the item to this stack.
	     *
	     * @param  item the item to add
	     */
	    public void push(int item) {
	        Node oldfirst = first;
	        first = new Node();
	        first.item = item;
	        first.next = oldfirst;
	        n++;
	    }

	    /**
	     * Removes and returns the item most recently added to this stack.
	     *
	     * @return the item most recently added
	     * @throws NoSuchElementException if this stack is empty
	     */
	    public int pop() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        int item = first.item;        // save item to return
	        first = first.next;            // delete first node
	        n--;
	        return item;                   // return the saved item
	    }


	    /**
	     * Returns (but does not remove) the item most recently added to this stack.
	     *
	     * @return the item most recently added to this stack
	     * @throws NoSuchElementException if this stack is empty
	     */
	    public int peek() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        return first.item;
	    }

	    /**
	     * Returns a string representation of this stack.
	     *
	     * @return the sequence of items in this stack in LIFO order, separated by spaces
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        for (int item : this) {
	            s.append(item);
	            s.append(' ');
	        }
	        return s.toString();
	    }
	       

	    /**
	     * Returns an iterator to this stack that iterates through the items in LIFO order.
	     *
	     * @return an iterator to this stack that iterates through the items in LIFO order
	     */
	    public Iterator<Integer> iterator()  { 
	    	return new ListIterator();  
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator implements Iterator<Integer> {
	        private Node current = first;
	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Integer next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            int item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
}
