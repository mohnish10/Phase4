package com.mohnish.RestfulWebServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mohnish.*")
public class SpringBootRestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulWebServicesApplication.class, args);
	}

}
