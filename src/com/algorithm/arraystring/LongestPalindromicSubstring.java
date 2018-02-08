package com.algorithm.arraystring;

public class LongestPalindromicSubstring {
	
		//dynamic programming
		public static String lps(String str){
			if(str == null || str.length() <= 1){
				return str;
			}
			int len = str.length();
			int max = 1;
			String longest = null;
			boolean[][]temp = new boolean[len][len];
			for(int l = 0; l < len; l++){
				for(int i = 0; i < len - l; i++){
					int j = i + l;
					if(str.charAt(i) == str.charAt(j) && (j - i <= 2 || temp[i+1][j-1])){
						temp[i][j] = true;
						if(j-i+1 > max){
							max = j - i + 1;
							longest = str.substring(i, j+1);
						}
					}
				}
			}
			return longest;
		}
		
		//expand from the center
		public static String lps1(String s){
			if(s == null || s.length() <= 1){
				return s;
			}
			String longest = s.substring(0, 1);
			for(int i = 0; i < s.length(); i++){
				//expand from center i
				String temp = expandFromCenter(s, i, i);
				if(temp.length() > longest.length()){
					longest = temp;
				}
				//expand from center i+1
				temp = expandFromCenter(s, i, i+1);
				if(temp.length() > longest.length()){
					longest = temp;
				}
			}
			return longest;
		}
		
		public static String expandFromCenter(String s, int left, int right){
			while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}
			return s.substring(left+1, right);
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println(lps("abcdzdcab"));
			System.out.println(lps1("abcdzdcab"));
		}


}
