package com.algorithm.arraystring;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharater {
	
		//sliding windonw
//	 public int lengthOfLongestSubstring(String s) {
//		// write your code here
//		 int i = 0;
//	        int j = 0;
//	        int max = 0;
//	        HashSet<Character> set = new HashSet<Character>();
//	        while(i < s.length() && j < s.length()){
//	            if(!set.contains(s.charAt(j))){
//	                set.add(s.charAt(j));
//	                j++;
//	                max = Math.max(max, j - i);
//	            }
//	            else{
//	            		set.remove(s.charAt(i));
//	                    i++;
//	                }
//	        }
//	        return max;	        
//	}
	
	//sliding windonw2
	public static int lengthOfLongestSubstring(String s) {
		// write your code here
	    int max = 0;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i = 0, j = 0; j < s.length(); j++) {
	    	if(map.containsKey(s.charAt(j))) {
	    		i = Math.max(map.get(s.charAt(j)) + 1, i);
	    	}
	    	map.put(s.charAt(j), j);
    		max = Math.max(max, j - i + 1);
	    }
	    return max;	        
	}
	
	public static void main(String args[]) {
		System.out.println(lengthOfLongestSubstring("dqirnnnchguccmkluloyzunslxhgxjyazitnxgreplhrzreuessdofxacgicpgcpqyengvrvjamitscxk"));
	}
	
}
