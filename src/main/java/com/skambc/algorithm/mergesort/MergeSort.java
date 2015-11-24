package com.skambc.algorithm.mergesort;

public class MergeSort {
    public static void merge(int[] sr, int[] tr, int i, int m, int n) {
        int j, k, l;
        for (j = m + 1, k = i; j < n && i <= m; k++) {
            if (sr[i] < sr[j]) {
                tr[k] = sr[i++];
            }
            else {
                tr[k] = sr[j++];
            }
        }
        if (i <= m) {
            for (l = 0; l < m - i + 1; l++) {
                tr[k + l] = sr[i + l];
            }
        }
        if (j < n) {
            for (l = 0; l < n - j; l++) {
                tr[k + l] = sr[j + l];
            }
        }

    }
    public static void mergePass(int[] sr, int[] tr, int s, int n) {
        int i = 0;
        int j;
        while (i <= n - 2 * s) {//利用 i + 2s - 1 <= n-1可以得出,下标从0开始
            merge(sr, tr, i, i + s - 1, i + 2 * s);
            i = i + 2 * s;
        }
        if (i < n - s + 1) {//即最后的两个中，后面那个的长度不够s了
            merge(sr, tr, i, i + s - 1, n);
        }
        else {
            for (j = i; j < n; j++) {
                tr[j] = sr[j];
            }
        }
    }
    public static void mergeSort(int[] array) {
        int[] tr = new int[9];
        int k = 1;
        while (k < tr.length) {
            mergePass(array, tr, k, array.length);
            k = 2 * k;
            mergePass(tr, array, k, array.length);
            k = 2 * k;
        }

    }

    public static void main(String[] args) {
        int[] a = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        int[] b = new int[9];
        mergeSort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
