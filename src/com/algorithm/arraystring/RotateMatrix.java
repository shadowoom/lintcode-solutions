package com.algorithm.arraystring;

//Question 1.7
public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void rotate(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        //number of layers to rotate
        for(int layer = 0; layer < n/2; layer++){
            //start index of each layer
            int first = layer;
            //end index of each layer
            int last = n - 1 - layer;
            for(int i = first; i < last; i++){
                //get offset
                int offset = i - first;
                //keep top value
                int top = matrix[first][i];
                //rotate left to top
                matrix[first][i] = matrix[last - offset][first];
                //rotate bottom to left
                matrix[last-offset][first] = matrix[last][last-offset];
                //rotate right to bottom
                matrix[last][last-offset] = matrix[i][last];
                //rotate top to right
                matrix[i][last] = top;
            }
        }
    }	 

}
