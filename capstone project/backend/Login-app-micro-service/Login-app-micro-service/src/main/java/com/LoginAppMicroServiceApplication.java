package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.eshopping")
@EntityScan(basePackages = "com.eshopping.entity")
@EnableJpaRepositories(basePackages = "com.eshopping.repository")
@EnableDiscoveryClient(autoRegister = true)
public class LoginAppMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAppMicroServiceApplication.class, args);
		System.err.println("login micro service up on port number 8181");
	}

}
