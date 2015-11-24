package com.skambc.algorithm.example;


public class compose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=23;
		int num2=123;
		int a[] ={23,123,45,21};
		int temp;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(!compare(a[j],a[j+1])){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					
				}
			}
		}
		for(int s:a){
			System.out.println(s);
		}

	}
	public static boolean compare(int num1,int num2){
		int count1=0;
		int count2=0;
		int t1=num1;
		int t2=num2;
		while(num1!=0){
			count1++;
			num1=num1/10;
		}
		while(num2!=0){
			count2++;
			num2=num2/10;
		}
		int a= (int) ((int)t1*Math.pow(10, count2)+t1);
		int b=(int) ((int)t2*Math.pow(10, count1)+t1);
//		System.out.println(a);
//		System.out.println(b);
		
		return a>b?true:false;
	}

}
