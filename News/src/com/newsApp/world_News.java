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
