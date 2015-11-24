package com.skambc.algorithm.example;

public class cc {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 14;
        int h = getX(x);
//        if(getMax(h)==x){
//            if(h%2==0){
//                System.out.println(1);
//                System.out.println(h);
//            }else{
//                System.out.println(h);
//                System.out.println(1);
//            }
//           
//        }
        int max = getMax(h - 1);
        int start=max+1;
//        xstep=h-(x-max);
//        ystep=h-(x-max);
        
        if(h%2==0){
            System.out.println(1+x-start);
            System.out.println(h-(x-start));
            
        }
        else{
            
            System.out.println(h-(x-start));
            System.out.println(1+x-start);
        }
        

    }
    public static int getX(int x) {
        int i = 1;
        int sum = 0;
        boolean flag = true;
        while (flag) {
            sum += i;
            if (sum >= x) {
                return i;
            }
            i++;
        }
        return i;
    }
    public static int getMax(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;
        }

        return sum;
    }
}
