package com.skambc.thread;

public class ThreadTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		test();

	}
	public static void test() throws InterruptedException{
		Thread t=new Thread(new Runnable() {
			
			public void run() {
				for (int i=0;i<100;i++){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("a");
				}
			}
		});
		t.start();
		for (int i=0;i<100;i++){
			Thread.sleep(10);
			System.out.println("b");
		}
		t.join();
	}
	

}
