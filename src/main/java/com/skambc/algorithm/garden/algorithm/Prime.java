package com.skambc.algorithm.garden.algorithm;

public class Prime {

	/**
	 * 
	 * ��Ŀ���ж�101-200֮���ж��ٸ���������������������� 1.����������ж������ķ�������һ�����ֱ�ȥ��2��sqrt(�����)������ܱ�������
	 * ���������������������֮������
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
