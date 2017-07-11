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
		
		//第一种使用foreach遍历List
		System.out.println("第一种");
		for(String s : list){
			System.out.println(s);
		}
		
		//第二种遍历，把链表变为数组相关的内容进行遍历
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
//		for(String s1 : strArray){
//			System.out.println(s1);
//		}
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		//采用迭代器进行遍历
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}

}
