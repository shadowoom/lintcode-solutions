package com.algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
	//recursive approach
		public List<Integer> postOrderTraversal(TreeNode root) {
	        // write your code here
	        List<Integer> resultList = new ArrayList<Integer>();
	        postOrderTraversal(root, resultList);
	        return resultList;
	    }
	    
	    public void postOrderTraversal(TreeNode current, List<Integer> resultList){
	        if(current == null) return;
	        if(current.left != null) postOrderTraversal(current.left, resultList);
	        if(current.right != null) postOrderTraversal(current.right, resultList);
	        resultList.add(current.val);
	    }
}
