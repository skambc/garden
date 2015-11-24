package com.skambc.algorithm.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class bus {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Scanner scanner = new Scanner(new File("bus1.in"));
            Writer writer = new FileWriter("bus.out");
            String meta  = scanner.nextLine();
            int n=Integer.parseInt(meta.split(" ")[0]);
            int m=Integer.parseInt(meta.split(" ")[1]);
            int k=Integer.parseInt(meta.split(" ")[2]);
            int [][] p=new int[n+1][m+1];
            int [][] best=new int[n+1][m+1];
            for (int i = 0; i < k; i++) {
            String s=scanner.nextLine();
            int r=Integer.parseInt(s.split(" ")[0]);
            int h=Integer.parseInt(s.split(" ")[1]);
            int p1=Integer.parseInt(s.split(" ")[2]);
             p[r][h]=p1;
            }
            scanner.close();
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(i==1&&j==1){
                        best[i][j]=p[i][j];
                    }else{
                        best[i][j]=Math.max(best[i-1][j],best[i][j-1])+p[i][j];
                    }
                }
                
            }
            for(int i=0;i<best.length;i++){
                for(int j=0;j<best[i].length;j++){
                    System.out.print(best[i][j]+" ");
                }
                System.out.println();
            }
            writer.write(String.valueOf(best[n][m]));
//            scanner.close();
            writer.close();
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }
    }

}
