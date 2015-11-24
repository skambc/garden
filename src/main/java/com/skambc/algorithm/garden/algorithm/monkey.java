package com.skambc.algorithm.garden.algorithm;

public class monkey {
	public static void main(String[] args) {
		int total = 1;
		for (int i = 10; i > 1; i--) {
			total = total * 2 + 2;
		}
		System.out.println(total);
		System.out.println(total(1));
	}

	static int total(int day) {
		if (day == 10) {
			return 1;
		} else {
			return (total(day + 1) + 1) * 2;
		}
	}

}
