package com.skambc.algorithm.garden.algorithm;

/**
 * ��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ������ĸ��º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ���������Ϊ���٣�
 * 1.��������� ���ӵĹ���Ϊ����1,1,2,3,5,8,13,21....
 * 
 * @author jinhd
 * 
 */
public class Rabbit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sum(6));

	}

	public static int sum(int day) {
		int sum = 0;
		if (day == 1 || day == 2) {
			return 1;
		} else {
			sum = sum(day - 1) + sum(day - 2);
			return sum;
		}
	}

}
