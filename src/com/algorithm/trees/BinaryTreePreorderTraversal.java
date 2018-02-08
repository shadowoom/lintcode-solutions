package com.algorithm.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	//recursion method
	public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> resultList = new ArrayList<Integer>();
        preorderTraversal(root, resultList);
        return resultList;
    }
    
    public void preorderTraversal(TreeNode current, List<Integer> resultList) {
        if(current == null) return;
        resultList.add(current.val);
        if(current.left != null) preorderTraversal(current.left, resultList);
        if(current.right != null) preorderTraversal(current.right, resultList);
    }
    
    //non - recursive method
    public List<Integer> preorderTraversal1(TreeNode root) {
        // write your code here
        if(root == null) return new ArrayList<Integer>();
        Stack<TreeNode> tempStack = new Stack<TreeNode>();
        List<Integer> resultList = new ArrayList<Integer>();
        tempStack.push(root);
        resultList.add(root.val);
        while(!tempStack.isEmpty()){
            TreeNode tempNode = tempStack.peek();
            if(tempNode.left != null){
                tempStack.push(tempNode.left);
                resultList.add(tempNode.left.val);
                tempNode.left = null;
            }
            else{
                if(tempNode.right != null){
                    tempStack.push(tempNode.right);
                    resultList.add(tempNode.right.val);
                    tempNode.right = null;
                }
                else{
                	tempStack.pop();
                }
            }
        }
        return resultList;
    }

}
