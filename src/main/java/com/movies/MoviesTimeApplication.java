package com.movies;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesTimeApplication {
	@Bean
	public ModelMapper getmapper()
	{
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MoviesTimeApplication.class, args);
	}

}
