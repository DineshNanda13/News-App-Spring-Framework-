package com.newsApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NewsApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		News theNews = context.getBean("my_news", News.class);
		
		System.out.println("Breaking News:\n"+theNews.getNews());
		System.out.println();
		System.out.println("Today is:\n"+theNews.getDailyTemperature());
		
		context.close();

	}

}
