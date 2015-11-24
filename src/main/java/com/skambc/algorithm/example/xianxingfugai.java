package com.skambc.algorithm.example;

public class xianxingfugai {
    public static void main(String[] args) {
        int s[] = {2,3,4,5,6,7,8,9,10,11};  
        int f[] = {3,5,7,6,9,8,12,10,13,15};  
        int TotalLength = (3-2);  
        for(int i=1,j=0;i<s.length;i++){
            if(s[i]>=f[j]){
                TotalLength+=(f[i]-s[i]);
                j=i;
            }else{
                if(f[i]<=f[j]){
                    continue;
                }else{
                    TotalLength+=(f[i]-f[j]);
                    j=i;
                }
            }
        }
        System.out.println(TotalLength);
    }

}
