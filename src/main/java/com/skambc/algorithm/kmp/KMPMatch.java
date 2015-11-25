package com.skambc.algorithm.kmp;
/**
 * KMP本质就是寻找模式串的前缀和后缀相同的最大长度，这样在匹配的时候，如果匹配失败，字符串的不用回退，
 * 直接将匹配串的前缀移过来，放到原来后缀占的地方，这样只移动模式串。因为	前缀和后缀的字符串是相等的。
 * 所有难点就是查找模式串前缀和后缀相等的长度，即next[]数组。如果计算next[],参考：http://www.cnblogs.com/dolphin0520/archive/2011/08/24/2151846.html；
 * http://www.matrix67.com/blog/archives/115
 * @author jinhd
 *
 */

public class KMPMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcababa";
		String p = "ababa";
		System.out.println(KMPMatch(s, p));

	}

	public static int KMPMatch(String s, String p) {
		int[] next;
		int i, j;
		i = 0;
		j = 0;
		next = getNext(p);
		int c = 0;
		while (i < s.length()) {
			c++;
			if (j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j]; // 消除了指针i的回溯
			}
			if (j == p.length()) {
				System.out.println(c);
				return i - p.length();
			}

		}
		return -1;
	}

	public static int[] getNext(String p) {
		int[] next = new int[p.length()];
		int j, k;
		next[0] = -1;
		j = 0;
		k = -1;
		while (j < p.length() - 1) {
			if (k == -1 || p.charAt(j) == p.charAt(k)) // 匹配的情况下,p[j]==p[k]ababa
			{
				j++;
				k++;
				next[j] = k;
			} else
				// p[j]!=p[k]
				k = next[k];
		}
		return next;
	}

}
