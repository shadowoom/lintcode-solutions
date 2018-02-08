package com.algorithm.arraystring;

//Question 1.8
public class ZeroMatrix {
	
	//method 1
//	public static void zeroMatrix(int[][] matrix) {
//		boolean[] row =  new boolean[matrix.length];
//		boolean[] column = new boolean[matrix[0].length];
//		for(int i = 0; i < matrix.length; i++) {
//			for(int j = 0; j < matrix[0].length; j++) {
//				if(matrix[i][j] == 0) {
//					row[i] = true;
//					column[j] = true;
//				}
//			}
//		}
//		
//		for(int i = 0; i < row.length; i++) {
//			if(row[i]) {
//				for(int j = 0; j < matrix[0].length; j++) {
//					matrix[i][j] = 0;
//				}
//			}
//		}
//		
//		for(int i = 0; i < column.length; i++) {
//			if(column[i]) {
//				for(int j = 0; j < matrix.length; j++) {
//					matrix[j][i]  = 0;
//				}
//			}
//		}
//	}
	
	//method 2
	public static void zeroMatrix(int[][] matrix) {
		boolean trackFirstColumn = false;
		boolean trackFirstRow = false;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				trackFirstColumn = true;
				break;
			}
		}
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				trackFirstRow = true;
				break;
			}
		}
		
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j <matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				for(int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		
		for(int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(trackFirstRow) {
			for(int i  = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		
		if(trackFirstColumn) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
