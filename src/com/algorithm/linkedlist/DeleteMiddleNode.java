package com.algorithm.linkedlist;

//Question 2.3
public class DeleteMiddleNode {
	
	Node Delete(Node head, int position) {
	    // Complete this method
	     //if the list is empty of there is only one node, return null.
	    if(head == null || head.getLink() == null){
	        return null;
	    }
	    //keep track of size of the list
	    int index = 0;
	    Node temp = head;
	    while(temp.getLink() != null){
	        temp = temp.getLink();
	        index++;
	    }
	    if(position > index){
	        return head;
	    }
	    //if position is pointed to the last one, delete last node
	    else if (position == index){
	        temp = head;
	        while(position > 1){
	            temp = temp.getLink();
	            position--;
	        }
	        temp.setLink(null);
	        return head;
	    }
	    else{
	        temp = head;
	        while(position > 0){
	            temp = temp.getLink();
	            position--;
	        }
	        temp.setData(temp.getLink().getData());
	        temp.setLink(temp.getLink().getLink());
	        return head;
	    }
	}
}
