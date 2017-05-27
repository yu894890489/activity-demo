package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		String conf = "spring-mybatis.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
	}
}
