package com.algorithm.trees;

//complete tree with smallest root
public class MinHeap {
	
	public int position;
	public int size;
	public int[] minHeap;
	
	public MinHeap(int size) {
		this.size = size;
		this.position = 0;
		this.minHeap = new int[size + 1];
	}
	
	public void display() {
		for(int i = 1; i < this.minHeap.length; i++) {
			System.out.print(" " + this.minHeap[i]);
		}
		System.out.println("");
	}
	
	public void insert(int x) {
		if(this.position == 0) {
			minHeap[this.position + 1] = x;
			this.position = 2;
		}
		else {
			minHeap[position++] = x;
			bubbleup();
		}
	}
	
	public void bubbleup() {
		int pos = this.position - 1;
		while(pos > 0 && this.minHeap[pos] < this.minHeap[pos/2]) {
			swap(pos, pos/2);
			pos = pos / 2;
		}
	}
	
	public void swap(int a, int b) {
		int temp = this.minHeap[a];
		this.minHeap[a] = this.minHeap[b];
		this.minHeap[b] = temp;
	}
	
	public int extractMin() {
		int min = this.minHeap[1];
		this.minHeap[1] = this.minHeap[this.position - 1];
		this.minHeap[this.position - 1] = 0;
		position--;
		sinkDown(1);
		return min;
	}
	
	public void sinkDown(int index) {
		int smallest = index;
		if(2*index < this.position && this.minHeap[smallest] > this.minHeap[2*index]) {
			smallest = 2 * index;
		}
		if(2 * index + 1 < this.position && this.minHeap[smallest] > this.minHeap[2*index + 1]) {
			smallest = 2 * index + 1;
		}
		if(smallest != index) {
			swap(index, smallest);
			sinkDown(smallest);
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
		MinHeap m = new MinHeap(arrA.length);
		System.out.print("\nMin-Heap : ");
		m.createHeap(arrA);		
		m.display();
		System.out.print("Extract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + m.extractMin());
		}
		
	}
	
}
