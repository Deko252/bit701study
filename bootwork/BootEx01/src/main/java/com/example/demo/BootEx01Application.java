package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"study.*"})
public class BootEx01Application {

	public static void main(String[] args) {
		SpringApplication.run(BootEx01Application.class, args);
	}

}
