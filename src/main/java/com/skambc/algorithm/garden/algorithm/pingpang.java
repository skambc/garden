package com.skambc.algorithm.garden.algorithm;

import java.util.ArrayList;

public class pingpang {
	String a, b, c;

	public static void main(String[] args) {
		char i, j, k;/* i��a�Ķ��֣�j��b�Ķ��֣�k��c�Ķ��� */
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
		return "a�Ķ�����" + a + "," + "b�Ķ�����" + b + "," + "c�Ķ�����" + c + "\n";
	}

}
