package com.algorithm.math;

public class TrailingZero {
	
	public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long divider = 5L;
        double result = n / divider;
        long numberOfZero = 0;
        while(result > 1){
            numberOfZero += Math.floor(result);
            result = result / divider;
        }
        return numberOfZero;
    }
	public static void main(String[] args) {
		long n = 400000000000000000L;
		System.out.print(trailingZeros(n));
	}

}
