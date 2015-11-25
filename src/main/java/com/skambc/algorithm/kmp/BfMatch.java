package com.skambc.algorithm.kmp;

public class BfMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ababcababa";
		String p="ababa";
		System.out.println(bfmatch(s, p));

	}
	public static int bfmatch(String s,String p)
	{
	    int i,j;
	    i=0;
	    int c=0;
	    while(i<s.length())
	    {
	        j=0;
	        while(j<p.length()&&s.charAt(i)==p.charAt(j))
	        {
	        	c++;
	            i++;
	            j++;
	        }
	        if(j==p.length()){
	        	System.out.println(c);
	        	 return i-p.length();
	        }
	           
	        i=i-j+1;                //指针i回溯
	    }
	    return -1;    
	}
	

}
