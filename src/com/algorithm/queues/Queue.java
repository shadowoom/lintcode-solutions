package com.algorithm.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue implements Iterable<Integer> {
	
	private int n; //size of queue
	private Node first; // start of queue
	private Node last; //end of queue
	
	// helper linked list class
	private static class Node {
		private int item;
	    private Node next;
	}
	
	public Queue() {
		 first = null;
		 last = null;
	     n = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return n;
	}
	
	public void add(int item) {
		Node newNode = new Node();
		//keep track of the end of the queue
		if(last != null) {
			last.next = newNode;
		}
		last = newNode;
		//keep track of the start of the queue
		if(first == null) {
			first = last;
		}
		n++;
	}
	
	public int remove() {
		if (first == null) throw new NoSuchElementException("Queue Empty.");
		int item = first.item;
		first = first.next;
		if(first == null) {
			last = null;
		}
		n--;
		return item;
	}
	
	public int peek() {
		if (first == null) throw new NoSuchElementException("Queue Empty.");
		int item = first.item;
		return item;
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (int item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
	
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
