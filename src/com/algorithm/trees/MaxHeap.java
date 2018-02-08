package com.algorithm.trees;

//complete tree with maximum root
public class MaxHeap {

	public int position;
	public int size;
	public int[] maxHeap;
	
	public MaxHeap(int size) {
		this.size = size;
		this.position = 0;
		this.maxHeap = new int[size + 1];
	}
	
	public void display() {
		for(int i = 1; i < this.maxHeap.length; i++) {
			System.out.print(" " + this.maxHeap[i]);
		}
		System.out.println("");
	}
	
	public void insert(int x) {
		if(this.position == 0) {
			maxHeap[this.position + 1] = x;
			this.position = 2;
		}
		else {
			maxHeap[position++] = x;
			bubbleup();
		}
	}
	
	public void bubbleup() {
		int pos = this.position - 1;
		while(pos > 0 && this.maxHeap[pos] > this.maxHeap[pos/2]) {
			swap(pos, pos/2);
			pos = pos / 2;
		}
	}
	
	public void swap(int a, int b) {
		int temp = this.maxHeap[a];
		this.maxHeap[a] = this.maxHeap[b];
		this.maxHeap[b] = temp;
	}
	
	public int extractMax() {
		int max = this.maxHeap[1];
		this.maxHeap[1] = this.maxHeap[this.position - 1];
		this.maxHeap[this.position - 1] = 0;
		position--;
		sinkDown(1);
		return max;
	}
	
	public void sinkDown(int index) {
		int largest = index;
		if(2*index < this.position && this.maxHeap[largest] < this.maxHeap[2*index]) {
			largest = 2 * index;
		}
		if(2 * index + 1 < this.position && this.maxHeap[largest] < this.maxHeap[2*index + 1]) {
			largest = 2 * index + 1;
		}
		if(largest != index) {
			swap(index, largest);
			sinkDown(largest);
		}
	}
	
	public void createHeap(int [] arrA){
		if(arrA.length>0){
			for(int i=0;i<arrA.length;i++){
				insert(arrA[i]);
			}
		}		
	}
	
	public static void main(String args[]){
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		System.out.print("Original Array : ");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
		}
		MaxHeap m = new MaxHeap(arrA.length);
		System.out.print("\nMax-Heap : ");
		m.createHeap(arrA);		
		m.display();
		System.out.print("Extract max :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + m.extractMax());
		}
		
	}
}
