package com.skambc.algorithm.kmp;
/**
 * KMP���ʾ���Ѱ��ģʽ����ǰ׺�ͺ�׺��ͬ����󳤶ȣ�������ƥ���ʱ�����ƥ��ʧ�ܣ��ַ����Ĳ��û��ˣ�
 * ֱ�ӽ�ƥ�䴮��ǰ׺�ƹ������ŵ�ԭ����׺ռ�ĵط�������ֻ�ƶ�ģʽ������Ϊ	ǰ׺�ͺ�׺���ַ�������ȵġ�
 * �����ѵ���ǲ���ģʽ��ǰ׺�ͺ�׺��ȵĳ��ȣ���next[]���顣�������next[],�ο���http://www.cnblogs.com/dolphin0520/archive/2011/08/24/2151846.html��
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
				j = next[j]; // ������ָ��i�Ļ���
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
			if (k == -1 || p.charAt(j) == p.charAt(k)) // ƥ��������,p[j]==p[k]ababa
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
