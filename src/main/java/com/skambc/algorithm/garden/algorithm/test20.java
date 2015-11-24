package com.skambc.algorithm.garden.algorithm;

public class test20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float fz=2;
		float fm=1;
		float sum=0;
		
		for(int i=0;i<20;i++){
			float temp=fz;
			sum=sum+fz/fm;
			fz=fz+fm;
			fm=temp;
		}
		System.out.println(sum);
	}

}
