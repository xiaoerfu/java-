package com.ljf.test;

class RunableTest implements Runnable {

	private Thread t;
	private String threadName;

	public RunableTest(String name) {

		threadName = name;
		System.out.println("create:" + threadName);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run:" + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println(threadName + "run " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("thread: " + threadName + "intterupted");
		}
		System.out.println("thread " + threadName + "exiting.");
	}

	public void start() {
		System.out.println("thread:" + threadName + "is start");
		if (t == null) {
			t = new Thread(this,threadName);
			t.start();
		}
	}

}

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunableTest r1 = new RunableTest("thread-1");
		r1.start();
		RunableTest r2 = new RunableTest("thread-2");
		r2.start();
	}

}
