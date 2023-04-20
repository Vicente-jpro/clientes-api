package com.example.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.core.sym.Name;

@Configuration
public class Environment {

    // @Value("${environment.name}")
    // private String environment;

    // @Bean
    // public CommandLineRunner env() {
    // return args -> {
    // System.out.println(environment);
    // };
    // }
}
