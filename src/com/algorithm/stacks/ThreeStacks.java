package com.algorithm.stacks;

import java.util.NoSuchElementException;

//Question 3.1
public class ThreeStacks {
	private int[][] array = new int[3][];
	private int[] stackCapacity = new int[3];
	private int[] stackSize = new int[3];
	
	public ThreeStacks(int stackCapacity1, int stackCapacity2, int stackCapacity3) {
		stackCapacity[0] = stackCapacity1;
		stackCapacity[1] = stackCapacity2;
		stackCapacity[3] = stackCapacity3;
		array[0] = new int[stackCapacity1];
		array[1] = new int[stackCapacity2];
		array[2] = new int[stackCapacity3];
		stackSize[0] = stackCapacity1;
		stackSize[1] = stackCapacity2;
		stackSize[2] = stackCapacity3;
	}
	
	public boolean isEmpty(int stackNum) {
		return stackSize[stackNum] == 0;
	}
	
	public void push(int stackNum, int item) {
		if(stackSize[stackNum] >= stackCapacity[stackNum]) 
			throw new IndexOutOfBoundsException("Overflow Exception");
		array[stackNum][stackSize[stackNum]] = item;
		stackSize[stackNum]++;
	}
	
	public int pop(int stackNum) {
		if(stackSize[stackNum] == 0)
			throw new NoSuchElementException("Underflow Exception");
		int item = array[stackNum][stackSize[stackNum] - 1];
		array[stackNum][stackSize[stackNum] - 1] = 0;
		stackSize[stackNum]--;
		return item;
	}
	
	public int peek(int stackNum) {
		if(stackSize[stackNum] == 0)
			throw new NoSuchElementException("Underflow Exception");
		return array[stackNum][stackSize[stackNum] - 1];
	}
	
}
