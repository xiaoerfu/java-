package com.ljf.test;

//��������ڲ����е�this
public class Test1 {

	int i = 1;

	/* ���췽�� */
	public Test1() {
		new Thread() {
			public void run() {
				while (true) {
					Test1.this.run();
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (i > 10) {
						// ���i��10��runֹͣ����
						break;
					}
				}
			}
		}.start();
	}

	protected void run() {
		System.out.println("i----" + i);
		i++;
	}

	public static void main(String[] args) {
		new Test1();
	}

}
