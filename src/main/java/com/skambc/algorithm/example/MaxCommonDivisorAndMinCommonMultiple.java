package com.skambc.algorithm.example;

import java.util.Scanner;

/*�����Լ������С������*/  
public class MaxCommonDivisorAndMinCommonMultiple {  
  
    public static void main(String[] args) {  
        Scanner scan = new Scanner(System.in);// ���տ���̨�������Ϣ  
  
        System.out.print("�������һ��������");
        int num1 = scan.nextInt(); // ȡ������̨�������Ϣ  
  
        System.out.print("������ڶ���������");  
        int num2 = scan.nextInt(); // ȡ������̨�������Ϣ  
  
        System.out.println(maxCommonDivisor(num1, num2));// ����maxCommonDivisor()����  
        System.out.println(minCommonMultiple(num1, num2));// ����minCommonMultiple()����  
    }  
  
    // �ݹ鷨�����Լ��  
    public static int maxCommonDivisor(int m, int n) {  
        if (m < n) {// ��֤m>n,��m<n,��������ݽ���  
            int temp = m;  
            m = n;  
            n = temp;  
        }  
        if (m % n == 0) {// ������Ϊ0,�������Լ��  
            return n;  
        } else { // ����,���еݹ�,��n����m,����������n  
            return maxCommonDivisor(n, m % n);  
        }  
    }  
  
    // ѭ���������Լ��  
    public static int maxCommonDivisor2(int m, int n) {  
  
        if (m < n) {// ��֤m>n,��m<n,��������ݽ���  
            int temp = m;  
            m = n;  
            n = temp;  
        }  
        while (m % n != 0) {// ����������Ϊ0ʱ,����ѭ��  
            int temp = m % n;  
            m = n;  
            n = temp;  
        }  
        return n;// �������Լ��  
    }  
  
    // ����С������  
    public static int minCommonMultiple(int m, int n) {  
        return m * n / maxCommonDivisor(m, n);  
    }  
} 
