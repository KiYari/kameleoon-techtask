package com.kameleoon.techtask;

import com.kameleoon.techtask.model.User;
import com.kameleoon.techtask.services.UserService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechtaskApplication {
	private final UserService userService;

	public TechtaskApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TechtaskApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@PostConstruct
	public void postInit() {
		System.out.println("Users: " + userService.findAll());
	}
}
