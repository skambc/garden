package com.skambc.algorithm.shellsort;

public class ShellSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int [] array={9,1,5,8,3,7,4,6,2};
        int [] s=shellSort(array);
        for(int a:s){
            System.out.println(a);
        }
    }
    public static int [] shellSort(int [] array){
        int i,j;
        int increment=array.length;
        int temp;
        do{
            increment=increment/3+1;
            for(i=increment;i<array.length;i++){
                if(array[i]<array[i-increment]){
                    temp=array[i];
                    for(j=i-increment;j>=0&&temp<array[j];j-=increment){
                        array[j+increment]=array[j];
                    }
                    array[j+increment]=temp;
                }
            }
        }
        while(increment>1);
        return array;
    }

}
