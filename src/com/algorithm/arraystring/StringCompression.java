package com.algorithm.arraystring;

//Question 1.6
public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringCompression("aabbabbccccccderggggAAAhGGG"));

	}
	
	public static String stringCompression(String str) {
		StringBuilder newStr = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			int count = 1;
			while(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
				count++;
				i++;
			}
			if(count == 1) {
				newStr.append(str.charAt(i));
			}
			else {
				newStr.append(str.charAt(i));
				newStr.append(count);
			}
		}
		return newStr.toString();
	}

}
