package com.skambc.algorithm.example;

public class hannuo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        move(4,"A","B","C");

    }
    static  void move(int m,String x,String y,String z){
        if(m==1){
            System.out.println(x+"->"+z);
            return;
        }
        move(m-1,x,z,y);
        System.out.println(x+"->"+z);
        move(m-1,y,x,z);
        
    }

}
