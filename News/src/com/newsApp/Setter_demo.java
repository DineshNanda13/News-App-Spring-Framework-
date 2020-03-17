package com.newsApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Setter_demo {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Entertainment_News theNews = context.getBean("my_entertainment_news", Entertainment_News.class);
		
		System.out.println("Entertainment News:\n"+theNews.getNews());
		System.out.println();
		System.out.println("Today is:\n"+theNews.getDailyTemperature());
		
		System.out.println();
		System.out.println("News Channel: "+theNews.getCompanyName());
		System.out.println("Website: "+theNews.getCompanyWebsite());
		
		context.close();

	}

}
