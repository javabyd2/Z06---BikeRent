package com.sda.spring.bikeRent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BikeRentApplication extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(BikeRentApplication.class, args);
	}


}
