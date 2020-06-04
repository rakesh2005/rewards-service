package com.java.app.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.java.app.model") 
public class RewardProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardProgramApplication.class, args);
	}

}