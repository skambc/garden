package com.skambc.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 
 * @author skambc
 *
 */
public class Test {
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		final Test test = new Test();

		new Thread() {
			public void run() {
				test.get(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				test.get(Thread.currentThread());
			};
		}.start();

	}

	public void get(Thread thread) {
		rwl.readLock().lock();
		try {
			long start = System.currentTimeMillis();

			while (System.currentTimeMillis() - start <= 1) {
				System.out.println(thread.getName() + "���ڽ��ж�����");
			}
			System.out.println(thread.getName() + "���������");
		} finally {
			rwl.readLock().unlock();
		}
	}
}
