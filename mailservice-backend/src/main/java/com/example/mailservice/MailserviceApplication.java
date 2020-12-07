package com.example.mailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MailserviceApplication {

	private static final Logger logger = LoggerFactory.getLogger(MailserviceApplication.class);
	
	public static void main(String[] args) {
		logger.debug("starting app...");
		SpringApplication.run(MailserviceApplication.class, args);
	}

}
