package com.skambc.algorithm.example;

import java.util.ArrayList;
import java.util.List;

public class beibao {
    public static void main(String[] args) {
        int c[] = { 0,7, 8, 5};
        int v[] = { 0,4, 7, 6 };
        int[][] f = new int[4][11];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 || j == 0) {    
                    f[i][j] = 0;    
                } else{
                    if (c[i] > j) {
                        f[i][j] = f[i - 1][j];
                    }
                    else {
                        f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - c[i]] + v[i]);
                    }
                }
                
            }
        }
        for(int i=0;i<f.length;i++){
            for(int j=0;j<f[i].length;j++){
                System.out.print(f[i][j]+" ");
            }
            System.out.println();
        }
        List<Integer> best=new ArrayList<Integer>(); 
        int temp=10;
        for(int i=3;i>0;i--){
            if(f[i][temp]>f[i-1][temp]){
                best.add(c[i]);
                temp=temp-c[i];
                if (temp == 0) { break; }    
            }
        }
        for(Integer a:best){
            System.out.println(a);
        }
    }

}
