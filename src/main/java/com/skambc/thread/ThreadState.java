package com.skambc.thread;

public class ThreadState {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();

	}

	static class TimeWaiting implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				SleepUtils.second(100);
			}
		}

	}

	static class Waiting implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}

	static class Blocked implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				synchronized (Blocked.class) {
					SleepUtils.second(100);
				}

			}
		}

	}

}
