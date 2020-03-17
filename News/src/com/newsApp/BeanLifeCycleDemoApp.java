package com.newsApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		
		News theNews = context.getBean("my_news", News.class);
		
		System.out.println(theNews.getDailyTemperature());
		
		context.close();

	}

}
