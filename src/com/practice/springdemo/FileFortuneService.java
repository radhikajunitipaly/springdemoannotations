package com.practice.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	File file;
	BufferedReader br;
	Random random;
	
	@PostConstruct
	public void loadAnnotationFile() throws Exception {
		System.out.println("Post startup in file annotations");
		file = new File("C:\\workspaceForSpring\\sprin-demo-annotations\\src\\com\\practice\\springdemo\\fortunes.txt");
		br = new BufferedReader(new FileReader(file));
		random = new Random();
	}
	
	@Override
	public String getFortuneForToday() {
		System.out.println("here, trying to get today's fortune");
		int i=0;
		String st=null;
		int k=random.nextInt(3);
		System.out.println("radon value is : "+k);
		try {
			while(i<=k && (st=br.readLine())!=null ) {
				System.out.println("st is : "+st);
				i++;
				continue;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st;
	}

}
