package com.amazon.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test 
{
	public static void main(String[] args) 
	{
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.amazon");
		context.refresh();

	}

}
