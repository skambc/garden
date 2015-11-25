package com.skambc.algorithm.garden.algorithm;

import java.util.ArrayList;

public class pingpang {
	String a, b, c;

	public static void main(String[] args) {
		char i, j, k;/* i是a的对手，j是b的对手，k是c的对手 */
		for (i = 'x'; i <= 'z'; i++)
			for (j = 'x'; j <= 'z'; j++) {
				if (i != j)
					for (k = 'x'; k <= 'z'; k++) {
						if (i != k && j != k) {
							if (i != 'x' && k != 'x' && k != 'z')
								System.out.println("A PK " + i + ",B PK " + j
										+ ",C PK" + k);
						}
					}
			}
	}

	public pingpang(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "a的对手是" + a + "," + "b的对手是" + b + "," + "c的对手是" + c + "\n";
	}

}
