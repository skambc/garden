package com.skambc.algorithm.example;

public class MaxSubString {
    public static void main(String[] args) {
        int[] a = {0, -2, 3, 5, -1, 2};
        int start=a[0];
        int max=a[0];
        for(int i=1;i<a.length;i++){
            start=Math.max(a[i], a[i]+start);
            max=Math.max(max, start);
        }
        System.out.println(max);
    }
}
