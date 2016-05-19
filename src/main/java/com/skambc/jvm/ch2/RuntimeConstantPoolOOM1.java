package com.skambc.jvm.ch2;

public class RuntimeConstantPoolOOM1 {

		public static void main(String[] args) {
		String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja1").append("va").toString();
		System.out.println(str2.intern() == str2);
	}	}


