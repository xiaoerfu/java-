package com.ljf.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.xml.crypto.Data;

/*
 * Character运用于单个字节符操作
 */
public class CharacterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character c = 'x';
		System.out.println(c.toString());

		String y;
		y = String.format("浮点型变量的的值为 " + "%f, 整型变量的值为 " + " %d, 字符串变量的值为 " + " %s", 1.2, 12, "123");
		System.out.println(y);

		StringBuffer stringBuffer = new StringBuffer("我们的Love");
		System.out.println(stringBuffer.reverse());		//反转字符串
		
		/*
		 * 日期的Demo
		 */
		SimpleDateFormat bartDateFormat = new SimpleDateFormat
				("yyyy年MM月dd日 EEE HH:mm:ss");
		Date date = new Date();
		DateFormat longDateFormat = DateFormat.getDateTimeInstance
            		(DateFormat.LONG,DateFormat.LONG); 
		System.out.println(bartDateFormat.format(date));
		System.out.println(longDateFormat.format(date));
		System.out.printf("yyyy年MM月dd日 EEE HH:mm:ss %tT%n", date);
		

		String s[][] = new String[2][3];
		s[0][0] = new String("Good");
		s[0][1] = new String("Luck");
		s[0][2] = new String("__");
		s[1][0] = new String("to");
		s[1][1] = new String("you");
		s[1][2] = new String("!");
		for(int a=0; a<s.length; a++){
			for(int b=0; b<s[a].length; b++){
				System.out.println(s[a][b]);
			}
		}
		
	}

}
