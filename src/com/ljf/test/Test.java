package com.ljf.test;

import java.util.Random;

public class Test {
	
	String s = "hello";
	public Test(String s){
		System.out.println(s);
		System.out.println("1----" + this.s );
		this.s = s;
		System.out.println("2----" + this.s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test("gogoing");
		System.out.println("四舍五入：" + Math.round(11.2));			//四舍五入
		System.out.println("向上取整：" + Math.ceil(12.3));			//向上取整
		System.out.println("向下取整：" + Math.floor(12.3)); 			//向下取整	
		System.out.println(Math.sqrt(4));
//		Random random = new Random();
		int i = (int)(Math.random()*100);
		System.out.println(i);
		long s = 12;
		float y = s;
		System.out.println(y);
	}

}
