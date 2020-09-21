package com.venaktesh.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication(scanBasePackages="com")
public class LoanApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(LoanApplication.class);
	   
	public static void main(String[] args) {
		  logger.info("Application Started");
		SpringApplication.run(LoanApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				  logger.info("CORS Policy");
				registry.addMapping("/**").allowedOrigins("https://loan-4b6a1.web.app");
			}
		};
	}
}
