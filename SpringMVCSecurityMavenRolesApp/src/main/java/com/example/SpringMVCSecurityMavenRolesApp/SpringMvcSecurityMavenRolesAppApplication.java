package com.example.SpringMVCSecurityMavenRolesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.example.SpringMVCSecurityMavenRolesApp.*")
public class SpringMvcSecurityMavenRolesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcSecurityMavenRolesAppApplication.class, args);
	}

}
