package com.algorithm.arraystring;

import java.util.Arrays;

public class PlusOne {

	public static int[] plusOne(int[] digits) {
        // write your code here
		if(digits.length == 0)
			return new int[]{};
		int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            if(sum >= 10)
            	carry = 1;
            else
            	carry = 0;
            digits[i] = sum % 10;
        }
        if(carry == 1){
        	int[] newArr = new int[digits.length+1];
//        	for(int i = 1; i < newArr.length; i++){
//        		newArr[i] = digits[i-1];
//        	}
        	System.arraycopy(digits, 0, newArr, 1, digits.length);
        	newArr[0] = 1;
        	return newArr;
        }
        else{
        	return digits;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(plusOne(new int[]{9}).toString());
	}

}
