package com.practice.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortuneForToday() {
		return "It is going to be a Happy day today.";
	}

}
