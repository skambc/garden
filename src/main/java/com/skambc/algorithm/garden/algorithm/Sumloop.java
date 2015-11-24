package com.skambc.algorithm.garden.algorithm;

public class Sumloop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sumLoop(2,3);
	}
	public static void sumLoop(int a,int loop){
		int t=0;
		int s=0;
		for(int i=0;i<loop;i++){
			t=a+t*10;
			s=s+t;
		}
		System.out.println(s);
	}

}
