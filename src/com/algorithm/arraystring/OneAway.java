package com.algorithm.arraystring;

//Question 1.5

public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oneAway("pales", "palesk"));

	}
	
	public static boolean oneAway(String A, String B) {
		//if difference in length > 1 , return false
		if(Math.abs(A.length() - B.length()) > 1){
			return false;
		}
		//else check character one by one
		else {
			//determine longer and shorter string
			String longString = A.length() > B.length()? A : B;
			String shortString = A.length() > B.length()? B: A;
			if(longString.length() == shortString.length()) {
				return compareEditDifference(longString, shortString);
			}
			else {
				return compareInsertDeleteDifference(longString, shortString);
			}
		}
	}
	
	public static boolean compareEditDifference(String A, String B) {
		boolean foundDifference = false;
		for(int i = 0; i < A.length(); i++) {
			if(A.charAt(i) != B.charAt(i)) {
				if(foundDifference) {
					return false;
				}
				else {
					foundDifference = true;
				}
			}
		}
		return foundDifference;
	}
	
	public static boolean compareInsertDeleteDifference(String A, String B) {
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index1 < A.length() && index2 < B.length()) {
			if(A.charAt(index1) == B.charAt(index2)) {
				index1++;
			}
			else {
				if(foundDifference) {
					return false;
				}
				else {
					foundDifference = true;
				}
			}
			index2++;
		}
		return true;
	}

}
