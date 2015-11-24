package com.skambc.algorithm.example;

public class maopao {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] a={1,3,2,9,4,6,5};
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
            
        }
        for(int a1:a){
            System.out.print(a1);
        }
    }

}
