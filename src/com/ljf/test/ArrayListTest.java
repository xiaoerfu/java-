package com.ljf.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("You");
		list.add("Are");
		list.add("My");
		list.add("Love");
		
		//��һ��ʹ��foreach����List
		System.out.println("��һ��");
		for(String s : list){
			System.out.println(s);
		}
		
		//�ڶ��ֱ������������Ϊ������ص����ݽ��б���
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
//		for(String s1 : strArray){
//			System.out.println(s1);
//		}
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		//���õ��������б���
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}

}
