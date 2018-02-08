package com.algorithm.dynamicprogramming;

public class KnackSnapOneZero {
	
	public static String backPackII(int m, int[] A, int[] V) {
        // write your code here
        int max = 0;
        int [][] temp = new int[A.length+1][m+1];
        int[] tracker = new int[2];
        for(int i = 0; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                if(i==0 || j == 0){
                    temp[i][j] = 0;
                    continue;
                }
                if(A[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = Math.max(temp[i-1][j], V[i-1] + temp[i-1][j-(A[i-1])]);
                    max = Math.max(temp[i][j], max);
                    tracker[0] = i;
                    tracker[1] = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(temp[tracker[0]][tracker[1]] > 0){
        	if(temp[tracker[0]][tracker[1]] > temp[tracker[0]-1][tracker[1]]){
        		sb.insert(0, " " + A[tracker[0] - 1]);
        		tracker[1] = tracker[1] - A[tracker[0] - 1];
        		tracker[0] = tracker[0] - 1;
        	}
        	else{
        		tracker[0] = tracker[0] - 1;
        	}
        }
        return sb.toString();
    }
	
	public static void main(String args[]){
		System.out.println(backPackII(10, new int[]{2,3,5,7}, new int[]{1,5,2,4}));
	}

}
