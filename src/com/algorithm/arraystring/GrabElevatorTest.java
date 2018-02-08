package com.algorithm.arraystring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class GrabElevatorTest {

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            q.add(A[i]);
        }
        int count = 0;
        int pointerB = 0;
        while(!q.isEmpty()) {
        	int currentTotalWeight = 0;
        	int currentTotalPeople = 0;
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
        	while(currentTotalWeight < Y && currentTotalPeople < X) {
        		if(q.isEmpty()) {
        			break;
        		}
        		int tempWeight = q.peek();
        		if(currentTotalWeight + tempWeight > Y) {
        			break;
        		}
        		currentTotalWeight += q.remove();
        		currentTotalPeople += 1;
        		if(!tempList.contains(B[pointerB])) {
        			tempList.add(B[pointerB]);
        		}
        		pointerB++;
        	}
        	count += tempList.size() + 1;
        }
        return count;
    }
	
	public static void main(String args[]) {
		int[] A = new int[] {40, 40, 100, 80, 20};
		int[] B = new int[] {3, 3, 3, 3, 3};
		int M = 3;
		int X = 3;
		int Y = 200;
		System.out.println(solution(A,B,M,X,Y));
	}

}
