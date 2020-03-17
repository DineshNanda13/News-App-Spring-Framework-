package com.newsApp;

import java.util.Random;

public class Montreal_temperature implements Temperature {

	@Override
	public String getTemperature() {
		
		String arr[] = {"Sunny", "Snow", "Rain", "Snow Storm", "Windy"};
		
		Random random = new Random();
		int position = random.nextInt(arr.length);
		
		return arr[position];

	}

}
