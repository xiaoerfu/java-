package com.ljf.test;

//匿名类和内部类中的this
public class Test1 {

	int i = 1;

	/* 构造方法 */
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
						// 如果i》10，run停止运行
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
