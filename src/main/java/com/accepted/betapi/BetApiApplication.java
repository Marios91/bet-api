package com.accepted.betapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.accepted.betapi")
@SpringBootApplication
@EntityScan("com.accepted.betapi.domain")
public class BetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetApiApplication.class, args);
	}

}
