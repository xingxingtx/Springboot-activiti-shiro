package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.wei.*"})
@SpringBootApplication
public class ActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
	}
}
