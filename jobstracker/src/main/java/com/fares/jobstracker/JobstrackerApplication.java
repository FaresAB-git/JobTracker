package com.fares.jobstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JobstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobstrackerApplication.class, args);
	}

}
