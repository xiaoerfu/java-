package com.ljf.test;

public class LoopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = { "安居宝", "安居客", "安然"};
		for(String x : s){
			System.out.println(x);
		}
		
		int i[] = {1, 2, 3, 4};
		for(int x : i){
			if(x == 3){
				continue;
			}
			System.out.println(x);
		}
		
		Integer a1 = 100;	//创建Integer时，范围在[-128,127]
		Integer a2 = 100;
		Integer a3 = 130;
		Integer a4 = 130;
		
		System.out.println(a1 == a2);		//true 在范围内
		System.out.println(a3 == a4);		//false超出范围

		System.out.println("1--------------1");
		
		Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;
         
        System.out.println(i1==i2);
        System.out.println(i3==i4);
        
        System.out.println("2--------------2");
        
        Boolean x0 = false;
        Boolean x1 = false;
        Boolean x2 = true;
        Boolean x3 = true;
         
        System.out.println(x0==x1);
        System.out.println(x2==x3);
        System.out.println("3--------------3");
        
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
         
        System.out.println(c==d);		//true
        System.out.println(e==f);		//false
        System.out.println(c==(a+b));	//true
        System.out.println(c.equals(a+b));	//true
        System.out.println(g==(a+b));		//true
        System.out.println(g.equals(a+b));	//false
        System.out.println(g.equals(a+h));	//true
		
		
	}

}
