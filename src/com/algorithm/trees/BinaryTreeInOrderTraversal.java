package com.algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {
	
	//recursive approach
	public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> resultList = new ArrayList<Integer>();
        inorderTraversal(root, resultList);
        return resultList;
    }
    
    public void inorderTraversal(TreeNode current, List<Integer> resultList){
        if(current == null) return;
        if(current.left != null) inorderTraversal(current.left, resultList);
        resultList.add(current.val);
        if(current.right != null) inorderTraversal(current.right, resultList);
    }

}
