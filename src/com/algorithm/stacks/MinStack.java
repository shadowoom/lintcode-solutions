package com.algorithm.stacks;

import java.util.NoSuchElementException;

public class MinStack {
	int position;
    int trackMin;
    int size;
    int[]arr;
    int[]min;
    
    public MinStack() {
    	// do intialization if necessary
    	this.position = 0;
    	this.trackMin = 0;
    	this.size = 0;
        this.arr = new int[10000];
        this.min = new int[10000];
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if(isEmpty()){
           this.min[this.trackMin++] = number;
           this.arr[this.position++] = number;
           this.size++;
        }
        else{
            if(number <= this.min[this.trackMin-1]){
                this.min[this.trackMin++] = number;
            }
            this.arr[this.position++] = number;
            this.size++;
        }
        
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
    	if(isEmpty()){
            throw new NoSuchElementException("stack underflow");
        }
        int result = this.arr[this.position - 1];
        if(result == this.min[this.trackMin- 1]){
            this.min[this.trackMin- 1] = 0;
            this.trackMin--;
        }
        this.arr[this.position - 1] = 0;
        this.position--;
        size--;
        return result;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
    	if(isEmpty()){
            throw new NoSuchElementException("stack underflow");
        }
        return this.min[this.trackMin- 1];
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public static void main(String args[]) {
    	MinStack ms = new MinStack();
    	ms.push(1);
    	System.out.println(ms.pop());
    	ms.push(2);
    	ms.push(3);
    	System.out.println(ms.min());
    	ms.push(1);
    	System.out.println(ms.min());
    }
}
