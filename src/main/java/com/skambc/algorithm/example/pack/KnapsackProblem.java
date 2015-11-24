package com.skambc.algorithm.example.pack;

import java.util.ArrayList;

/**  
 * ��ⱳ�����⣺  
 * ���� n ���������������ֱ�Ϊ w1,w2,����,wn, ��ֵ�ֱ�Ϊ v1,v2,����,vn  
 * Ҫ�����ܳ���Ϊ totalWeight �������У�   
 * ��ɷ������ӵı�����ֵ�ܺ͵����ֵ��  
 *   
 * NOTE: ʹ�ö�̬�滮����� ��������  
 * �� ǰ n ���������ܳ���Ϊ j ������ֵΪ v[n,j], ���Žⱳ�����Ϊ b[n];  
 * �������ֵ��  
 * 1. �� j < wn, �� �� v[n,j] = v[n-1,j];  
 * 2. ��  j >= wn, ��v[n,j] = max{v[n-1,j], vn + v[n-1,j-wn]}��  
 *   
 * ������ű�����ɣ�  
 * 1. �� v[n,j] > v[n-1,j] �� ���� n ��ѡ����� b[n],   
 * 2. �������ǰ n-1 ���������� j-wn ���ܳ����У�   
 *    ����Ӧ���ж� v[n-1, j-wn] VS v[n-2,j-wn], ���� ���� n-1 �Ƿ�ѡ��  
 * 3. �������ƣ�ֱ���ܳ���Ϊ�㡣  
 *      
 *    �ص㣺 ����ʹ�ö�̬�滮���������ķ���������ʵ��˼�롣  
 *    ���������� ����ʵ�� P(n) �����Ž�S(n) �̺� ����ʵ�� P(n-1) �����Ž�S(n-1);  
 *              ��S(n-1)�Ļ����Ϲ��� S(n)   
 *    ʵ��˼�룺 �Ե����ϵĵ������ �� ���ڼ��书�ܵ��Զ����µݹ�  
 */    
public class KnapsackProblem {    
        
    /** ָ������ */    
    private Knapsack[] bags;    
        
    /** �ܳ���  */    
    private int totalWeight;    
        
    /** ������������  */    
    private int n;    
        
    /** ǰ n ���������ܳ���Ϊ totalWeight ������ֵ����  */    
    private int[][] bestValues;    
        
    /** ǰ n ���������ܳ���Ϊ totalWeight ������ֵ */    
    private int bestValue;    
        
    /** ǰ n ���������ܳ���Ϊ totalWeight �����Ž����Ʒ��� */    
    private ArrayList<Knapsack> bestSolution;    
        
    public KnapsackProblem(Knapsack[] bags, int totalWeight) {    
        this.bags = bags;    
        this.totalWeight = totalWeight;    
        this.n = bags.length;    
        if (bestValues == null) {    
            bestValues = new int[n+1][totalWeight+1];    
        }    
    }    
        
    /**  
     * ���ǰ n �������������ܳ���Ϊ totalWeight �µı�������  
     *   
     */    
    public void solve() {    
            
        System.out.println("����������");    
        for(Knapsack b: bags) {    
            System.out.println(b);    
        }    
        System.out.println("�����ܳ���: " + totalWeight);    
            
        // �������ֵ    
        for (int j = 0; j <= totalWeight; j++) {    
            for (int i = 0; i <= n; i++) {    
                
                if (i == 0 || j == 0) {    
                    bestValues[i][j] = 0;    
                }       
                else     
                {    
                    // ����� i ���������������ܳ��أ������Ž������ǰ i-1 �������У�    
                    // ע�⣺�� i �������� bags[i-1]    
                    if (j < bags[i-1].getWeight()) {    
                        bestValues[i][j] = bestValues[i-1][j];    
                    }       
                    else     
                    {    
                        // ����� i �������������ܳ��أ������Ž�Ҫô�ǰ����� i �����������Ž⣬    
                        // Ҫô�ǲ������� i �����������Ž⣬ ȡ�������ֵ����������˷������۷�    
                        // �� i ������������ iweight �ͼ�ֵ ivalue    
                        int iweight = bags[i-1].getWeight();    
                        int ivalue = bags[i-1].getValue();    
                        bestValues[i][j] =     
                            Math.max(bestValues[i-1][j], ivalue + bestValues[i-1][j-iweight]);          
                    } // else    
                } //else             
           } //for    
        } //for    
            
        // ��ⱳ�����    
        if (bestSolution == null) {    
            bestSolution = new ArrayList<Knapsack>();    
        }    
        int tempWeight = totalWeight;    
        for (int i=n; i >= 1; i--) {    
           if (bestValues[i][tempWeight] > bestValues[i-1][tempWeight]) {    
               bestSolution.add(bags[i-1]);  // bags[i-1] ��ʾ�� i ������    
               tempWeight -= bags[i-1].getWeight();    
           }    
           if (tempWeight == 0) { break; }    
        }    
        bestValue = bestValues[n][totalWeight];    
    }    
        
    /**  
     * ���ǰ  n �������� �ܳ���Ϊ totalWeight �ı�����������Ž�ֵ  
     * ���������� �����ȵ��� solve ����  
     *   
     */    
    public int getBestValue() {     
        return bestValue;    
    }    
        
    /**  
     * ���ǰ  n �������� �ܳ���Ϊ totalWeight �ı�����������Ž�ֵ����  
     * ���������� �����ȵ��� solve ����  
     *   
     */    
    public int[][] getBestValues() {    
            
        return bestValues;    
    }    
        
    /**  
     * ���ǰ  n �������� �ܳ���Ϊ totalWeight �ı�����������Ž�ֵ����  
     * ���������� �����ȵ��� solve ����  
     *   
     */    
    public ArrayList<Knapsack> getBestSolution() {    
        return bestSolution;    
    }    
        
}   
