package com.skambc.algorithm.garden.algorithm;

public class Prime {

	/**
	 * 
	 * 题目：判断101-200之间有多少个素数，并输出所有素数。 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
	 * 则表明此数不是素数，反之是素数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 3; i < 10; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
