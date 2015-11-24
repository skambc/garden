package com.skambc.algorithm.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class matrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("matrix9.in"));
            Writer writer = new FileWriter("matrix.out");
            String meta  = scanner.nextLine();
            int r=Integer.parseInt(meta.split(" ")[0]);
            int c=Integer.parseInt(meta.split(" ")[1]);
            int [][] p=new int[r+1][c+1];
            int [][] best=new int[r+1][c+1];
            for (int i = 0; i < r; i++) {
            String row=scanner.nextLine();
            String [] arr=row.split(" ");
            for(int j=0;j<arr.length;j++){
                p[i+1][j+1]=Integer.parseInt(arr[j]);
            }
            }
            scanner.close();
            int max=0;
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    if(i==1&&j==1){
                        best[i][j]=p[i][j];
                    }else{
                        if(p[i][j]==0){
                            best[i][j]=0;
                        }else{
                            best[i][j]=Math.min(Math.min(best[i-1][j],best[i][j-1]), best[i-1][j-1])+1; 
                        }
                       
                    }
                    if(best[i][j]>max){
                        max=best[i][j];
                    }
                }
                
            }
            for(int i=0;i<best.length;i++){
                for(int j=0;j<best[i].length;j++){
                    System.out.print(best[i][j]+" ");
                }
                System.out.println();
            }
            writer.write(String.valueOf(max*max));
//            scanner.close();
            writer.close();
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }

    }

}
