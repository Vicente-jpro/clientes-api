package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApiApplication {

	@Value("${environment.name}")
	private String environment;

	public static void main(String[] args) {
		SpringApplication.run(ClientesApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner env() {
		return args -> {
			System.out.println(environment);
		};
	}
}
