package com.skambc.algorithm.garden.algorithm;

/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
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
