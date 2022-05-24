package com.rtr.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RootToRiseApiApplication {
	private static final Logger log = LoggerFactory.getLogger(RootToRiseApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RootToRiseApiApplication.class, args);
	}

}
