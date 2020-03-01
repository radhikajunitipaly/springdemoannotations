package com.practice.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortuneArray = {"Morning", "Afternoon", "Evening"};
	
	Random random = new Random();
	
	@Override
	public String getFortuneForToday() {
		return fortuneArray[random.nextInt(3)];
	}

}
