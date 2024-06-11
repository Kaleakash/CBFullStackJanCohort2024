package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiWithJpaApplication.class, args);
		System.out.println("spring boot up");
	}

}
