package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// it scan current package as well as sub package of current package. 
@SpringBootApplication(scanBasePackages = "com") //Enable @RestController, @Service and @Repository annotation
@EntityScan(basePackages = "com.entity")   // Enable @Entity annotation 
@EnableJpaRepositories(basePackages = "com.dao")  // Enable jpa features 
public class SpringBootRestApiWithDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiWithDataApplication.class, args);
		System.out.println("spring boot up");
	}

}
