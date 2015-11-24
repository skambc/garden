package com.skambc.json2ben;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tee {
	private String vMware;
	private String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getvMware() {
		return vMware;
	}

	public void setvMware(String vMware) {
		this.vMware = vMware;
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Tee t=new Tee();
		FormatModel.setDefaultValue(t);
		System.out.println(t.getvMware());
		 Method [] methods=t.getClass().getDeclaredMethods();
		 for(Method m:methods){
			 System.out.println(m.getName());
		 }
	}

}
