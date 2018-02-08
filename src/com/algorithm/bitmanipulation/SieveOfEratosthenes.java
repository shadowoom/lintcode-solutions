package com.algorithm.bitmanipulation;

public class SieveOfEratosthenes {

	
	public static boolean[] sieveOfEratosthenes(int max) {
		//initialization
		boolean[] primeNumbers = new boolean[max+1];
		int prime = 3;
		//set all to be true except, 0, 1 and even numbers
		init(primeNumbers);
		
		while(prime < Math.ceil(Math.sqrt(max))) {
			//cross off other multiple of prime number
			crossOff(primeNumbers, prime);
			//get next available prime number
			prime = getNextPrimeNumber(primeNumbers, prime);
		}
		return primeNumbers;
	}
	
	public static void init(boolean[] primeNumbers) {
		for(int i = 0; i < primeNumbers.length; i++) {
			if(i != 0 && i != 1 && (i % 2 == 1 || i == 2)) {
				primeNumbers[i] = true;
			}
		}
	}
	
	public static void crossOff(boolean[] primeNumbers, int prime) {
		for(int i = prime * prime; i < primeNumbers.length; i+= 2 * prime) {
			primeNumbers[i] = false;
		}
	}
	
	public static int getNextPrimeNumber(boolean[] primeNumbers, int prime) {
		prime = prime + 1;
		while(prime < primeNumbers.length) {
			if(primeNumbers[prime]) {
				return prime;
			}
			prime++;
		}
		return primeNumbers.length;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < sieveOfEratosthenes(20).length; i++)
			System.out.println(sieveOfEratosthenes(20)[i]);
	}

}
