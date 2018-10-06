package com.thinkpro.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThinkproCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkproCustomerApplication.class, args);
	}
}
