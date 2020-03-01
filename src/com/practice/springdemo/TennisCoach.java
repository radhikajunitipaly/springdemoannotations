package com.practice.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Value("${game.email}")
	private String email;
	@Value("${game.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	//@Autowired
	//@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach( ) {
		System.out.println("Constructing TennisCoach");
	}
	
	@Autowired
	public TennisCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
		System.out.println("is this being called? Constructing TennisCoach");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "practice Tennis for 5 minutes.";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneForToday();
	}
		
	@PostConstruct
	public void doStartupTask() {
		System.out.println("Doing post-start up tasks");
	}
	
	@PreDestroy
	public void doDestroyTask() {
		System.out.println("Doing pre destroy tasks");
	}
	
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setting fortune service");
		this.fortuneService = fortuneService;
	}*/
	
	/*@Autowired
	public void anyMethodName(FortuneService fortuneService) {
		System.out.println("from any method injecting fortune service");
		this.fortuneService = fortuneService;
	}*/

}
