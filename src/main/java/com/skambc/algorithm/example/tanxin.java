package com.skambc.algorithm.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class tanxin {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //下标从1开始,存储活动开始时间  
        int s[] = {0,1,3,0,5,3,5,6,8,8,2,12};  
      
        //下标从1开始,存储活动结束时间  
        int f[] = {0,4,5,6,7,8,9,10,11,12,13,14}; 
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<f.length;i++){
            map.put(f[i], s[i]);
        }
        Arrays.sort(f);
        int [] array=new int[f.length+1];
        array[1]=1;
        int j=1;
        for(int i=2;i<f.length;i++){
            if(map.get(f[i])>=f[j]){
                array[i]=1;
                j=i;
            }else{
                array[i]=0;
            }
            
        }
       for(int i=1;i<array.length;i++){
           if(array[i]==1){
               System.out.println("["+map.get(f[i])+","+f[i]+"]");
           }
       }
            
        }

    }

