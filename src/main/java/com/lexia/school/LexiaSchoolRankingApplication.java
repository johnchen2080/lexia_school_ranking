package com.lexia.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan("com.lexia.school")
@Import(SchoolClientConfig.class)
@SpringBootApplication
public class LexiaSchoolRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LexiaSchoolRankingApplication.class, args);
	}

}
