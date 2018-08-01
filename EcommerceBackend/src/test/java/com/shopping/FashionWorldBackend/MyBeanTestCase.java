package com.shopping.FashionWorldBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBeanTestCase
{
	public static void main(String argsp[])
	{
	System.out.println("----Test Case - AnnotationConfigAplicationContext");
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	System.out.println("---Scan methodcalled---");
	context.scan("com.mobitel.MobitelBackend");
	
	System.out.println("----Refresh method called----");
	context.refresh();
	
	System.out.println("----My Bean created----");
	
	MyBean myBean1=(MyBean)context.getBean("myBean");
	
	myBean1.display();
	
	MyBean myBean2=(MyBean)context.getBean("myBean");
	
	myBean2.display();
	}

}
