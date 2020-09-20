package com.venaktesh.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages="com")
//@ComponentScan(basePackageClasses = LoanController.class)
//@EntityScan("com.venaktesh.loan.Loan")
//@EnableMongoRepositories({"com.venaktesh.loan.LoanRepository"})

//@ComponentScan({"com.venaktesh.loan.LoanRepository","com.venaktesh.loan.WebConfig"})
public class LoanApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
}
