package com.skambc.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
	static boolean flag = true;
	static Object lock = new Object();

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread NotifyThread = new Thread(new Notify(), "NotifyThread");
		NotifyThread.start();

	}

	static class Wait implements Runnable {

		public void run() {
			synchronized (lock) {
				while (flag) {
					System.out.println("flag is true"
							+ new SimpleDateFormat("HH:mm:ss")
									.format(new Date()));
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("flag is false"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}

		}

	}

	static class Notify implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			synchronized (lock) {
				System.out.println("lock notify"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				SleepUtils.second(5);
			}
			synchronized (lock) {
				System.out.println("lock get again"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(5);
			}

		}

	}

}
