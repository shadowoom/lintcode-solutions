package com.algorithm.enumeration;

public class DigitCounts {
	
	// O(n*l)
	
	public static int digitCounts(int k, int n) {
        // write your code here
        String[] tempList = new String[n+1];
        for(int i = 0; i <= n; i++){
            tempList[i] = String.valueOf(i);
        }
        int countK = 0;
        for(int i = 0; i < tempList.length; i++){
            countK += getCount(tempList[i], k);
        }
        return countK;
    }
    
    public static int getCount(String str, int k){
        int count = 0; 
        if(str.contains(String.valueOf(k))){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == (char) (k + '0'))
                    count++;
            }
            
        }
        return count;
    }
    
    public static void main(String args[]) {
    	System.out.println(digitCounts(1, 1));
    }
}
