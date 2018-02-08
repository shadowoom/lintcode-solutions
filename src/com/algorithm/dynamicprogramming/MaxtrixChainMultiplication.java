package com.algorithm.dynamicprogramming;

public class MaxtrixChainMultiplication {
	
	//recursive and inefficient method
//	public static int matrixChainMultiplication(int[] arr){
//		int i = 1;
//		int j = arr.length - 1;
//		return matrixChainMultiplication(arr, i, j);
//	}
//	
//	public static int matrixChainMultiplication(int[] arr, int i, int j){
//		if(i == j)
//			return 0;
//		int min = Integer.MAX_VALUE;
//		for(int k = i; k < j; k++){
//			int computation = matrixChainMultiplication(arr, i, k) 
//							+ matrixChainMultiplication(arr, k+1, j)
//							+ arr[i-1] * arr[k] * arr[j];
//			if(computation < min)
//				min = computation;
//		}
//		return min;
//	}
	
	//dp method
	public static int matrixChainMultiplication(int[] arr){
		int n = arr.length;
		int[][] temp = new int[n][n];
		//initialization
		int l, i, j, k, min;
		
		for(i = 0; i < n; i++){
			temp[i][i] = 0;
		}
		
		for(l = 2; l < n; l++){
			for(i = 1; i <= n - l; i++){
				j = i + l - 1;
				if(j == n) continue;
				temp[i][j] = Integer.MAX_VALUE;
				for(k = i; k < j; k++){
					min = temp[i][k] + temp[k+1][j] + arr[i-1] * arr[k] * arr[j];
					if(min < temp[i][j]) temp[i][j] = min;
				}
			}	
		}
		return temp[1][n-1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(matrixChainMultiplication(new int[]{2,3,6,4,5}));

	}

}
