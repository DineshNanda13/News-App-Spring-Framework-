# News-App-Spring-Framework-
Illustration of Bean scopes and Bean life cycle along with spring IOC and spring dependency injection 

//File name : beanScope-applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- add entry to enable component scanning -->

	<context:component-scan
		base-package="com.newsApp" />
		
	<!-- extra service class -->
	
	<bean
	id = "my_temp"
	class = "com.newsApp.Montreal_temperature">
	</bean>
		
	<bean
	
	id = "my_news"
	class = "com.newsApp.world_News"
	scope="prototype">
	
	<constructor-arg ref = "my_temp"></constructor-arg>
	
	</bean>
		
</beans>

//File name : BeanScopeDemoApp.java

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

File Name : beanLifecycle-applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- add entry to enable component scanning -->

	<context:component-scan
		base-package="com.newsApp" />
		
	<!-- extra service class -->
	
	<bean
	id = "my_temp"
	class = "com.newsApp.Montreal_temperature">
	</bean>
		
	<bean
	
	id = "my_news"
	class = "com.newsApp.world_News"
	init-method="startUp"
	destroy-method="cleanUp">
	
	<constructor-arg ref = "my_temp"></constructor-arg>
	
	</bean>
		
</beans>

//File name : BeanLifeCycleDemoApp.java

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

// File name : world_news.java

package com.newsApp;

import java.util.Random;

public class world_News implements News {
	
	private Temperature temperature;
	
	public world_News(Temperature temperature) {
		super();
		this.temperature = temperature;
	}

	@Override
	public String getNews() {
		
		String arr[] = {"Coronavirus pandemic puts countries on lockdown", "4 NBAers test positive for COVID-19", 
				"IPL 2020 suspended until April 15 amid COVID-19 pandemic", "Quebec now has 74 cases of COVID-19",
				"Iran warns virus could kill 'millions' in Islamic Republic"};
		
		Random random = new Random();
		int position = random.nextInt(arr.length);
		
		return arr[position];
		
	}
	
	public String getDailyTemperature() {
		
		return temperature.getTemperature();
		
	}
	
	public void startUp() {
		System.out.println("world_news: startUp method");
	}
	
	public void cleanUp() {
		System.out.println("world_news: cleanUp method");
	}
}

//File name : News.java

package com.newsApp;

public interface News {
	
	public String getNews();
	
	public String getDailyTemperature();

}








