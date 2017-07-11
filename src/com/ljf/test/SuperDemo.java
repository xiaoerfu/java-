package com.ljf.test;

class A{
	
	//构造方法1
	public A(){
		System.out.println("Father class");
	}
	
	//构造方法2
	public A(String name){
		System.out.println("Father class name is" + name);
	}
}

public class SuperDemo extends A{

	//构造方法1
	public SuperDemo(){
		super();
		System.out.println("child class" + "------------------" + "\n");
	}
	
	//构造方法2
	public SuperDemo(String name){
		super(name);
		System.out.println("child class name is " + name + "------------------" + "\n");
	}
	
	//构造方法3
	public SuperDemo (String name,String singer){
		this(name);
		System.out.println("child class singer is" + singer + "------------------" + "\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuperDemo();
		new SuperDemo("钟汉良");
		new SuperDemo("钟汉良","何以笙箫默");
	}

}
