package com.skambc.thread;

public class DeadLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
	}

	private static String A = "A";
	private static String B = "B";

	public void deadLock() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				synchronized (A) {
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("1");
					}
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				synchronized (B) {
					synchronized (A) {
						System.out.println("2");
					}
				}

			}
		});
		t1.start();
		t2.start();
	}

}
