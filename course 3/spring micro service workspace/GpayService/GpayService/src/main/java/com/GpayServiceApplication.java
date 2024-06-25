package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient
public class GpayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpayServiceApplication.class, args);
		System.err.println("Gpay micro service up!");
	}

	@Bean					// this method is responsible to create the object of type RestTemplate 
	@LoadBalanced			// scale up and scale down on demand and we can call micro service by name rather than 
								// physical ip address with port number. 
	public RestTemplate restTemplate() {
		System.out.println("object created...");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
