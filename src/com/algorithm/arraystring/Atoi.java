package com.algorithm.arraystring;

public class Atoi {
	
	public static int stringToInt(String str){
		//check null and empty
		if(str == null || str.equals("")){
			return 0;
		}
		//check for ending and starting spaces
		String trimmedStr = str.trim();
		double result = 0;
		int count = 0;
		
		//check for front sign
		if(trimmedStr.charAt(0) == '-' || trimmedStr.charAt(0) == '+'){
			for(int i = trimmedStr.length() - 1; i> 0; i--){
				char c = trimmedStr.charAt(i);
				if(c >= 48 && c < 58){
					result += Character.getNumericValue(c) * Math.pow(10, count);
					count++;
				}
				else{
					result = 0;
					count = 0;
				}
			}
			if(trimmedStr.charAt(0) == '-'){
			    result = result * -1;
			}
		}
		else{
			for(int i = trimmedStr.length() - 1; i>= 0; i--){
				char c = trimmedStr.charAt(i);
				if(c >= 48 && c < 58){
					result += Character.getNumericValue(c) * Math.pow(10, count);
					count++;
				}
				else{
					result = 0;
					count = 0;
				}
			}
		}
		
		//check if result out of range
		if(result >= Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(result <= Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int) result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringToInt("-10"));
	}

}
