package com.skambc.algorithm.example;

public class noname {
    public static void main(String[] args) {
        int s = 1;
        int n = 4;
        int t = 6;
        int[][] arr = new int[6][6];
        //System.out.println(arr[6].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                arr[i][j] = s++;
                if (s > n)
                    s = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //ѭ�����������е�ÿ��Ԫ��
                //��ʼ����������
                if (arr[j][i] != 0) {
                    System.out.print(arr[j][i] + " ");
                }

                //�������е�Ԫ�����
            }
            System.out.println();
            //����ո�
        }
    }

}
