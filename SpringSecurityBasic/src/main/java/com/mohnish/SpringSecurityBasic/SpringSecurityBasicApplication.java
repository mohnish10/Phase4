package com.mohnish.SpringSecurityBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mohnish.SpringSecurityBasic")
public class SpringSecurityBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicApplication.class, args);
	}

}
