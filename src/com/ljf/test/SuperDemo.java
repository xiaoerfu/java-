package com.ljf.test;

class A{
	
	//���췽��1
	public A(){
		System.out.println("Father class");
	}
	
	//���췽��2
	public A(String name){
		System.out.println("Father class name is" + name);
	}
}

public class SuperDemo extends A{

	//���췽��1
	public SuperDemo(){
		super();
		System.out.println("child class" + "------------------" + "\n");
	}
	
	//���췽��2
	public SuperDemo(String name){
		super(name);
		System.out.println("child class name is " + name + "------------------" + "\n");
	}
	
	//���췽��3
	public SuperDemo (String name,String singer){
		this(name);
		System.out.println("child class singer is" + singer + "------------------" + "\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuperDemo();
		new SuperDemo("�Ӻ���");
		new SuperDemo("�Ӻ���","��������Ĭ");
	}

}
