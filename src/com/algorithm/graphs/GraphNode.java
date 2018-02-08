package com.algorithm.graphs;

import java.util.ArrayList;

public class GraphNode {
	int val;
	ArrayList<GraphNode> neighbors;
	boolean visited;
	
	GraphNode(){
		val = 0;
		this.visited = false;
		neighbors = new ArrayList<GraphNode>();
	}
	
	GraphNode(int x) {
		val = x;
		this.visited = false;
		neighbors = new ArrayList<GraphNode>();
	}
 
	GraphNode(int x, ArrayList<GraphNode> n){
		val = x;
		neighbors = n;
		this.visited = false;
	}
 
	public String toString(){
		return "value: "+ this.val; 
	}
}
