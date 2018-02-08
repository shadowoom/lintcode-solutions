package com.algorithm.bitmanipulation;

public class Test {

	static int clearBitsMSBthroughI(int num, int i) {
		int mask = (-1<<(i + 1));
		return num & mask;
	}
	
	public static void main(String[] args) {
		int num = 1000000000;
		int num1 = 100;
		//String str = Integer.toBinaryString(num);
		//int num2 = Integer.parseInt(str);
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(num1));
		//System.out.println(Integer.toBinaryString(clearBitsMSBthroughI(num, 3)));
		
		//reverse string
//		StringBuffer sb = new StringBuffer("this is javatpoint");
//		String s = sb.reverse().toString();
//		System.out.println(s);
		

	}

}
