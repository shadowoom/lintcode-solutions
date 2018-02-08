package com.algorithm.bitmanipulation;

public class APlusBProblem {
	
	public static int aplusb(int a, int b) {
        // write your code here
        String str1 = Integer.toBinaryString(a);
        String str2 = Integer.toBinaryString(b);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int bit = 0;
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        while(i >= 0 && j >= 0){
            if(carry == 0){
            	bit = ((int) str1.charAt(i)) ^ ((int) str2.charAt(j));
               if(str1.charAt(i) == '1' && str2.charAt(j) == '1'){
                    carry = 1;
                }
                else{
                    carry = 0;
                } 
            }
            else{
            	bit = ((int) str1.charAt(i)) ^ ((int) str2.charAt(j)) ^ carry;
                if(str1.charAt(i) == '1' || str2.charAt(j) == '1'){
                    carry = 1;
                }
                else{
                    carry = 0;
                }
            }
            sb.insert(0, String.valueOf(bit));
            i--;
            j--;
        }
        while(j >= 0){
            if(carry == 0){
                sb.insert(0, str2.charAt(j));
            }
            else{
                if(str2.charAt(j) == '1'){
                    carry = 1;
                    sb.insert(0, "0");
                }
                else{
                    carry = 0;
                    sb.insert(0, "1");
                }
            }
            j--;
        }
        while(i >= 0){
            if(carry == 0){
                sb.insert(0, str1.charAt(i));
            }
            else{
                if(str1.charAt(i) == '1'){
                    carry = 1;
                    sb.insert(0, "0");
                }
                else{
                    carry = 0;
                    sb.insert(0, "1");
                }
            }
            i--;
        }
        if(carry == 1){
            sb.insert(0, "1");
        }
        if(sb.toString().length() > 32){
            return Integer.parseInt(sb.toString().substring(1),2);
        }
        else{
            return Integer.parseInt(sb.toString(),2);
        }
        
    }
	
	public static void main(String[] args) {
		int num1 = 1000000000;
		int num2 = 1000000000;
		System.out.println(aplusb(num1, num2));
	}

}
