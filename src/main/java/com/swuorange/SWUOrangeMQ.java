package com.swuorange;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SWUOrangeMQ {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext-tx.xml", "classpath:applicationContext-mapper.xml"});
	}
}
