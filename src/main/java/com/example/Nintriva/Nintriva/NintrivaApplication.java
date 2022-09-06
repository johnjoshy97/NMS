package com.example.Nintriva.Nintriva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;

@SpringBootApplication
public class NintrivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NintrivaApplication.class, args);
	}

}
