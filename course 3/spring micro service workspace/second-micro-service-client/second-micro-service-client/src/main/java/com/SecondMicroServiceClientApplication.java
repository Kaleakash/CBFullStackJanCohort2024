package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
public class SecondMicroServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMicroServiceClientApplication.class, args);
		System.err.println("Second micro service up!");
	}

}
