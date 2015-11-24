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
                //循环遍历数组中的每个元素
                //初始化数组内容
                if (arr[j][i] != 0) {
                    System.out.print(arr[j][i] + " ");
                }

                //将数组中的元素输出
            }
            System.out.println();
            //输出空格
        }
    }

}
