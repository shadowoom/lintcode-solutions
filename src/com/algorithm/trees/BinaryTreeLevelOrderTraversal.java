package com.algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> subQueue = new LinkedList<TreeNode>();
        List<List<Integer>> resultList = new ArrayList<>();
        tempQueue.add(root);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while(!tempQueue.isEmpty()){
            TreeNode tempNode = tempQueue.remove();
            tempList.add(tempNode.val);
            if(tempNode.left != null){
                subQueue.add(tempNode.left);
            }
            if(tempNode.right != null){
                subQueue.add(tempNode.right);
            }
            if(tempQueue.isEmpty()){
                resultList.add(tempList);
                tempList = new ArrayList<Integer>();
                tempQueue = subQueue;
                subQueue = new LinkedList<TreeNode>();
            }
        }
        return resultList;
    }
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		levelOrder(root);
	}
	
}
