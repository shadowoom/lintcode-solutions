package com.algorithm.linkedlist;

import java.util.Scanner;

public class SingleLinkedList {

	private Node start;
	private Node end;
	private int size;
	
	public SingleLinkedList() {
		this.start = null;
		this.end = null;
		this.size =  0;
	}
	
	public boolean checkIsEmpty() {
		return this.start == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void insertAtStart(int val) {
		Node newNode = new Node(null, val);
		size++;
		//initially empty linkedlist
		if(start == null) {
			start = newNode;
			end = start;
		}
		//otherwise
		else {
			newNode.setLink(start);
			start = newNode;
		}
	}
	
	public void insertAtEnd(int val) {
		Node newNode = new Node(null, val);
		size++;
		if(start == null) {
			start = newNode;
			end = start;
		}
		else {
			end.setLink(newNode);
			end = newNode;
		}
	}
	
	public void insertAtSpecifiedPostition (int val, int pos) {
		if(pos < 1 || pos >= size) {
			return;
		}
		else {
			Node newNode = new Node(null, val);
			Node startNode = this.start;
			for(int i = 1; i < pos; i++) {
				Node temp = startNode;
				startNode = temp.getLink();
			}
			newNode.setLink(startNode.getLink());
			startNode.setLink(newNode);
			size++;
		}
	}
	
	public void deleteAtSpecifiedPosition(int pos) {
		if(pos < 0 || pos >= this.size) {
			return;
		}
		else {
			Node startNode = this.start;
			if(pos == 0) {
				Node next = startNode.getLink();
				this.start = next;
				startNode = null;
			}
			else{
				for(int i = 1; i < pos; i++) {
					startNode = startNode.getLink();
				}
				Node deleteNode = startNode.getLink();
				startNode.setLink(deleteNode.getLink());
				deleteNode = null;
			}
			size--;
		}
	}
	
	/*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start);
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        SingleLinkedList list = new SingleLinkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");  
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos < 1 || pos >= list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtSpecifiedPostition(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 0 || p >= list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtSpecifiedPosition(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.checkIsEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                           
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y'); 
        scan.close();
    }
}

