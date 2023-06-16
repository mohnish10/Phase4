package com.mohnish.ConsumeRestfulServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mohnish.*")
public class ConsumeRestfulServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestfulServicesApplication.class, args);
	}

}
