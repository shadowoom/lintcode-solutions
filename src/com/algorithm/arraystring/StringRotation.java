package com.algorithm.arraystring;

public class StringRotation {

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle","erbottlewat"));

	}
	
	public static boolean isRotation(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 != len2 || len1 <= 0 || len2 <= 0)
			return false;
		else {
			StringBuilder newString = new StringBuilder();
			newString.append(s1);
			newString.append(s1);
			String doubleS1 = newString.toString();
			return isSubstring(doubleS1, s2);
		}
	}
	
	public static boolean isSubstring(String s1, String s2) {
		if(s1.contains(s2))
			return true;
		else
			return false;
	}

}
