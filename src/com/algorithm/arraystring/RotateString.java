package com.algorithm.arraystring;

import java.util.Arrays;

public class RotateString {
	
//	public void rotateString(char[] str, int offset) {
//        // write your code here
//        int length = str.length;
//        offset = offset % length;
//        char[] newStr = new char[length];
//        for(int i = 0; i < offset; i++){
//            newStr[i] = str[length - offset + i];
//        }
//        int j = 0;
//        for(int i = offset; i < length; i++){
//            newStr[i] = str[j];
//            j++;
//        }
//        for(int i = 0; i < length; i++){
//            str[i] = newStr[i];
//        }
//    }
	
	 public static void rotateString(char[] str, int offset) {
	        // write your code here
	        int length = str.length;
	        offset = offset % length;
	        String newStr = new String(str) + new String(str);
	        int startIndex = length - offset;
	        str = (newStr.substring(startIndex, startIndex + length)).toCharArray();
	        System.out.println("");
	  }
	 

}
