package com.newsApp;

import java.util.Random;

public class Entertainment_News implements News {
	
	private Temperature temperature;
	
	private String companyName;
	private String companyWebsite;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	@Override
	public String getNews() {
		String arr[] = {"Joshua Jackson Is \"Ready to Meet\" His Daughter",
				"Zoe Kravitz Shuts Down Fan Who Asks If She's Lightening Her Skin",
				"Jared Leto Had \"No Idea\" About Coronavirus",
				"Beverley Mitchell Is Pregnant One Year After Sharing Miscarriage",
				"Kardashians Pay Tribute to Rob Kardashian on His 33rd Birthday"};

		Random random = new Random();
		int position = random.nextInt(arr.length);

		return arr[position];
	}

	@Override
	public String getDailyTemperature() {
		return temperature.getTemperature();
	}

}
