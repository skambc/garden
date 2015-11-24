package com.skambc.algorithm.example;

public class zhaoling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] MoneyClass = { 100, 50, 20, 10, 5, 1 }; // 记录钱的面值
		int[] MoneyIndex = new int[MoneyClass.length];
		int money=123;
		int moneycount=0;
		int count=0;
		for(int i=0;i<MoneyClass.length;){
			if(moneycount+MoneyClass[i]>money){
				i++;
				continue;
			}
			moneycount+=MoneyClass[i];
			MoneyIndex[i]++;
			count++;
			if(moneycount==money){
				break;
			}
		}
		System.out.println("张数"+count);
		for(int a=0;a<MoneyClass.length;a++){
			System.out.println(MoneyClass[a]+":"+MoneyIndex[a]);
		}
	}

}
