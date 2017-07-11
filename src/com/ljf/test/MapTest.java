package com.ljf.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String , String> map = new HashMap<String , String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");
		
		//第一种：普遍使用，二次取值
		System.out.println("通过Map.keyset遍历key和value");
		for(String key : map.keySet()){
			System.out.println("key = " + key + " and value=" + map.get(key));
		}
		
		//第二种
		System.out.println("通过遍历Map.entrySet使用iterator遍历key和value");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.println("key=" + entry.getKey() + "value=" + entry.getValue());
		}
		
		//第三种，容量大使用,for( : )
		System.out.println("通过Map.keyset遍历key和value");
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println("key=" + entry.getKey() + "value=" + entry.getValue());
		}
		
		//第四种
		System.out.println("只能遍历value，不能遍历key");
		for(String v : map.values()){
			System.out.println("value is" + v);
			
		}
	}

}
