package com.newsApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		News theNews = context.getBean("my_news", News.class);
		
		News alphaNews = context.getBean("my_news", News.class);
		
		boolean result = (theNews == alphaNews);
		
		System.out.println("Both references, points to same object: "+result);
		System.out.println();
		System.out.println("Memory location: "+theNews);
		System.out.println();
		System.out.println("Memory location: "+alphaNews);
		
		context.close();

	}

}
