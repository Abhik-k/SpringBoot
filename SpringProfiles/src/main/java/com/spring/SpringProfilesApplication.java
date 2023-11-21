package com.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringProfilesApplication {
	
	@Autowired
	Environment environment;
	
	public static final Log LOGGER = LogFactory.getLog(SpringProfilesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProfilesApplication.class, args);
	}
	
	public void run(String...args) throws Exception{
		LOGGER.info(environment.getProperty("message"));
	}

}
