package com.algorithm.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	GraphNode root;
	GraphNode[] AdjacencyList;
	int size;
	
	public Graph(GraphNode root, int numOfNode) {
		this.root = root;
		this.size = numOfNode;
		AdjacencyList = new GraphNode[numOfNode];
	}
	
	public boolean depthFirstSeach(int val, GraphNode node) {
		if(node == null) {
			return false;
		}
		else {
			if(node.val == val)
				return true;
			else {
				node.visited = true;
				for(GraphNode graphNode : node.neighbors) {
					if(!graphNode.visited)
						return depthFirstSeach(val, graphNode);
				}
				return false;
			}
		}
		
	}
	
	public boolean breadthFirstSearch(int val, GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		if(node == null) {
			return false;
		}
		else {
			if(node.val == val)
				return true;
			else {
				node.visited = true;
				queue.add(node);
				while(!queue.isEmpty()) {
					GraphNode r = queue.remove();
					r.visited = true;
					if(r.val == val)
						return true;
					for(GraphNode graphNode : r.neighbors){
						if(!graphNode.visited) {
							if(graphNode.val == val)
								return true;
							graphNode.visited = true;
							queue.add(graphNode);
						}
					}
				}
				return false;
			}
		}
	}
	
	public static void main(String args[]) {
		GraphNode node1 = new GraphNode(0);
		GraphNode node2 = new GraphNode(1);
		GraphNode node3 = new GraphNode(2);
		GraphNode node4 = new GraphNode(3);
		node1.neighbors.add(node2);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		node3.neighbors.add(node4);
		node4.neighbors.add(node3);
		Graph graph = new Graph(node1, 4);
		graph.AdjacencyList[0] = node1;
		graph.AdjacencyList[1] = node2;
		graph.AdjacencyList[2] = node3;
		graph.AdjacencyList[3] = node4;
		//System.out.println(graph.depthFirstSeach(3, node1));
		System.out.println(graph.breadthFirstSearch(0, node1));
	}
	
}
