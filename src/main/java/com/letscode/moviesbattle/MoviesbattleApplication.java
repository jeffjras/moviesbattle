package com.letscode.moviesbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MoviesbattleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MoviesbattleApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MoviesbattleApplication.class);
	}

}
