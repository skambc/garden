package com.skambc.algorithm.example;

public class BubbleSort {
    public static void main(String[] args) {
        int score[] = { 67, 69, 75, 87, 89, 90, 99, 100 };
        for (int i = 0; i < score.length - 1; i++) { //�����n-1������
            for (int j = 0; j < score.length - i - 1; j++) { //�Ե�ǰ��������score[0......length-i-1]��������(j�ķ�Χ�ܹؼ��������Χ��������С��)
                if (score[j] < score[j + 1]) { //��С��ֵ����������
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
            System.out.print("��" + (i + 1) + "����������");
            for (int a = 0; a < score.length; a++) {
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }
        System.out.print("������������");
        for (int a = 0; a < score.length; a++) {
            System.out.print(score[a] + "\t");
        }
    }
}