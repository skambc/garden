package com.skambc.algorithm.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(new File("b.in"));
            Writer writer = new FileWriter("b.out");
            
            int num = scanner.nextInt();
            int[] len = new int[num];
            for (int i = 0; i < num; i++) {
                len[i] = scanner.nextInt();
            }
            Arrays.sort(len);

            int line1 = 0;
            if (num > 1) {
                 line1 = cal(len[0], len[1]);
                for (int j = 2; j < len.length; j++) {

                    line1 = cal(line1, len[j]);
                }
            }else{
                line1 = len[0];
            }
            
            int line2 = 0;
            for (int j = 0; j < len.length; j++) {

                line2 += len[j]/line1;
            }
            writer.write(String.valueOf(line1)+"\n");
            writer.write(String.valueOf(line2)+"\n");
            scanner.close();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int cal(int m, int n) {
        int temp = 0;
        if (n % m == 0) {
            temp = m;
        } else {
            while (n % m != 0) {
                temp = n % m;
                n = m;
                m = temp;
            }
        }
        return temp;
    }
}